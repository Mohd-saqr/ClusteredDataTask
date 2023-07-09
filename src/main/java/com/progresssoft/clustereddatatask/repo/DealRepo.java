package com.progresssoft.clustereddatatask.repo;

import com.progresssoft.clustereddatatask.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface DealRepo extends JpaRepository<Deal,Long> {
    Optional<Deal> findByFromCurrencyAndToCurrencyAndDealAmount(
            String fromCurrency,
            String toCurrency,
            BigInteger dealAmount
    );
}
