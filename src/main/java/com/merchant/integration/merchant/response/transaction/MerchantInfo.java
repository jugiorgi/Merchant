package com.merchant.integration.merchant.response.transaction;

import lombok.Data;

import java.io.Serializable;

@Data
public class MerchantInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String referenceNo;
    private Integer merchantId;
    private String fxTransactionId;
    private Integer acquirerTransactionId;
    private String chainId;
    private Integer agentInfoId;
    private String status;
    private String operation;
    private String created_at;
    private String updated_at;
    private String code;
    private String message;
    private String channel;
    private String customData;
    private Integer parentId;
    private String type;
    private String transactionId;
    private Agent agent;

}
