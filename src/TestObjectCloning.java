import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestObjectCloning {
    public void run() {
        SimpleObject1 so1 = new SimpleObject1();
        so1.setNumber1(456);
        so1.setName("Peter");
        SimpleObject1 so2 = new SimpleObject1(so1.getName(), so1.getNumber1(), so1.getCat());
        System.out.println("so2 number: " + so2.getNumber1());
        System.out.println("so2 name: "+ so2.getName());
        so1.setName("not Peter");
        System.out.println("so2 name now: "+ so2.getName());
        Stream<String> s = Stream.of("a","b","c");
        List<String> s1=new ArrayList<>();
        List<String> s2=new ArrayList<>();
        s1.add("a1");
        s1.add("b1");
        /*s2.add("a2");
        s2.add("b2");*/

        so1.setStrings(s1);
        so2=new SimpleObject1();
       List<String> so2Strings=so1.getStrings().stream().collect(Collectors.toList()); //??new ArrayList<>(so1.getStrings());
       // so2.setStrings()= s1.stream().collect(Collectors.toList());

        //so2.setStrings(so1.getStrings());
        so2.setStrings(so2Strings);

        //Object o=so1.getStrings().stream();
       // System.out.println("obj: "+ o);

        s1.set(0, "a3");

       // System.out.println(s1);

        System.out.println(so2.getStrings());

       /* List<String> names = s
                .collect(Collectors.toList());*/

        //System.out.println(names);
    }
    }

