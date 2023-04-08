package com.mercedesbenz.vintage.carshow.service;

import com.mercedesbenz.vintage.carshow.playload.RequestPayLoad;
import com.mercedesbenz.vintage.carshow.playload.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Te {
  @Autowired DisparitiesService disparitiesService;

  public List<Result> minimizeDisparities1(List<RequestPayLoad> requestPayLoadList){
    List<CompletableFuture<Result>> futures = requestPayLoadList.parallelStream()
        .map(requestPayLoad -> disparitiesService.minimizeDisparities(requestPayLoad))
        .collect(Collectors.toList());
    CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
    return futures.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());

  }
}
