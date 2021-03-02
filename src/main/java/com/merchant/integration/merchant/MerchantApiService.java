package com.merchant.integration.merchant;

import com.merchant.integration.merchant.request.AuthRequest;
import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.request.TransactionReportRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;


@FeignClient(url = "${merchant.service.url}", name = "merchantService")
public interface MerchantApiService {

    @PostMapping(path = "/merchant/user/login", consumes = "application/json", produces = "text/html")
    Optional<String> login(@RequestBody AuthRequest body);

    @PostMapping(path = "/client", consumes = "application/json", produces = "text/html")
    Optional<String> getClient(@RequestBody ClientRequest body, @RequestHeader("Authorization") String token);

    @PostMapping(path = "/transactions/report", consumes = "application/json", produces = "text/html")
    Optional<String> getTransactionReport(@RequestBody TransactionReportRequest body, @RequestHeader("Authorization") String token);

    @PostMapping(path = "/transaction", consumes = "application/json", produces = "text/html")
    Optional<String> getTransaction(@RequestBody ClientRequest body, @RequestHeader("Authorization") String token);

}
