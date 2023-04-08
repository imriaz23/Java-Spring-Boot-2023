package com.practice.multithreading.sync;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Payload {
  private String firstName;
  private String lastName;
  private String ThreadId;
}
