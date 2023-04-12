package com.riaz.xmeme.payloads;

import lombok.Data;

@Data
public class MemeRequest {
  private String username;
  private String url;
  private String caption;
}
