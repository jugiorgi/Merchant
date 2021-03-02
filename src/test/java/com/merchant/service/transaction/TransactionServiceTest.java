package com.merchant.service.transaction;


import com.google.gson.Gson;
import com.merchant.integration.merchant.MerchantApiService;
import com.merchant.integration.merchant.request.AuthRequest;
import com.merchant.integration.merchant.request.ClientRequest;
import com.merchant.integration.merchant.request.TransactionReportRequest;
import com.merchant.integration.merchant.response.auth.AuthResponse;
import com.merchant.integration.merchant.response.client.CustomerInfo;
import com.merchant.integration.merchant.response.transaction.TransactionResponse;
import com.merchant.integration.merchant.response.transaction.report.Response;
import com.merchant.integration.merchant.response.transaction.report.TransactionReportResponse;
import com.merchant.service.auth.FakeAuthRestService;
import com.merchant.service.config.FakeFeignConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest(classes = {FakeFeignConfiguration.class, FakeAuthRestService.class, FakeTransactionRestService.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionServiceTest {

    @Autowired
    MerchantApiService service;

    @Test
    void testGetTransactionReport_happyPath() throws ParseException {
        Gson gson = new Gson();

        Optional<String> token = service.login(buildAuthRequest_happyPath());
        AuthResponse authResponse = gson.fromJson(token.get(), AuthResponse.class);

        Optional<String> response = service.getTransactionReport(buildTransactionReportRequest_happyPath(), authResponse.getToken());
        TransactionReportResponse transactionReportResponse = gson.fromJson(response.get(), TransactionReportResponse.class);

        Assertions.assertNotNull(transactionReportResponse);
        Assertions.assertEquals(buildTransactionReportResponse_happyPath().getStatus(), transactionReportResponse.getStatus());
        Assertions.assertEquals(buildTransactionReportResponse_happyPath().getResponse().get(0).getCount(), transactionReportResponse.getResponse().get(0).getCount());
        Assertions.assertEquals(buildTransactionReportResponse_happyPath().getResponse().get(0).getTotal(), transactionReportResponse.getResponse().get(0).getTotal());
        Assertions.assertEquals(buildTransactionReportResponse_happyPath().getResponse().get(0).getCurrency(), transactionReportResponse.getResponse().get(0).getCurrency());
    }

    @Test
    void testGetTransaction_happyPath() {
        Gson gson = new Gson();

        Optional<String> response = service.getTransaction(buildClientRequest_happyPath(), getToken(gson));
        TransactionResponse transactionResponse = gson.fromJson(response.get(), TransactionResponse.class);

        Assertions.assertNotNull(transactionResponse);
        Assertions.assertEquals(buildTransactionResponse_happyPath().getCustomerInfo().getId(), transactionResponse.getCustomerInfo().getId());
        Assertions.assertEquals(buildTransactionResponse_happyPath().getCustomerInfo().getNumber(), transactionResponse.getCustomerInfo().getNumber());
    }

    private String getToken(Gson gson) {
        Optional<String> token = service.login(buildAuthRequest_happyPath());
        AuthResponse authResponse = gson.fromJson(token.get(), AuthResponse.class);
        return authResponse.getToken();
    }

    private TransactionReportRequest buildTransactionReportRequest_happyPath() throws ParseException {
        Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-01");
        Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-17");

        return TransactionReportRequest.builder()
                .fromDate(fromDate)
                .toDate(toDate)
                .paymentMethod("CREDITCARD")
                .build();
    }

    private TransactionReportResponse buildTransactionReportResponse_happyPath() {
        List<Response> list = new ArrayList<>();
        list.add(Response.builder().count(2).total("101").currency("GBP").build());
        return TransactionReportResponse.builder()
                .status("APPROVED")
                .response(list)
                .build();
    }

    private ClientRequest buildClientRequest_happyPath() {
        return ClientRequest.builder()
                .transactionId("1032716-1613563524-3")
                .build();
    }

    private TransactionResponse buildTransactionResponse_happyPath() {
        return TransactionResponse.builder()
                .customerInfo(
                        CustomerInfo.builder()
                                .id(722975)
                                .number("516859XXXXXX4429")
                                .build()
                )
                .build();
    }

    private AuthRequest buildAuthRequest_happyPath() {
        return AuthRequest.builder()
                .email("demo@financialhouse.io")
                .password("cjaiU8CV")
                .build();
    }

}
