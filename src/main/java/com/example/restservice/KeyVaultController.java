package com.example.restservice;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.identity.ManagedIdentityCredential;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class KeyVaultController {
        @Value(value = "${keyVaultName}")
        private String keyVaultName;
        @Value(value = "${userAssignedclientId}")
        private String userAssignedclientId;



        @GetMapping("/getSecret")
        public  Secret getSecret(@RequestParam(value = "secretKey") String secretKey) {
                String keyVaultUri = "https://" + keyVaultName + ".vault.azure.net";

                DefaultAzureCredential defaultAzureCredential = new DefaultAzureCredentialBuilder().build();
                SecretClient secretClient = new SecretClientBuilder()
                        .vaultUrl(keyVaultUri)
                        .credential(defaultAzureCredential)
                        .buildClient();
                String secretValue = secretClient
                        .getSecret(secretKey)
                        .getValue();
                return new Secret(secretKey, secretValue);
        }

}
