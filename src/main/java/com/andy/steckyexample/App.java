package com.andy.steckyexample;

import com.muchq.stecky.Mapping;
import com.muchq.stecky.WebSocketServer;

public class App {
  public static void main(String[] args) {
    WebSocketServer.newBuilder()
        .addModules(binder -> {})
        .addMappings(Mapping.of(Handler.class, "/"))
        .buildAndStart();
  }
}
