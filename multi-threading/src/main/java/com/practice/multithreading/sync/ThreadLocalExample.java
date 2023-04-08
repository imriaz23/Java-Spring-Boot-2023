package com.practice.multithreading.sync;

import lombok.Data;
import lombok.SneakyThrows;

public class ThreadLocalExample {
  private static ThreadLocal<Payload> threadLocal = new ThreadLocal<>(){
    @Override
    protected Payload initialValue() {
      Payload p = new Payload();
      p.setThreadId(String.valueOf(Thread.currentThread().getId()));
      p.setLastName("Riaz");
      p.setLastName("Quadri");
      return p;
    }

    @Override
    public Payload get() {
      return super.get();
    }

    @Override
    public void set(Payload value) {
      super.set(value);
    }

    @Override
    public void remove() {
      super.remove();
    }
  };
  public Payload getLocal(){
    return threadLocal.get();
  }
  public void setThreadLocal(Payload payload){
    threadLocal.set(payload);
  }
  public void removeThreadLocal(){
    threadLocal.remove();
  }
}
