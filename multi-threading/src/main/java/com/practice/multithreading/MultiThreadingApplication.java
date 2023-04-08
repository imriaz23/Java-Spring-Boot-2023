package com.practice.multithreading;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.practice.multithreading.sync.EvenOddTest;
import com.practice.multithreading.sync.MyAsyncCallable;
import com.practice.multithreading.sync.MyAsyncTask;
import com.practice.multithreading.sync.MySyncTask;
import com.practice.multithreading.sync.Payload;
import com.practice.multithreading.sync.ThreadLocalExample;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.core.task.TaskExecutor;

//@SpringBootApplication
public class MultiThreadingApplication {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
//    SpringApplication.run(MultiThreadingApplication.class, args);
//    MultiThreadingApplication multiThreadingApplication = new MultiThreadingApplication();
    // call MySyncTask foo method
    // since there we are not running in separate thread it will be run in the main thread
//    MySyncTask mySyncTask = new MySyncTask();
//    mySyncTask.foo();
    // The above call is a blocking call which means if the foo is an expensive then
    // we have to wait lets make it async so that it can be run in separate thread and
    // my main thread is not get blocked

    //To run in separate thread first create a thread and pass the async object to constructor of thread class
    //then call start method
    // if you don't call the start method then it would run in main thread which is like sync method
//    MyAsyncTask myAsyncTask = new MyAsyncTask();
//    Thread thread = new Thread(myAsyncTask);
//    thread.setName("My custom thread");
//    System.out.println("Id : "+ thread.getId() + " state : " + thread.getState() + " " + thread.isAlive());
//    thread.start();
////    Thread.sleep(1000);
//    System.out.println("Id : "+ thread.getId() + " state : "  );

    // Run 10 async task
//    int i = 0;
//    for(i = 0; i < 10; i++){
//      Thread thread1 = new Thread(myAsyncTask);
//      thread1.setName("10 wala thread hai" + (i + 1));
//      thread1.start();
//    }
    // Do you any problem in above code
    // I am responsible for creating 10 thread and if tasks are expensive they will eat out all resource
    // wouldn't be great if someone can create thread and destroy them if they are not needed
    //Thanks to java8 we have executor services

    //let's create thread pool
//    ExecutorService executor = Executors.newFixedThreadPool(5);
//    MyAsyncTask myAsyncTask1 = new MyAsyncTask();
////    for(int i = 0; i < 10; i++){
////      executor.submit(myAsyncTask1);
////    }
//    // Different Way to create thread pools
//    final ExecutorService executorService = new ThreadPoolExecutor(
//      1,20,0L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>()
//    );
//    for(int i = 0; i < 100; i++){
//      executorService.submit(myAsyncTask1);
//    }
//    List<Runnable> pending = executorService.shutdownNow();
//    System.out.println(executorService.isShutdown());
//    MyAsyncCallable myAsyncCallable = new MyAsyncCallable();
////    System.out.println(pending.size());
//    Future future = executorService.submit(myAsyncCallable);
//    System.out.println(future.get());
//    EvenOddTest evenOddTest = new EvenOddTest();
//    ExecutorService executorService = new ThreadPoolExecutor(4,4,0L,TimeUnit.SECONDS,new LinkedBlockingQueue<>());
//
//    CountDownLatch latch = new CountDownLatch(3);
//    for(int i = 0; i < 3; i++){
//      executorService.submit(() -> {
//        new CountDownLatchExample(latch).foo();
//      });
//    }
//    System.out.println(latch.getCount());
//    latch.await();
//    System.out.println(latch.getCount());
    List<Student> l = Arrays.asList(new Student(1,"ty",6),new Student(2,"ty",6),new Student(1,"ty",6));
    Set<Student> collect = l.stream()
        .distinct().collect(Collectors.toSet());
    System.out.println(collect);

  }
  static class Student{
    int a;
    String b;
    int c;
    Student(int a, String b,int c){
      this.a = a;
      this.b = b;
      this.c = c;
    }

    @Override
    public String toString() {
      return "Student{" +
          "a=" + a +
          ", b='" + b + '\'' +
          ", c=" + c +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Student student = (Student) o;
      return a == student.a && c == student.c && Objects.equals(b, student.b);
    }

    @Override
    public int hashCode() {
      return Objects.hash(a, b, c);
    }
  }
}
