package shopping;

import java.util.function.BiPredicate;

public class Pair<E> {
  // should almost certainly be private!
  // E will be OBJECT (here) at runtime!!
  E left;
  E right;

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }

  public E getLeft() {
    return left;
  }

  public void setLeft(E left) {
    this.left = left;
  }

  public E getRight() {
    return right;
  }

  public void setRight(E right) {
    this.right = right;
  }

//  public boolean isMatched() {
//    return left.getSize() == right.getSize();
//  }

  // better way to do this!
  public boolean testByPredicate(BiPredicate<E, E> op) {
    return op.test(left, right);
  }

  @Override
  public String toString() {
    return "Pair{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }

  // consistency checking (of explicit, known, types)
//  String s;
//  void doIt(String t) {
//    this.s = t;
//  }
}
