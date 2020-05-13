package com.kuroshan.ms.azureappconfig.controllers;

import com.kuroshan.ms.azureappconfig.config.AppConfigProperties;
//import com.microsoft.azure.spring.cloud.config.AppConfigurationRefresh;
import com.kuroshan.ms.azureappconfig.config.AppCustomProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/config")
public class ConfigController {

  /*@Autowired
  private AppConfigurationRefresh appConfigurationRefresh;*/

  @Autowired
  private AppConfigProperties properties;

  @Autowired
  private AppCustomProperties customProperties;

  @Value("${custom.datasource.url}")
  private String customDataSourceUrl;

  @Value("${custom.datasource.username}")
  private String customDataSourceUserName;

  @Value("${custom.datasource.password}")
  private String customDataSourcePassword;


  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AppConfigProperties> config() {
    //appConfigurationRefresh.refreshConfigurations();
    return new ResponseEntity<AppConfigProperties>(properties, HttpStatus.OK);
  }

  @GetMapping(value = "/custon", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AppCustomProperties> custom() {
    return new ResponseEntity<AppCustomProperties>(customProperties, HttpStatus.OK);
  }

  @GetMapping(value = "/properties", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map> configJDBC() {
    Map<String, Object> map = new HashMap<>();

    LinkedHashMap<String,String> datasource = new LinkedHashMap<String,String>();
    datasource.put("url", customDataSourceUrl);
    datasource.put("username", customDataSourceUserName);
    datasource.put("password", customDataSourcePassword);

    Map<String, Object> custom = new HashMap<>();
    custom.put("datasource", datasource);

    map.put("custom", custom);

    return new ResponseEntity<Map>(map, HttpStatus.OK);
  }

}
