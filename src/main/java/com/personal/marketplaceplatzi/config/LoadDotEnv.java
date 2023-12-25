package com.personal.marketplaceplatzi.config;

import io.github.cdimascio.dotenv.Dotenv;

public class LoadDotEnv {
  public LoadDotEnv() {
    Dotenv dotenv = Dotenv.load();
    System.setProperty("server.port", dotenv.get("PORT"));
    System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
    System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
    System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
  }
}
