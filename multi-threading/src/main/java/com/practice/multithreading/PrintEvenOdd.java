package com.practice.multithreading;

import lombok.Setter;

public class PrintEvenOdd{
  final Object lock = new Object();
  @Setter
  private  int n;
  private volatile int counter = 0;

  public void printEven() throws InterruptedException {
    synchronized (lock){
      while(counter < n){
        while(counter % 2 != 0){
          lock.wait();
        }
        System.out.println("Even thread :" + counter);
        counter++;
        lock.notify();
      }
    }
  }
  public void printOdd() throws InterruptedException {
    synchronized (lock){
      while(counter < n){
        while(counter % 2 == 0){
          lock.wait();
        }
        System.out.println("Odd thread :" + counter);
        counter++;
        lock.notify();
      }
    }
  }
}
