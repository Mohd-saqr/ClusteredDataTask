package com.progresssoft.clustereddatatask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DealDto {

    private String fromCurrency;

    private String toCurrency;

    private Date dealDate;

    private BigInteger dealAmount;
}
