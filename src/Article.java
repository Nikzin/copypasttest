import java.util.List;

public class Article {
    List<Traveller> Travellers;


    public Article(List<Traveller> travellers) {
        Travellers = travellers;
    }

    public Article() {

    }

    public List<Traveller> getTravellers() {
        return Travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        Travellers = travellers;
    }
    public static boolean myEquals(String s1, String s2){
        if(s1 == null)
            return s2 == null;
        return s1.equals(s2);
    }
}
