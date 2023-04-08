package com.practice.multithreading.sync;

public class MyAsyncTask extends Thread{
  @Override
  public void run(){
    foo();
  }
  public void foo(){
    synchronized (this){
      System.out.println("Some async task");
      System.out.println(" Thread Name : " + Thread.currentThread().getName());
    }
  }
}
