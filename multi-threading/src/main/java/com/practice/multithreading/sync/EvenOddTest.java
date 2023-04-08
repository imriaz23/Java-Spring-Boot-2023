package com.practice.multithreading.sync;

import com.practice.multithreading.PrintEvenOdd;
import lombok.SneakyThrows;

public class EvenOddTest {
  {
    System.out.println("Test");
  }
  public static void main(String[] args) {
    PrintEvenOdd printEvenOdd = new PrintEvenOdd();
    printEvenOdd.setN(15);
    Thread even = new Thread(new Runnable() {
      @Override
      @SneakyThrows
      public void run() {
        printEvenOdd.printEven();
      }
    });

    Thread odd = new Thread(new Runnable() {
      @Override
      @SneakyThrows
      public void run() {
        printEvenOdd.printOdd();
      }
    });
    even.start();
    odd.start();
  }
}
