package com.merchant.controller;

import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.request.TransactionReportRequest;
import com.merchant.integration.merchant.response.transaction.TransactionResponse;
import com.merchant.integration.merchant.response.transaction.report.TransactionReportResponse;
import com.merchant.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @RequestMapping(method = RequestMethod.POST, path = "/transaction/report", produces = "application/json")
    public ResponseEntity<TransactionReportResponse> getTransactionReport(@RequestBody @Valid TransactionReportRequest transactionReportRequest,
                                                                          @RequestHeader(name = "Authorization") String authToken) {

        Optional<TransactionReportResponse> response = transactionService.getTransactionReport(transactionReportRequest, authToken);

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }

        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method = RequestMethod.POST, path = "/transaction", produces = "application/json")
    public ResponseEntity<TransactionResponse> getTransaction(@RequestBody @Valid ClientRequest clientRequest,
                                                              @RequestHeader(name = "Authorization") String authToken) {

        Optional<TransactionResponse> response = transactionService.getTransaction(clientRequest, authToken);

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }

        return ResponseEntity.noContent().build();

    }

}
