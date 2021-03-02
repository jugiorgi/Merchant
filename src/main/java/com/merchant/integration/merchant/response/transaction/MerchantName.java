package com.merchant.integration.merchant.response.transaction;

import lombok.Data;

import java.io.Serializable;

@Data
public class MerchantName implements Serializable {
   private static final long serialVersionUID = 1L;

   private String name;

}
