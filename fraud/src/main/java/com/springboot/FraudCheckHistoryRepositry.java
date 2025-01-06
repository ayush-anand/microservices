package com.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepositry
        extends JpaRepository<FraudCheckHistory,Integer> {

}
