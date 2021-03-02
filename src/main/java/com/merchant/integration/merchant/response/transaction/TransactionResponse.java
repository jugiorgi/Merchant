package com.merchant.integration.merchant.response.transaction;

import com.merchant.integration.merchant.response.client.CustomerInfo;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TransactionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Transaction transaction;
    private CustomerInfo customerInfo;
    private Fx fx;
    private Parent parent;
    private String created_at;
    private String updated_at;

}
