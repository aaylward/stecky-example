package com.andy.steckyexample;

import com.andy.steckyexample.config.GameModule;
import com.muchq.stecky.Mapping;
import com.muchq.stecky.WebSocketServer;

public class App {
  public static void main(String[] args) {
    WebSocketServer.newBuilder()
        .addModules(new GameModule())
        .addMappings(Mapping.of(Handler.class, "/"))
        .buildAndStart();
  }
}
