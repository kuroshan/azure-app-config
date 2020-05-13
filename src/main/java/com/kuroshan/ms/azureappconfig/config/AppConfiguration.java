package com.kuroshan.ms.azureappconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

  @Bean
  public AzureCredentials azureCredentials() {
    return new AzureCredentials();
  }

}
