package com.merchant.integration.merchant.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
public class AuthRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "not empty")
    private String email;

    @NotEmpty(message = "not empty")
    private String password;

}
