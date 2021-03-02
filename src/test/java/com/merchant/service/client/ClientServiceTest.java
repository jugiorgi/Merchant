package com.merchant.service.client;


import com.google.gson.Gson;
import com.merchant.integration.merchant.MerchantApiService;
import com.merchant.integration.merchant.request.AuthRequest;
import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.response.auth.AuthResponse;
import com.merchant.integration.merchant.response.client.ClientResponse;
import com.merchant.integration.merchant.response.client.CustomerInfo;
import com.merchant.service.auth.FakeAuthRestService;
import com.merchant.service.config.FakeFeignConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest(classes = {FakeFeignConfiguration.class, FakeAuthRestService.class, FakeClientRestService.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientServiceTest {

    @Autowired
    MerchantApiService service;

    @Test
    void testGetClient_happyPath() {
        Gson gson = new Gson();

        Optional<String> response = service.getClient(buildClientRequest_happyPath(), getToken(gson));
        ClientResponse clientResponse = gson.fromJson(response.get(), ClientResponse.class);

        Assertions.assertNotNull(clientResponse);
        Assertions.assertEquals(buildClientResponse_happyPath().getCustomerInfo().getId(), clientResponse.getCustomerInfo().getId());
        Assertions.assertEquals(buildClientResponse_happyPath().getCustomerInfo().getNumber(), clientResponse.getCustomerInfo().getNumber());
    }

    private String getToken(Gson gson) {
        Optional<String> token = service.login(buildAuthRequest_happyPath());
        AuthResponse authResponse = gson.fromJson(token.get(), AuthResponse.class);
        return authResponse.getToken();
    }

    private ClientRequest buildClientRequest_happyPath() {
        return ClientRequest.builder()
                .transactionId("1032716-1613563524-3")
                .build();
    }

    private ClientResponse buildClientResponse_happyPath() {
        return ClientResponse.builder()
                .customerInfo(
                        CustomerInfo.builder()
                                .id(722975)
                                .number("516859XXXXXX4429")
                                .build()
                )
                .build();
    }

    private AuthRequest buildAuthRequest_happyPath() {
        return AuthRequest.builder()
                .email("demo@financialhouse.io")
                .password("cjaiU8CV")
                .build();
    }

}
