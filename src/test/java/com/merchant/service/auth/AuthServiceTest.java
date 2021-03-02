package com.merchant.service.auth;


import com.google.gson.Gson;
import com.merchant.integration.merchant.MerchantApiService;
import com.merchant.integration.merchant.request.AuthRequest;
import com.merchant.integration.merchant.response.auth.AuthResponse;
import com.merchant.service.config.FakeFeignConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest(classes = {FakeFeignConfiguration.class, FakeAuthRestService.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthServiceTest {

    @Autowired
    MerchantApiService service;

    @Test
    void testClient_happyPath() {
        Gson gson = new Gson();

        Optional<String> response = service.login(buildAuthRequest_happyPath());
        AuthResponse authResponse = gson.fromJson(response.get(), AuthResponse.class);

        Assertions.assertNotNull(response.get());
        Assertions.assertEquals(buildAuthResponse_happyPath().getStatus(), authResponse.getStatus());
    }

    private AuthRequest buildAuthRequest_happyPath() {
        return AuthRequest.builder()
                .email("demo@financialhouse.io")
                .password("cjaiU8CV")
                .build();
    }

    private AuthResponse buildAuthResponse_happyPath() {
        return AuthResponse.builder()
                .status("APPROVED")
                .build();
    }

}
