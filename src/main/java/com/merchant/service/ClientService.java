package com.merchant.service;


import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.response.client.ClientResponse;

import java.util.Optional;

public interface ClientService {

    Optional<ClientResponse> getClient(ClientRequest clientRequest, String authToken);

}
