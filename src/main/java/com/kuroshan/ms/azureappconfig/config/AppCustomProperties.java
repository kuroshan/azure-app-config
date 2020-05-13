package com.kuroshan.ms.azureappconfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "custom")
public class AppCustomProperties {

  private AppCustomProperties.Datasource datasource = new AppCustomProperties.Datasource();

  @Getter
  @Setter
  public static class Datasource {
    private String url;
    private String username;
    private String password;
  }

}
