package compareTexts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import org.springframework.util.FileSystemUtils;




public class Comparator {
    public void extractLines(String stock) throws IOException {
        //Search 1: Find lines that exist in merged file but missed in both: producer and lec
        // 1. hitta file from sources Lec and producer
        // 2. for each line in source(Lec and producer) find a line in merged file, if no log.

        //search1();

        //Search 2: Find lines that exist in producer or in lec but missed in merged file:
        //1. for all files in Producer/Lec source files find file i merged files: if no file log!
        //2. in each file in Producer/Lec for each line find line in merged file before separator "=" if no line Log!

        // search2("sourceProducerFiles/");
        // search2("sourceLecFiles/");

        //Search3
        // Same as Search 2 but additionally compare parts after "=" just in case to see if all corections were made correct. Time consuming to look in result later
        // search3("sourceProducerFiles/");
        search3("sourceLecFiles/");
    }
 /*   private void mergeFiles(String sourceDir1, String sourceDir2 ) throws IOException {
        File sourceFilesFolder1 = new File(sourceDir1);
        File[] listOfsourceFiles1 = sourceFilesFolder1.listFiles();

        File sourceFilesFolder2 = new File(sourceDir2);
        File[] listOfsourceFiles2 = sourceFilesFolder2.listFiles();

        //1 copy all files from sourceDir1 to merged

        for (File sourceFile : listOfsourceFiles1) {
            Path sourceFilePath1 = sourceFile.toPath();

            File mergedFileName = findFilename(sourceFile, "mergedFiles/");


            if (mergedFileName != null) {
                Scanner scanner = new Scanner(sourceFilePath1);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();

                    Boolean foundForSplittedLine = searchsplittedLine(mergedFileName, line);
                    if (!foundForSplittedLine) {
                        System.out.println("NOT FOUND line " + line + " IN FILE " + sourceFilePath);
                    }
                }
                scanner.close();
            } else {
                System.out.println("No file found for source FILENAME: " + sourceFile);
            }
        }
        //Find and add missing lines from sourceDir1 to merged
        for (File sourceFile : listOfsourceFiles1) {
            Path sourceFilePath1 = sourceFile.toPath();
            File mergedFileName = findFilename(sourceFile, "mergedFiles/");


            if (mergedFileName != null) {
                Scanner scanner = new Scanner(sourceFilePath1);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();

                    Boolean foundForSplittedLine = searchsplittedLine(mergedFileName, line);
                    if (!foundForSplittedLine) {
                        System.out.println("NOT FOUND line " + line + " IN FILE " + sourceFilePath);
                    }
                }
                scanner.close();
            } else {
                System.out.println("No file found for source FILENAME: " + sourceFile);
            }
        }
    }*/



