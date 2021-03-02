package com.merchant.controller;

import com.merchant.integration.merchant.request.AuthRequest;
import com.merchant.integration.merchant.response.auth.AuthResponse;
import com.merchant.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(method = RequestMethod.POST, path = "/user/login", produces = "application/json")
    public ResponseEntity<AuthResponse> userLogin(@RequestBody @Valid AuthRequest authRequest) {

        Optional<AuthResponse> response = authService.login(authRequest);

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }

        return ResponseEntity.noContent().build();
    }

}
