package com.practice.multithreading.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class MyCache<K,V> {
  private Map<K,V> cache;
  private ReentrantLock lock;
  MyCache(){
    cache = new HashMap<>();
    lock = new ReentrantLock();
  }
  public void add(K key,V value){
    lock.lock();
    try{
      cache.put(key,value);
      System.out.println(lock.getHoldCount() + " Hold");
      System.out.println(lock.getQueueLength() +" Length");
    }finally {
      lock.unlock();
    }
  }
  public V get(K key){
    lock.lock();
    try{
      if(cache.containsKey(key)){
        return cache.get(key);
      }
      else{
        return null;
      }
    }finally {
      lock.unlock();
    }
  }
}
