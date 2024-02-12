package taxation;

import java.util.ArrayList;
import java.util.List;

public class MyTaxPrepCompany {

  public static void prepareTaxes(Taxable t) {}

//  public static <E extends Taxable> void prepareBulkTaxes(List<E> lt, E extra) {
////    lt.add(new Corporation()); // NOT POSSIBLE (not safe at least)
//    Taxable t1 = lt.get(0);
//    E e = lt.get(1);
//    lt.add(extra);
//    for (Taxable t : lt) {
//      prepareTaxes(t);
//    }
//  }

  // this <? extends XXXX> has a fancy name-- "co-variance"
  public static void prepareBulkTaxes(List<? extends Taxable> lt) {
//    lt.add(new Corporation()); // NOT POSSIBLE (not safe at least)
    Taxable t1 = lt.get(0);
    for (Taxable t : lt) {
      prepareTaxes(t);
    }
  }

//  public static void collectJoesClients(List<Individual> li) {
//  public static <Individual extends E> void collectJoesClients(List<E> li) {
//  public static <E super Individual> void collectJoesClients(List<E> li) {
  // this <? super XXXX> is called "contra-variance"
  public static void collectJoesClients(List<? super Individual> li) {
    li.add(new Individual());
    li.add(new Individual());
    li.add(new Retiree());
//    Individual ind = li.get(0); // CANNOT DO THIS SAFELY!!!!
  }

  public static void main(String[] args) {
    List<Taxable> clients = List.of(
        new Corporation(),
        new Charity(),
        new Individual()
    );
    collectJoesClients(clients);
    prepareBulkTaxes(clients);

    List<Individual> joesClients = new ArrayList<>(List.of(
        new Individual(),
        new Individual(),
        new Individual()
    ));
//    collectJoesClients(joesClients);

    prepareBulkTaxes(joesClients);
  }
}
