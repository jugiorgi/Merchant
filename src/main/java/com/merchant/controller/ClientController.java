package com.merchant.controller;

import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.response.client.ClientResponse;
import com.merchant.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.POST, path = "/client", produces = "application/json; charset=UTF-8")
    public ResponseEntity<ClientResponse> getClient(@RequestBody @Valid ClientRequest clientRequest,
                                                    @RequestHeader(value = "Authorization") String authToken) {

        Optional<ClientResponse> response = clientService.getClient(clientRequest, authToken);

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }

        return ResponseEntity.noContent().build();
    }

}
