public class Test1 {
    public void test() {
       if (null!=exist() && exist()) {
           System.out.println("null check");
       }
    }
    Boolean exist(){
        return true;
    }
}
