import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SolutionA3 {

    public void solve() {
        String inputLine;
        String outputLine = "";

        try {

           FileWriter kopt = new FileWriter("kopt.txt", false);
            FileWriter sold = new FileWriter("sold.txt", false);
          //  BufferedWriter bw = new BufferedWriter(fw);
            //PrintWriter out = new PrintWriter(bw);


            Scanner scanner = new Scanner(new File("myfile.txt"));

            while (scanner.hasNext()) {
                inputLine = scanner.nextLine();
               // inputLine =inputLine.replace("\0", "");
               if (inputLine.contains("SÅLT")){
                    outputLine=inputLine;
                  sold.write(outputLine+ "\n");
              }
                if (inputLine.contains("KÖPT")){
                    outputLine=inputLine;
                    kopt.write(outputLine+ "\n");
                }
                String[] ws = inputLine.split("\\s+");
              Stream.of(ws).forEach(s->{
                  System.out.println(s+" "+ s.length());
                  //Stream<Character> sch = s.chars().mapToObj(i -> (char)i);
                  //sch.forEach(ch -> System.out.println((int)ch));
              } );
         /*     Stream.of(ws).filter(s->s.contains("GE"))
                        .forEach(s->System.out.println (s+" hhhhhhhhhhhhhhhhhhhhhhhhh"));*/
             /*   boolean flaag = Arrays.stream(ws).anyMatch("GEEEE"::contains);
                if (flaag){
                    outputLine=inputLine;

                    fw.write(outputLine+ "\n");
                }*/

             //   outputLine = ws[0] + " " + ws[1];// + " " + ws[2] + " " + ws[3];

           // System.out.println(outputLine);


                //fw.write(outputLine);
            }

            scanner.close();

           sold.close();
           kopt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}