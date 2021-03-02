package com.merchant.integration.merchant.response.transaction;

import lombok.Data;

import java.io.Serializable;

@Data
public class Merchant implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer originalAmount;
    private String originalCurrency;

}
