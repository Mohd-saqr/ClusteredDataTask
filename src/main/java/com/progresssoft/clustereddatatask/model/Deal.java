package com.progresssoft.clustereddatatask.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity(name = "deal")
@Getter
@Setter
@Builder
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 3)
    @Column(name = "from_currency")
    private String fromCurrency;
    @NotEmpty
    @Column(name = "to_currency")
    private String toCurrency;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deal_date")
    private Date dealDate;
    @NotEmpty
    @Column(name = "deal_amount")
    private BigInteger dealAmount;

    public Deal() {
    }


    public Deal(String fromCurrency, String toCurrency, Date dealDate, BigInteger dealAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.dealDate = dealDate;
        this.dealAmount = dealAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return fromCurrency.equals(deal.fromCurrency) &&
                toCurrency.equals(deal.toCurrency) &&
                dealDate.equals(deal.dealDate) &&
                dealAmount.equals(deal.dealAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromCurrency, toCurrency, dealDate, dealAmount);
    }
}
