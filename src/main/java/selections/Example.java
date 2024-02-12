package selections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//interface MyPredicate<F> {
//  boolean test(F s);
//}
//
public class Example {
//  public static List<String> longStrings(List<String> ls) {
//  public static List<String> longStrings(List<CharSequence> ls, MyPredicate crit) {
  public static <F, E extends F>  List<E> longStrings(List<E> ls, Predicate<F> crit) {
    List<E> res = new ArrayList<>();
    for (E s : ls) {
//      if (s.length() > 3) {
      if (crit.test(s)) {
        res.add(s);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    List<String> names = List.of("Fred", "Jim", "Sheila");
    Predicate<CharSequence> shorterText = s -> s.length() < 6;
//    Predicate<String> shorterText = s -> s.length() < 6;

    List<String> longNames = longStrings(names, shorterText);
    System.out.println(longNames);

    List<StringBuilder> lsb = new ArrayList<>(List.of(
      new StringBuilder("Monday"),
      new StringBuilder("Thing"),
      new StringBuilder("It")
    ));
//    System.out.println(longStrings(lsb, s -> s.length() < 6));
    System.out.println(longStrings(lsb, shorterText));

  }
}
