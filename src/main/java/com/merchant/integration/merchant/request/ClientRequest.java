package com.merchant.integration.merchant.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
public class ClientRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "not empty")
    private String transactionId;

    @JsonCreator
    public ClientRequest(@JsonProperty("transactionId") String transactionId) {
        super();
        this.transactionId = transactionId;
    }

}
