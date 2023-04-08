package com.practice.multithreading.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddReentrantLock {
  private int counter = 0;
  private ReentrantLock lock = new ReentrantLock();
  private Condition even = lock.newCondition();
  private Condition odd = lock.newCondition();

  public void printEven() throws InterruptedException {
    while(counter < 10){
      try{
        lock.lock();
        System.out.println(counter);
        System.out.println(Thread.currentThread().getName());
        counter++;
        odd.signal();
        if(counter < 10){
          even.await();
        }
      }finally {
        lock.unlock();
      }
    }
  }

  public void printOdd() throws InterruptedException {
    while(counter < 10){
      try{
        lock.lock();
        System.out.println(counter);
        System.out.println(Thread.currentThread().getName());
        counter++;
        even.signal();
        if(counter < 10){
          odd.await();
        }
      }finally {
        lock.unlock();
      }
    }
  }
}
