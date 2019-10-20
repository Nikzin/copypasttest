import compareTexts.Comparator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

      // new SolutionA3().solve();
    //   new Test1().test();
     //  new Test2().test();
        //new Test3().test();
        //new Test4().test();
       // new Test5().test(); //bigDecimal add substract
        //new Test6().test(); // exception catch test

        try {
            new Comparator().extractLines("TEVA"); //check balance stocks
        } catch (IOException e) {
            e.printStackTrace();
        }
        // new SolutionB().test(new Cat());
       // new TestEquals().run();
        //new TestObjectCloning().run();
        //new TestStream().run();
       // new VerySimpleTest().run();
      /*  VerySimpleTest vt= new VerySimpleTest();
        System.out.println(vt.ts);
        if (false==vt.ts){
            System.out.println("blabla");
        }*/
    }
}