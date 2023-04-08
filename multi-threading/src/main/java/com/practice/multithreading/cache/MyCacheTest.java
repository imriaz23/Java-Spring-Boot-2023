package com.practice.multithreading.cache;

import ch.qos.logback.core.testUtil.RandomUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class MyCacheTest {
  public static void main(String[] args) {
    MyCache myCache = new MyCache();
    ExecutorService service = new ThreadPoolExecutor(10,10,0L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
    for(int i = 0; i < 500; i++){
      service.submit(new Runnable() {
        @Override
        public void run() {
          int key = RandomUtil.getPositiveInt();
          int value = RandomUtil.getPositiveInt();
          myCache.add(key,value);
//          System.out.println(myCache.get(key));
//          System.out.println(Thread.currentThread().getName());
        }
      });
    }
  }
}
