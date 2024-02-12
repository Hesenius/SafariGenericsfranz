package shopping;

public class Shop {
  public static void main(String[] args) {
    ClothingPair<Shoe> ps = new ClothingPair<>(new Shoe(9, "Black"), new Shoe(10, "Black"));

    System.out.println("this lovely pair is " + ps);
    System.out.println("does it match? " + ps.isMatched());

    ClothingPair<Shoe> ps2 = new ClothingPair<>(new Shoe(9, "Black"), new Shoe(9, "Blue"));
    System.out.println("this other pair is " + ps2);
    System.out.println("does it match? " + ps2.isMatched());

    // type INFERRED for E to be Sock...
//    boolean goodProposal = ClothingPair.match(new Sock(3, "pink"), new Sock(3, "pink"));
    // EXPLICIT TYPE for E -- help it out, or sometimes get a better error message :)
    boolean goodProposal = ClothingPair.<Sock>match(new Sock(3, "pink"), new Sock(3, "pink"));
    if (goodProposal) {
      ClothingPair<Sock> cps = new ClothingPair<>(new Sock(3, "pink"), new Sock(3, "pink"));
    }
  }
}
