package com.merchant.service.client;

import com.merchant.integration.merchant.request.ClientRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/client")
public class FakeClientRestService {

    @PostMapping(path = "/client", consumes = "application/json", produces = "text/html")
    Optional<String> getClient(@RequestBody ClientRequest body, @RequestHeader("Authorization") String token){
        return Optional.empty();
    }

}
