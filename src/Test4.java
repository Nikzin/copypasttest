public class Test4 {
    public void test() {
        TestObj testObj=new TestObj();
        TestObj nullTest=null;
        try {
            testObj.testOnjString1="initial1";
            String a= nullTest.testOnjString1;
        }
        catch (Exception e){
            System.out.println("Exception blabla");
            testObj.testOnjString1="initial2";

        }
        finally {
            System.out.println(testObj.testOnjString1);
            testObj.testOnjString1=testObj.testOnjString1+" finelly";

        }
        System.out.println(testObj.testOnjString1);

    }
}
