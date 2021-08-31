package test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Formula {
    public void count(String[] args) {
        int n = 1;
        Converter<String, Integer> converter = (from) -> Integer.valueOf("5") + n;
        System.out.println(converter.convert("5"));

        Predicate<String> s = s1 -> s1.length() > 0;
        s.test("sada");
        s.negate().test("asd");
        Predicate<String> pEmpty = String::isEmpty;
        Function<String, String> fSubstring = (s1) -> s1.substring(0, 1);
        Function<String, String> fSubstring2 = fSubstring.andThen(String::trim);

        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.stream().sorted().max((s1, s2) -> s1.substring(0, 1).compareTo(s2)).isPresent();
        System.out.println(l.stream().sorted().reduce((s1, s2) -> s1 + s2).get());
        Map<Integer, String> map = new HashMap<>();

        Stream.of(1, 2, 3, 4, 5, 6, 7).min((i1, i2) -> i1 - i2 + 1).get();

        PersonFactory<Person> factory = Person::new;
        factory.create("", "");
    }
}
