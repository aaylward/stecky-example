package com.andy.steckyexample.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServerMessage {
  private final boolean success;
  private final String message;

  public ServerMessage(boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  @JsonProperty("success")
  public boolean isSuccess() {
    return success;
  }

  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
}
