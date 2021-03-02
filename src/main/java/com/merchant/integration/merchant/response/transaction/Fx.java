package com.merchant.integration.merchant.response.transaction;

import lombok.Data;

import java.io.Serializable;

@Data
public class Fx implements Serializable {
    private static final long serialVersionUID = 1L;

    private Merchant merchant;

}
