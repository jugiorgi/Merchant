package com.merchant.service;


import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.request.TransactionReportRequest;
import com.merchant.integration.merchant.response.transaction.TransactionResponse;
import com.merchant.integration.merchant.response.transaction.report.TransactionReportResponse;

import java.util.Optional;

public interface TransactionService {

    Optional<TransactionReportResponse> getTransactionReport(TransactionReportRequest transactionReportRequest, String authToken);

    Optional<TransactionResponse> getTransaction(ClientRequest clientRequest, String authToken);

}
