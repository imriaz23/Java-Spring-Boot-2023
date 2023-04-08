package com.practice.multithreading.sync;

import java.util.concurrent.Callable;

public class MyAsyncCallable implements Callable {


  @Override
  public String call() throws Exception {
    return foo();
  }
  public String foo(){
    return "I am the boss";
  }
}
