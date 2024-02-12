package arraystuff;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Example {

//  public static <E> E[] asArray(List<E> le) {
  // <?> is shorthand for ? extends Object
  public static <F, E extends F> F[] asArray(List<E> le, Class<F> cl) {
//    E e = new E(); // can't do this! (type erased)
//    E[] results = new E[le.size()]; // nor this, same reason
//    E[] results = (E[])new Object[le.size()];
    F[] results = (F[]) Array.newInstance(cl, le.size());

    int i = 0;
    for (E e : le) {
      results[i++] = e;
    }

    return results;
  }
  public static void main(String[] args) {
    List<String> names = List.of("Fred", "Jim", "Sheila");

//    String [] sa = asArray(names);
//    Object [] sa = asArray(names);
//    String [] sa = asArray(names, String.class);
//    String [] sa = asArray(names, StringBuilder.class);
//    CharSequence [] sa = asArray(names, CharSequence.class);
    Object [] sa = asArray(names, Object.class);
    System.out.println(sa.getClass());
    System.out.println(Arrays.toString(sa));
  }
}
