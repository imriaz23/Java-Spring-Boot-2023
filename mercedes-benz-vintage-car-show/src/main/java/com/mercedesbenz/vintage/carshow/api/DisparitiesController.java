package com.mercedesbenz.vintage.carshow.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercedesbenz.vintage.carshow.Entity.TestData;
import com.mercedesbenz.vintage.carshow.playload.RequestPayLoad;
import com.mercedesbenz.vintage.carshow.playload.Result;
import com.mercedesbenz.vintage.carshow.service.DisparitiesService;
import com.mercedesbenz.vintage.carshow.service.Te;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disparity")
public class DisparitiesController {
  @Autowired
  DisparitiesService disparitiesService;
  @Autowired
  Te te;
  Logger logger = LoggerFactory.getLogger(DisparitiesController.class);

  @PostMapping("/get/min")
  public ResponseEntity<?> findMinimumDisparitySum(
      @RequestBody TestData testData) throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
//  TestData testData = objectMapper.readValue(s, TestData.class);

    return ResponseEntity.ok(testData);
  }


}

