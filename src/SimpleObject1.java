import java.util.List;

public class SimpleObject1 {
    String name;
    Integer number1;
    Cat cat;
    List<String> strings;



    public SimpleObject1() {}

    public SimpleObject1(String name, Integer number1, Cat cat) {
        this.name = name;
        this.number1 = number1;
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
