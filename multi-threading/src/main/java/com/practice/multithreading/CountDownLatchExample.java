package com.practice.multithreading;

import com.practice.multithreading.sync.ThreadLocalExample;
import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
  private CountDownLatch latch;

  CountDownLatchExample(CountDownLatch latch){
    this.latch = latch;
  }
  public void foo(){
    System.out.println("papa kahet ethe beta bada naam karega");
    System.out.println(Thread.currentThread().getName());
    latch.countDown();
  }

}
