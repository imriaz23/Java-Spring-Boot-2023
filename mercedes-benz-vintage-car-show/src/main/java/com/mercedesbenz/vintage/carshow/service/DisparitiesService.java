package com.mercedesbenz.vintage.carshow.service;

import com.mercedesbenz.vintage.carshow.playload.RequestPayLoad;
import com.mercedesbenz.vintage.carshow.playload.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DisparitiesService {
  Logger logger = LoggerFactory.getLogger(DisparitiesService.class);

  public List<Result> minimizeDisparities(List<RequestPayLoad> requestPayLoadList)
      throws ExecutionException, InterruptedException {
    List<CompletableFuture<Result>> futures = requestPayLoadList.parallelStream()
        .map(requestPayLoad -> minimizeDisparities(requestPayLoad))
        .collect(Collectors.toList());
    CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
    return futures.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());

  }
  public List<Result> minimizeDisparities1(List<RequestPayLoad> requestPayLoadList){
      List<CompletableFuture<Result>> futures = new ArrayList<>();
      for(RequestPayLoad requestPayLoad : requestPayLoadList){
        futures.add(minimizeDisparities(requestPayLoad));
      }
    CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
    return futures.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());

  }

  @Async
  public CompletableFuture<Result> minimizeDisparities(RequestPayLoad requestPayLoad) {
//    logger.info("Received request");
    int[] nums = requestPayLoad.getNums();
    int serial = requestPayLoad.getSerial();
    int n = requestPayLoad.getN();

    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      min = Math.min(nums[i], min);
      max = Math.max(max, nums[i]);
      sum += max - min;
    }
//    logger.info("Completed{}", Thread.currentThread().getName());
//    try {
//      Thread.sleep(5000);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
    return CompletableFuture.completedFuture(new Result(serial, sum));
  }
}