    private void search1() throws IOException {
        File mergedFilesFolder = new File("mergedFiles/");
        File[] listOfmergedFiles = mergedFilesFolder.listFiles();

        for (File mergedFile : listOfmergedFiles) {

            Path mergedFilePath = mergedFile.toPath();
            File producerFileName = findFilename(mergedFile, "sourceProducerFiles/");
            File lecFilName = findFilename(mergedFile, "sourceLecFiles/");

            Scanner scanner = new Scanner(mergedFilePath);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                Boolean foundForProducerLine = false;
                Boolean foundForLecLine = false;

                if (producerFileName != null) {
                    foundForProducerLine = searchLineInFile(producerFileName.toPath(), line);
                }
                if (lecFilName != null) {
                    foundForLecLine = searchLineInFile(lecFilName.toPath(), line);
                }
                if (!foundForLecLine && !foundForProducerLine) {
                    System.out.println("NOT FOUND line " + line + " IN FILE " + mergedFilePath);
                }
            }
            scanner.close();
        }
    }

    private void search2(String sourceDir) throws IOException {
        File sourceFilesFolder = new File(sourceDir);
        File[] listOfsourceFiles = sourceFilesFolder.listFiles();
        for (File sourceFile : listOfsourceFiles) {
            Path sourceFilePath = sourceFile.toPath();
            File mergedFileName = findFilename(sourceFile, "mergedFiles/");
            if (mergedFileName != null) {
                Scanner scanner = new Scanner(sourceFilePath);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    Boolean foundForSplittedLine = searchsplittedLine(mergedFileName, line);
                    if (!foundForSplittedLine) {
                        System.out.println("NOT FOUND line " + line + " IN FILE " + sourceFilePath);
                    }
                }
                scanner.close();
            } else {
                System.out.println("No file found for source FILENAME: " + sourceFile);
            }
        }
    }

    private void search3(String sourceDir) throws IOException {
        File sourceFilesFolder = new File(sourceDir);
        File[] listOfsourceFiles = sourceFilesFolder.listFiles();
        for (File sourceFile : listOfsourceFiles) {
            Path sourceFilePath = sourceFile.toPath();
            File mergedFileName = findFilename(sourceFile, "mergedFiles/");
            if (mergedFileName != null) {
                Scanner scanner = new Scanner(sourceFilePath);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    Boolean foundForSplittedLine = searchsplittedLine2(mergedFileName, line);
                    if (!foundForSplittedLine) {
                        System.out.println("NOT FOUND line " + line + " IN FILE " + sourceFilePath);
                    }
                }
                scanner.close();
            } else {
                System.out.println("No file found for source FILENAME: " + sourceFile);
            }
        }
    }

    private Boolean searchsplittedLine(File searchedFilePath, String searchedLine) throws FileNotFoundException {
        Boolean found = false;
        String[] searchedLineSplitted = searchedLine.split("=");
        if (searchedLineSplitted.length >= 1) {
            Scanner scanner = new Scanner(searchedFilePath);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineSplitted = line.split("=");
                if (lineSplitted[0].equals(searchedLineSplitted[0])) {
                    found = true;
                }
            }
            scanner.close();
        }
        return found;
    }

    private Boolean searchsplittedLine2(File mergedFilePath, String searchedLine) throws FileNotFoundException { //searchedLine is from source, merged file is target
        Boolean firsthalfFound = false; //searchedLine first half in mergedFile
        Boolean secondHalNotfEqual = false;
        String firsthalfEqualLine = "";
        String[] searchedLineSplitted = searchedLine.split("=");
        if (searchedLineSplitted.length >= 1) {
            Scanner scanner = new Scanner(mergedFilePath);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");


            while (scanner.hasNext()) {
                Boolean foundNow = false;
                String line = scanner.nextLine();
                String[] lineSplitted = line.split("=");

                if ((lineSplitted.length == searchedLineSplitted.length) && (lineSplitted[0].equals(searchedLineSplitted[0]))) {
                    firsthalfFound = true;
                    foundNow = true;
                    firsthalfEqualLine = line;
                }
                if (foundNow) {
                    for (int i = 1; i < lineSplitted.length; i++) {
                        if (!lineSplitted[i].equalsIgnoreCase(searchedLineSplitted[i])) {
                            secondHalNotfEqual = true;
                        }
                    }
                }
                if (firsthalfFound && secondHalNotfEqual && foundNow) {
                    System.out.println("difference in lines: in file " + mergedFilePath);
                    System.out.println("source line:" + searchedLine);
                    System.out.println("merged line:" + firsthalfEqualLine);
                }
            }
            scanner.close();
        }
        return firsthalfFound;
    }


    private File findFilename(File mergedFile, String dirName) {
        File result = null;
        File sourceFilesFolder = new File(dirName);

        File[] sourceFiles = sourceFilesFolder.listFiles();
        for (File sourceFile : sourceFiles) {

            if (mergedFile.getName().equals(sourceFile.getName())) {
                result = sourceFile;
            }
        }
        return result;
    }

    private Boolean searchLineInFile(Path searchedFilePath, String searchedLine) throws IOException {
        Boolean found = false;
        Scanner scanner = new Scanner(searchedFilePath);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals(searchedLine)) {
                found = true;
            }
        }
        scanner.close();
        return found;
    }

}
