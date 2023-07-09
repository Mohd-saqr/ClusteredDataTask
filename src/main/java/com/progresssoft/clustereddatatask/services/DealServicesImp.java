package com.progresssoft.clustereddatatask.services;

import com.progresssoft.clustereddatatask.dto.DealDto;
import com.progresssoft.clustereddatatask.dto.WebResponseDTO;
import com.progresssoft.clustereddatatask.exception.DealAlreadyExists;
import com.progresssoft.clustereddatatask.model.Deal;
import com.progresssoft.clustereddatatask.repo.DealRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DealServicesImp implements DealServices {

    private final DealRepo dealRepo;

    public DealServicesImp(DealRepo dealRepo) {
        this.dealRepo = dealRepo;
    }

    @Transactional
    @Override
    public ResponseEntity<WebResponseDTO> saveDeal(DealDto dealDto)  {
        /**
         * check the deal if existed and save it;
         */
        Optional<Deal> existingDeal = dealRepo.findByFromCurrencyAndToCurrencyAndDealAmount(
                dealDto.getFromCurrency(),
                dealDto.getToCurrency(),
                dealDto.getDealAmount()
        );

        if (existingDeal.isPresent())
            throw new DealAlreadyExists("Deal Already Exists ");

        Deal newDeal = Deal.builder().
                fromCurrency(dealDto.getFromCurrency())
                .toCurrency(dealDto.getToCurrency())
                .dealAmount(dealDto.getDealAmount())
                .build();

        dealRepo.save(newDeal);


        return new ResponseEntity<>(WebResponseDTO.builder()
                .massage("Deal Processed Successfully")
                .status(HttpStatus.ACCEPTED).build(),
                HttpStatus.OK
        );
    }

    @Override
    public Optional<Deal> getDeal(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteDeal(Long id) {

    }

    @Override
    public Deal updateDeal(Long id) {
        return null;
    }


}
