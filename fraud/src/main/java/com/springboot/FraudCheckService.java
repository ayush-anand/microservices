package com.springboot;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepositry fraudCheckHistoryRepositry;

//    public FraudCheckService(FraudCheckHistoryRepositry fraudCheckHistoryRepositry){
//        this.fraudCheckHistoryRepositry = fraudCheckHistoryRepositry;
//    } Replcae by @AllArgsConstructor

    public boolean idFraudulentCustomer(Integer id){
        fraudCheckHistoryRepositry.save(
                FraudCheckHistory.builder()
                        .customerId(id)
                        .createdAt(LocalDateTime.now())
                        .isFraudster(false).build()
        );
        return false;
    }
}
