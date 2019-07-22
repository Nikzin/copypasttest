import java.math.BigDecimal;

public class Test5 {
    public void test() {
        BigDecimal bd = new BigDecimal(0);
        BigDecimal bdn = new BigDecimal(10);
        bd = bd.add(new BigDecimal(30));
        bd=bd.negate();
       // bdn =bdn.add(bd.negate());
        bdn = bdn.add(bd);
        System.out.println(bdn);

    }
}
