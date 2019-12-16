package com.andy.steckyexample.config;

import com.andy.steckyexample.GameManager;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.muchq.json.ObjectMapperModule;

public class GameModule implements Module {
  @Override
  public void configure(Binder binder) {
    binder.install(new ObjectMapperModule());
    binder.bind(GameManager.class).asEagerSingleton();
  }
}
