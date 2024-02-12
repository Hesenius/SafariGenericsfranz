package com.dancingcloudservices;

record X(String message) {}

public class Main {
  public static void main(String[] args) {
    Object obj = new X("Java 21 world!");

    System.out.println(switch(obj) {
      case X(String m) -> "Hello " + m;
      default -> "Odd!";
    });
  }
}