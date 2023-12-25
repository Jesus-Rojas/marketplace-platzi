package com.personal.marketplaceplatzi;

import com.personal.marketplaceplatzi.config.LoadDotEnv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketplacePlatziApplication {
	public static void main(String[] args) {
    new LoadDotEnv();
    SpringApplication.run(MarketplacePlatziApplication.class, args);
  }
}
