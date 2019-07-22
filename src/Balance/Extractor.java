package Balance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Extractor {
    private List<String[]> othersList = new ArrayList<>();
    private List<String[]> buyList = new ArrayList<>();
    private List<String[]> sellList = new ArrayList<>();

    public void extractLines() {
        try {
            File file = new File("2019MQ.txt");//could be changed here
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");

                if (words.length >= 1) {
                    if (containOneTerm(words, "mq") && containOneTerm(words, "k�pt")) {
                        buyList.add(words);
                    } else if (containOneTerm(words, "mq") && containOneTerm(words, "s�lt")) {
                        sellList.add(words);
                    } else if (containOneTerm(words, "mq")) {
                        othersList.add(words);
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeFile("buyMQ.txt", sellList);
        writeFile("sellMQ.txt", sellList);
        if (othersList.size() > 0) {
            writeFile("other.txt", othersList);
        }
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
        int i = 1;
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
