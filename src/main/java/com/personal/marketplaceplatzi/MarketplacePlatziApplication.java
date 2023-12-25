package com.personal.marketplaceplatzi;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketplacePlatziApplication {
	public static void main(String[] args) {
    Dotenv dotenv = Dotenv.load();
    System.setProperty("server.port", dotenv.get("PORT"));
    SpringApplication.run(MarketplacePlatziApplication.class, args);
  }
}
