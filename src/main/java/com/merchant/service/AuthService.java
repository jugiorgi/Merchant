package com.merchant.service;


import com.merchant.integration.merchant.request.AuthRequest;
import com.merchant.integration.merchant.response.auth.AuthResponse;

import java.util.Optional;

public interface AuthService {

    Optional<AuthResponse> login(AuthRequest authRequest);

}
