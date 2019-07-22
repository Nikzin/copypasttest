import java.lang.reflect.Array;

public class Test6 {
    public void test() {
        try {
            Integer[] testArr = {1, 2};
            testArr=null;
            int j= testArr.length;
            System.out.println("test");
            Integer i = testArr[4];

            System.out.println(i);
        }
        catch (ArrayIndexOutOfBoundsException|NullPointerException e) {
            System.out.println(e);
        }
    }
}
