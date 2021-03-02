package com.merchant.service.impl;

import com.google.gson.Gson;
import com.merchant.integration.merchant.MerchantApiService;
import com.merchant.integration.merchant.request.AuthRequest;
import com.merchant.integration.merchant.response.auth.AuthResponse;
import com.merchant.service.AuthService;
import com.merchant.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AuthServiceImpl implements AuthService {

    private final static Logger LOGGER = Logger.getLogger(AuthServiceImpl.class.getName());

    @Autowired
    private MerchantApiService service;

    @Override
    public Optional<AuthResponse> login(AuthRequest authRequest) {
        Gson gson = new Gson();

        try {
            Optional<String> response = service.login(authRequest);

            if (response.isPresent()) {
                return Optional.of(gson.fromJson(response.get(), AuthResponse.class));
            }

        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            throw new ObjectNotFoundException("Object not found");
        }

        return Optional.empty();
    }

}
