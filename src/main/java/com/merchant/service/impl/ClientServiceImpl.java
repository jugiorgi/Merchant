package com.merchant.service.impl;

import com.google.gson.Gson;
import com.merchant.integration.merchant.MerchantApiService;
import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.response.client.ClientResponse;
import com.merchant.service.ClientService;
import com.merchant.service.exceptions.AuthorizationException;
import com.merchant.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClientServiceImpl implements ClientService {

    private final static Logger LOGGER = Logger.getLogger(ClientServiceImpl.class.getName());

    @Autowired
    private MerchantApiService service;

    @Override
    public Optional<ClientResponse> getClient(ClientRequest clientRequest, String authToken) {
        Gson gson = new Gson();

        try {
            if (authToken == null) {
                throw new AuthorizationException("Token not found");
            }

            Optional<String> response = service.getClient(clientRequest, authToken);

            if (response.isPresent()) {
                return Optional.of(gson.fromJson(response.get(), ClientResponse.class));
            }

        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            throw new ObjectNotFoundException("Object not found");
        }

        return Optional.empty();
    }

}
