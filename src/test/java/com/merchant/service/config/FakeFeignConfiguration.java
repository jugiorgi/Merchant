package com.merchant.service.config;

import com.merchant.integration.merchant.MerchantApiService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration()
@EnableFeignClients(clients = MerchantApiService.class)
@EnableAutoConfiguration
@RibbonClient(
        name = "messagingRestClient",
        configuration = FakeRibbonConfiguration.class)
public class FakeFeignConfiguration {
}
