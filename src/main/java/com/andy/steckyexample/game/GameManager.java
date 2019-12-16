package com.andy.steckyexample.game;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.CloseReason;
import javax.websocket.Session;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GameManager {
  private static final Logger LOG = LoggerFactory.getLogger(GameManager.class);

  private final Map<String, Session> sessionsById = new ConcurrentHashMap<>();
  private final Map<Session, String> idsBySession = new ConcurrentHashMap<>();
  private final Set<Session> activeUnpairedSessions = ConcurrentHashMap.newKeySet();

  public void onConnection(Session session) {
    activeUnpairedSessions.add(session);
  }

  public ServerMessage onMessage(Session session, JsonNode json) {
    LOG.debug("Received json message: {}", json);
    return new ServerMessage(true, "got yer message: " + json);
  }

  public void onClose(Session session, CloseReason reason) {
    LOG.debug("Connection closed due to: {}", reason);
    activeUnpairedSessions.remove(session);
    String id = idsBySession.get(session);
    idsBySession.remove(session);
    if (id != null) {
      sessionsById.remove(id);
    }
  }

  public void onError(Session session, Throwable throwable) {
    LOG.error("Error in session" + session.getId(), throwable);
    try {
      session.getBasicRemote().sendObject(new ServerMessage(false, "error reading message"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
