package com.andy.steckyexample.game;

import com.muchq.json.JsonUtils;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class JacksonEncoder implements Encoder.Text<ServerMessage> {
  @Override
  public String encode(ServerMessage serverMessage) {
    return JsonUtils.writeAsString(serverMessage);
  }

  @Override
  public void init(EndpointConfig config) {

  }

  @Override
  public void destroy() {

  }
}
