import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestStream {
    public void run() {
        Traveller p1 = new Traveller("a1", 1111);
        Traveller p1d = new Traveller("a11", 1111);
        Traveller p2 = new Traveller("a2", 1112);
        List<Traveller> ps =new ArrayList<>();
        ps.add(p1);
        ps.add(p1d);
        ps.add(p2);
        Article article=new Article(ps);
       // Article tmpA = new Article();
        removeDoubletsFromDynart(article);

        for (Traveller t : article.getTravellers()) {
            System.out.println("traveler: "+ t.getName()+ ", id: "+ t.getId());
        }

        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()
                .filter(line -> "mkyong".equals(line))
                .collect(Collectors.toList());

        result.forEach(System.out::println);

    }

    public void removeDoubletsFromDynart(Article currentArticle) {
        List<Traveller> tempTrList= new ArrayList<>();
        List<Traveller> newList=new ArrayList<>();
        List<Traveller> oldList=currentArticle.getTravellers();
        try {
           /* for (Traveller tr : currentArticle.getTravellers()) {
                Traveller tmp = new Traveller(tr.getName(), tr.getId());
                tempTrList.stream().filter(c -> (c.getId().equals(tr.getId()))).findAny().orElseGet(() -> {
                    tempTrList.add(tmp);
                    return tmp;
                });//&& tr.getName().equals(b.getName()

                */

            for (Traveller tr : currentArticle.getTravellers()) {
                //Traveller tmp = new Traveller(tr.getName(), tr.getId());
               newList= oldList.stream().filter(c -> (c.getId().equals(1111))).collect(Collectors.toList());//&& tr.getName().equals(b.getName()

            }

        } catch (Exception e) { // how to be best with exception here?
            e.printStackTrace();
        }
       // currentArticle.setTravellers(tempTrList);
        currentArticle.setTravellers(newList);
    }
}
