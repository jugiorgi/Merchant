package com.merchant.integration.merchant.response.auth;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AuthResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String token;
    private String status;

}
