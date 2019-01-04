import static java.util.Objects.compare;

//import java.util.Objects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.compare;

public class VerySimpleTest {
    public boolean ts;
    public void run() {
        Boolean e1 = null ;
        String s1="aab";
        String s2="aab";
        Boolean  e2 = false;
        List<String> l1 = new ArrayList<>();
       // List<String> l1 =null;
        //new ArrayList<>();
      /*  for (int i = 0; i < l1.size(); i++) {
            System.out.println("empty");
        }*/
        l1.add("a");
       // l1.add("b");
        List<String> l2 = new ArrayList<>();
      l2.add("a");
       // l2.add("b");
        Integer i1=674648;
        int i2=677565;
       Boolean b= (!(Objects.equals(s1, s2)));
        System.out.println(b);

       // System.out.println(b+"i1: "+ i1);
       // System.out.println("i2: "+ i2);


    }





}

