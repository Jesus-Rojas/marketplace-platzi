package com.personal.marketplaceplatzi;

import com.personal.marketplaceplatzi.config.LoadDotEnv;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Marketplace Platzi",
        version = "1.0"
    )
)
public class MarketplacePlatziApplication {
	public static void main(String[] args) {
    new LoadDotEnv();
    SpringApplication.run(MarketplacePlatziApplication.class, args);
  }
}
