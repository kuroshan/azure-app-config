package com.kuroshan.ms.azureappconfig;

import com.kuroshan.ms.azureappconfig.config.AppConfigProperties;
import com.kuroshan.ms.azureappconfig.config.AppCustomProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({AppConfigProperties.class, AppCustomProperties.class})
@SpringBootApplication
public class AzureAppConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureAppConfigApplication.class, args);
	}

}
