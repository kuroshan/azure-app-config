package com.kuroshan.ms.azureappconfig.config;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.EnvironmentCredentialBuilder;
import com.microsoft.azure.spring.cloud.config.AppConfigurationCredentialProvider;
import com.microsoft.azure.spring.cloud.config.KeyVaultCredentialProvider;

public class AzureCredentials implements AppConfigurationCredentialProvider, KeyVaultCredentialProvider {

  @Override
  public TokenCredential getAppConfigCredential(String uri) {
    return getCredential();
  }

  @Override
  public TokenCredential getKeyVaultCredential(String uri) {
    return getCredential();
  }

  private TokenCredential getCredential() {
    return new EnvironmentCredentialBuilder().build();
  }
}
