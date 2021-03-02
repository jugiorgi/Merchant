package com.merchant.integration.merchant.response.transaction.report;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class TransactionReportResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;
    private List<Response> response;

}
