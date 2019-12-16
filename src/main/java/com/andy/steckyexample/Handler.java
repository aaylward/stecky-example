package com.andy.steckyexample;

import com.andy.steckyexample.game.JacksonDecoder;
import com.andy.steckyexample.game.JacksonEncoder;
import com.andy.steckyexample.game.ServerMessage;
import com.fasterxml.jackson.databind.JsonNode;

import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/", decoders = JacksonDecoder.class, encoders = JacksonEncoder.class)
public class Handler {
  private final GameManager gameManager;

  @Inject
  public Handler(GameManager gameManager) {
    this.gameManager = gameManager;
  }

  @OnOpen
  public void onWebSocketConnect(Session sess) {
    gameManager.onConnection(sess);
  }

  @OnMessage
  public ServerMessage onWebSocketText(Session session, JsonNode json) {
    return gameManager.onMessage(session, json);
  }

  @OnClose
  public void onWebSocketClose(Session session, CloseReason reason) {
    gameManager.onClose(session, reason);
  }

  @OnError
  public void onWebSocketError(Session session, Throwable cause) {
    gameManager.onError(session, cause);
  }
}
