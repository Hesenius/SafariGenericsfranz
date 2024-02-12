package shopping;

public class UseAPair {
  public static void main(String[] args) {
    Pair<String> p = new Pair<>("Hello", "Bonjour");
    String french = p.getRight();
    System.out.println(p.getLeft() + " : " + p.getRight());
    Pair<Integer> pi = new Pair<>(10, 20);
    Integer l = pi.getLeft();
  }
}
