package com.merchant.service.transaction;

import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.request.TransactionReportRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/transaction/report")
public class FakeTransactionRestService {

    @PostMapping(path = "/transactions/report", consumes = "application/json", produces = "text/html")
    Optional<String> getTransactionReport(@RequestBody TransactionReportRequest body, @RequestHeader("Authorization") String token) {
        return Optional.empty();
    }

    @PostMapping(path = "/transaction", consumes = "application/json", produces = "text/html")
    Optional<String> getTransaction(@RequestBody ClientRequest body, @RequestHeader("Authorization") String token) {
        return Optional.empty();
    }
}
