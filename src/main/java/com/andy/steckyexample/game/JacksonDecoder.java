package com.andy.steckyexample.game;

import com.fasterxml.jackson.databind.JsonNode;
import com.muchq.json.JsonUtils;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.Reader;

public class JacksonDecoder implements Decoder.TextStream<JsonNode> {
  @Override
  public JsonNode decode(Reader reader) {
    return JsonUtils.readAs(reader, JsonNode.class);
  }

  @Override
  public void init(EndpointConfig config) {
  }

  @Override
  public void destroy() {
  }
}
