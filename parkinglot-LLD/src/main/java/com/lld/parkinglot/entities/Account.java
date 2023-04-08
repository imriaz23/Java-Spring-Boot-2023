package com.lld.parkinglot.entities;

import com.lld.parkinglot.enums.AccountStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {
  private Long id;
  private String userName;
  private String password;
  private AccountStatus accountStatus;
  public abstract boolean resetPassword(String password);
}
