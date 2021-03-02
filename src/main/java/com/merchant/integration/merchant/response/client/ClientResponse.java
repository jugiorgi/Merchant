package com.merchant.integration.merchant.response.client;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ClientResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private CustomerInfo customerInfo;

}
