import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SolutionA {

    public void solve() {
        String inputLine;
        String outputLine = "";
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
//private long recordNo;
            inputLine = scanner.nextLine();
            inputLine = inputLine.replace(";", "");
            //   System.out.println(inputLine);
            try {
                String[] words = inputLine.split("\\s+");
                //  outputLine = "<li> " + words[3] + ": {{data1." + words[3] + "}}</li>";
                //  outputLine = "<li> " + words[3] + ": {{treeCard.fcFinalEntry." + words[3] + "}}</li>";
                outputLine = "<tr>\n" +
                        "<td class=\"headClear\">" + words[3] + "</td>\n" +
                        "<td class=\"clear\">{{$ctrl.dinersTransactionOtherList2." + words[3] + "}}</td>\n" +
                        "</tr>";
                System.out.println(outputLine);
            } catch (Exception e) {
                System.out.println("Error with: " + inputLine);
            }
        }
    }
}
/*
    private String name;
    private int customerNo;
    private long orgNo;


    private boolean invoiceFee;
    private int invoiceFeeAmount;
    private int officeNo;
    private Date registered;
*/


/*<tr>
<td class="headClear">recordNo</td>
<td class="clear">{{$ctrl.treeDiners.dinersFileHeaderRecord.recordNo}}</td>
</tr>*/
//    <li> recordType: {{treeCard.fcFinalEntry.recordType}}</li>