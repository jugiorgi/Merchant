package com.merchant.service.impl;

import com.google.gson.Gson;
import com.merchant.integration.merchant.MerchantApiService;
import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.request.TransactionReportRequest;
import com.merchant.integration.merchant.response.transaction.TransactionResponse;
import com.merchant.integration.merchant.response.transaction.report.TransactionReportResponse;
import com.merchant.service.TransactionService;
import com.merchant.service.exceptions.AuthorizationException;
import com.merchant.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final static Logger LOGGER = Logger.getLogger(TransactionServiceImpl.class.getName());

    @Autowired
    private MerchantApiService service;

    @Override
    public Optional<TransactionReportResponse> getTransactionReport(TransactionReportRequest transactionReportRequest, String authToken) {
        Gson gson = new Gson();

        try {
            if (authToken == null) {
                throw new AuthorizationException("Token not found");
            }

            Optional<String> response = service.getTransactionReport(transactionReportRequest, authToken);

            if (response.isPresent()) {
                return Optional.of(gson.fromJson(response.get(), TransactionReportResponse.class));
            }

        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            throw new ObjectNotFoundException("Object not found");
        }

        return Optional.empty();
    }

    @Override
    public Optional<TransactionResponse> getTransaction(ClientRequest clientRequest, String authToken) {
        Gson gson = new Gson();

        try {
            if (authToken == null) {
                throw new AuthorizationException("Token not found");
            }

            Optional<String> response = service.getTransaction(clientRequest, authToken);

            if (response.isPresent()) {
                return Optional.of(gson.fromJson(response.get(), TransactionResponse.class));
            }

        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            throw new ObjectNotFoundException("Object not found");
        }

        return Optional.empty();
    }


}
