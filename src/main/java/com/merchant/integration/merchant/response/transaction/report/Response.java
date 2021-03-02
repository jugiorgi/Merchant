package com.merchant.integration.merchant.response.transaction.report;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer count;
    private String total;
    private String currency;

}
