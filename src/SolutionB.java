import java.util.ArrayList;

public class SolutionB {
    public void test(Cat cat) {
if (cat.getCatList()==null){
    cat.setCatList(new ArrayList<>());
}

        addtoList(cat.getCatList());

        System.out.println("number " + cat.getCatList().get(0));

    }

    public void addtoList(ArrayList<Integer> list) {

            list.add(3);

    }
}
