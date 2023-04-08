package com.mercedesbenz.vintage.carshow.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class TestData {
  private Map<String,TestCase> testCases = new HashMap<>();
  private int totalTestCases;

}
