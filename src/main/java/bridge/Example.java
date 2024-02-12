package bridge;

class Parent<E> {
  E thing;
  void doStuff(Parent<E> this, E e) {
    System.out.println("Parent.doStuff");
  }
}

class Child extends Parent<String> {
  @Override
  void doStuff(Child this, String s) {
    System.out.println("Child doStuff!!!");
  }
  // compiler generates:
//  void doStuff(Child this, Object s) {
//    doStuff(this, (String)s); // cast is checked, delegates to our "nice" version
//  }
}


public class Example {
}
