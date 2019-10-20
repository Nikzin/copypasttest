package compareTexts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Comparator {
    private List<String[]> othersList = new ArrayList<>();
    private List<String[]> buyList = new ArrayList<>();
    private List<String[]> sellList = new ArrayList<>();

    public void extractLines(String stock) throws IOException {
        File mergedFilesFolder = new File("mergedFiles/");
        File[] listOfmergedFiles = mergedFilesFolder.listFiles();

        for (File mergedFile : listOfmergedFiles) {
            // 1. hitta file from sources Lec and producer
            // 2. for each line in source(Lec and producer file: make a univerasal method) find a line in merged file, if no log as error)

            // System.out.println(file.getName());
            Path mergedFilePath = mergedFile.toPath();
          //  System.out.println(mergedFilePath);


            File tempName = findFilename(mergedFile);
        //    System.out.println(tempName);
            if (tempName != null) {
                Path producerFilePath = tempName.toPath();
                Scanner scanner = new Scanner(producerFilePath);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
                while (scanner.hasNext()) {
                    String producerLine = scanner.nextLine().trim();
                    //   System.out.println(line);

                    Boolean foundForProducerLine = searchLineInFile(mergedFilePath, producerLine);
                    if (foundForProducerLine) {
                        // System.out.println("found!!!!!!!!! " + producerLine + " in file " + mergedFilePath);
                    } else {
                     //   System.out.println("not found!!!!!!!!! " + producerLine + " in file " + mergedFilePath);
                    }


                }
                scanner.close();
            }


        }


/*        Scanner scanner = new Scanner(mergedFilePath);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            //   System.out.println(line);
        }
        scanner.close();*/


    }

    private File findFilename(File mergedFile) {
        File result = null;
        File producerFilesFolder = new File("sourceProducerFiles/");

        File[] producerFiles = producerFilesFolder.listFiles();
        for (File producerFile : producerFiles) {

            if (mergedFile.getName().equals(producerFile.getName())) {
                result = producerFile;

            }
        }
        return result;
    }







        /*try {
            Path source = listOfmergedFiles[0].toPath();
            Scanner scanner = new Scanner(source);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.trim().split("\\s+");

                if (words.length >= 1) {
                    if (containOneTerm(words, stock) && containOneTerm(words, "köpt")) {
                        buyList.add(words);
                    } else if (containOneTerm(words, stock) && containOneTerm(words, "sålt")) {
                        sellList.add(words);
                    } else if (containOneTerm(words, stock)) {
                        othersList.add(words);
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String buyFileName="soursefiles/buy"+stock+".txt";
        String sellFileName="soursefiles/sell"+ stock+".txt";
        writeFile(buyFileName, buyList);
        writeFile(sellFileName, sellList);
        if (othersList.size() > 0) {
            writeFile("soursefiles/other.txt", othersList);
        }*/


    private Boolean searchLineInFile(Path mergedFilePath, String producerLine) throws IOException {
        Boolean found = false;
        Scanner scanner = new Scanner(mergedFilePath);//sometimes need , Scanner scanner = new Scanner(listOfFiles[0], "utf-8");
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.equals(producerLine)) {
                //if (line.equals("interface.help.customer.creditCardType=Resekonto: Ange vilken typ av resekonto")) {
                //System.out.println("stop here");
                //   System.out.println("found line in file " + mergedFilePath + " " + producerLine);
                found = true;
            }
            //   System.out.println(line);
        }
        scanner.close();

if (!found){
    System.out.println("debub stop here");
}
        return found;
    }

    private void writeFile(String fileName, List<String[]> list) {
        try {

            FileWriter fw = new FileWriter(fileName); //the true will append the new data


            for (String[] spLine : list) {
                //check format if it's different than in method below
                String currentLine = getSpLine(spLine);//if something wrong in format it will write line to othersList
                System.out.println(currentLine);
                fw.write(currentLine + "\n");//appends the string to the file
            }

            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    private void printSpLine(String[] spLine) {
        String totalLine = "";
        for (String spWord : spLine) {
            totalLine = totalLine + spWord + " ";
        }
        System.out.println(totalLine);
    }

    private String getSpLine(String[] spLine) {
        String totalLine = "";
        int i = 0;
        try {
            totalLine += spLine[i] + "\t";
            i++; //date
            totalLine += spLine[i] + "\t";
            i++; //kopt
            totalLine += spLine[i] + "\t";
            i++; //mq
            if (spLine[i].length() == 1) {
                totalLine += spLine[i] + spLine[i + 1] + "\t";//amount
                i++;
                i++;
            } else {
                totalLine += spLine[i] + "\t"; //amount
                i++;
            }
            String price = spLine[i].replace(",", ".");
            totalLine += price + "\t";//price
            i++; //price
        } catch (Exception e) {
            this.othersList.add(spLine);
            e.printStackTrace();
        }
        return totalLine;
    }

    private boolean containOneTerm(String[] words, String mq) {
        boolean contain = false;
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(mq)) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        }
        return contain;
    }
}
