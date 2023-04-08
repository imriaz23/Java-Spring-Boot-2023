package com.mercedesbenz.vintage.carshow.Entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

public class TestCaseMapWrapper {
  private Map<String,TestCase> testCases = new HashMap<>();

  @JsonAnySetter
  public void addTestCases(String key, TestCase testCase){
    testCases.put(key,testCase);
  }

  @JsonAnyGetter
  public Map<String, TestCase> getTestCases() {
    return testCases;
  }
}
