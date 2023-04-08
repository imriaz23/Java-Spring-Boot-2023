package com.practice.multithreading.sync;

public class MySyncTask {
  public void foo(){
   System.out.println("Some sync task");
   System.out.println(" Thread Name : " + Thread.currentThread().getName());
 }
}
