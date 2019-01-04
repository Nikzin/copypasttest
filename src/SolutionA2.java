import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionA2 {

    public void solve() {
        String inputLine;
        String outputLine = "";

        try {
            Scanner scanner = new Scanner(new File("OrderValidator.txt"));
            while (scanner.hasNext()) {
                inputLine = scanner.nextLine();
                String regexString = Pattern.quote("OrderValidatorException(\"") + "(.*?)" + Pattern.quote("\"");
                Pattern pattern = Pattern.compile(regexString);
                Matcher matcher = pattern.matcher(inputLine);

                while (matcher.find()) {
                    String msg = matcher.group(1);
                    //edit, to lowercase, except first letter.
                    msg=msg.toLowerCase();
                    msg = msg.substring(0, 1).toUpperCase() + msg.substring(1);


                    System.out.println(msg);
                }
            }
            scanner.close();
        } catch (Exception e) {
        }
    }
}

