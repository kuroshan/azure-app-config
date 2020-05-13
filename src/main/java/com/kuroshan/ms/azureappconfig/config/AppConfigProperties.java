package com.kuroshan.ms.azureappconfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "config")
public class AppConfigProperties {

  private AppConfigProperties.Dbpacifico dbpacifico = new AppConfigProperties.Dbpacifico();

  @Getter
  @Setter
  public static class Dbpacifico {

    private AppConfigProperties.Dbpacifico.Datasource datasource = new AppConfigProperties.Dbpacifico.Datasource();

    @Getter
    @Setter
    public static class Datasource {
      private String url;
      private String username;
      private String password;
    }

  }

}
