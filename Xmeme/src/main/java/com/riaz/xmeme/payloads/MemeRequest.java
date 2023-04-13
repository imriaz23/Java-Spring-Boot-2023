package com.riaz.xmeme.payloads;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemeRequest {
  @NotBlank(message = "Invalid username : Empty username")
  private String username;
  @NotBlank(message = "Invalid url : empty url")
  private String url;
  @NotBlank(message = "Invalid caption : empty caption")
  private String caption;
}
