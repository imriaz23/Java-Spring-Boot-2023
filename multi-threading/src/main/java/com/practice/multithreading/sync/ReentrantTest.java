package com.practice.multithreading.sync;

public class ReentrantTest {
  public static void main(String[] args) {
    EvenOddReentrantLock evenOddReentrantLock = new EvenOddReentrantLock();
    Thread even = new Thread(() -> {
      try {
        evenOddReentrantLock.printEven();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    },"Even Thread");
    Thread odd = new Thread(() -> {
      try {
        evenOddReentrantLock.printOdd();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    },"Odd Thread");
    even.start();
    odd.start();

  }
}
