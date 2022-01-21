package com.kh;

public class ThreadExample2 {
  public static void main(String[] args) {

    // 1) 병렬로 실행할 작업을 run 메소드 안에 정의

    // 2) 스레드 객체의 매개값으로 병렬로 실행할 작업을 전달

    // 3) 병렬 작업 실행
    new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("jobA=" + i);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    // 1) 병렬로 실행할 작업을 run 메소드 안에 정의

    // 2) 스레드 객체의 매개값으로 병렬로 실행할 작업을 전달

    // 3) 병렬 작업 실행
    new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("jobC=" + i);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();




  }
}

