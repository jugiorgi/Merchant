package com.merchant.integration.merchant.response.transaction;

import lombok.Data;

import java.io.Serializable;

@Data
public class Agent implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String customerIp;
    private String customerUserAgent;
    private String merchantIp;
    private String merchantUserAgent;
    private String created_at;
    private String updated_at;
    private String deleted_at;

}
