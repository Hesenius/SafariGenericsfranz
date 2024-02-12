package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.Serializable;

public class UseAList {
  public static void breakMyList(List/*<String>*/ lst) {
    lst.add(2, 99);
  }

  public static void main(String[] args) {
    // raw type on right side!!!! not checked -- bad!!!
//    List<String> names = new ArrayList(List.of(/*99, 100, 101,  */"Hello"));
//    List<String> names = new ArrayList<String>(List.of(/*99, 100, 101,  */"Hello"));

    // "diamond operator" <> says "guess" (infer) the type of E here
    List<String> names = new ArrayList<>(List.of(/*99, 100, 101, */ "Hello"));
    names = Collections.checkedList(names, String.class);
//    names = Collections.checkedList(names, "".getClass()); // same value at runtime
    names.add("Fred");
    names.add("Jim");

    System.out.println("names is " + names);
    System.out.println("names has " + names.size() + " names");
//    names.add(99);
    names.add("Sheila");
    System.out.println("names is " + names);
    System.out.println("names has " + names.size() + " names");

//    breakMyList(names);

//    int n2 = (int)names.get(2);
//    String n2 = (String)names.get(2);
    String n2 = names.get(2); // cast STILL EXISTS!!!
    System.out.println("names item 2 is " + names.get(2));


    List<Integer> numbers = new ArrayList();
    numbers.add(1); // Integer.valueOf(1) -- autoboxing
//    numbers.add(Integer.valueOf(1));
    System.out.println(numbers);


    String s = "Hello";
    Integer i = 99;

    // non-denotable type.. Cannot write Serializable & Comparable... in the type
    // declaration of this source code!!!
//    Serializable & Comparable obj = true ? s : i; // NOT LEGAL SYNTAX!!!
    var obj = true ? s : i; // MUST use var for this effect
    System.out.println(obj);
    obj.compareTo(null);
  }
}
