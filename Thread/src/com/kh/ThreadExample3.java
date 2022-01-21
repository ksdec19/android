package com.kh;

public class ThreadExample3 {
  public static void main(String[] args) {

   new Thread (() -> {
     for (int i = 0; i < 5; i++) {
       System.out.println("A=" + i);
     }
   }).start();

    new Thread (() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("B=" + i);
      }
    }).start();

    new Thread (() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("C=" + i);
      }
    }).start();




  }
}

