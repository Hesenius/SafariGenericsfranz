package shopping;

import java.io.Serializable;
//public class ClothingPair<E extends Sized, Colored> extends Pair<E> {
//  Colored c;
//  void doStuff() {
//    c.getColor(); // NOPE !!! Colored, as a type param is only an OBJECT
//  }

//public class ClothingPair<E extends Sized, String> extends Pair<E> {
//  String s = ""; // NO!!!
//  java.lang.String s = "";// YES!

// at most one CLASS constraint, must come first,
// as many INTERFACE constraints as you want :)
// ALL of these use "extends" :)
public class ClothingPair<E extends /*Object & */Sized & Colored/* & Serializable*/> extends Pair<E> {

  public ClothingPair(E left, E right) {
    super(left, right);
  }

  public boolean isMatched() {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }

  public static <E extends Sized & Colored> boolean match(E left, E right) {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }
}



