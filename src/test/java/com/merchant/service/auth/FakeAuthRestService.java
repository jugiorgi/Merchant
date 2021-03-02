package com.merchant.service.auth;

import com.merchant.integration.merchant.request.AuthRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping(path = "/user/login")
public class FakeAuthRestService {

    @PostMapping(path = "/merchant/user/login", consumes = "application/json", produces = "text/html")
    Optional<String> login(@RequestBody AuthRequest body) {
        return Optional.empty();
    }

}
