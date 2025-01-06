package com.springboot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

//    public FraudCheckController(FraudCheckService fraudCheckService) {
//        this.fraudCheckService = fraudCheckService;
//    }  /// Replace by  @AllArgsConstructor

    @GetMapping(path= "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){

        boolean fraudulentCustomer =  fraudCheckService.idFraudulentCustomer(customerId);
        log.info("Fraud check for id : {} resposne : {} ",customerId,fraudulentCustomer);
        return new FraudCheckResponse(fraudulentCustomer);
    }
}
