package com.progresssoft.clustereddatatask.services;

import com.progresssoft.clustereddatatask.dto.DealDto;
import com.progresssoft.clustereddatatask.dto.WebResponseDTO;

import com.progresssoft.clustereddatatask.model.Deal;
import org.springframework.http.ResponseEntity;


import java.util.Optional;

public interface DealServices {

    Optional<Deal>getDeal(Long id);
    void deleteDeal(Long id);
    Deal updateDeal(Long id);

    ResponseEntity<WebResponseDTO> saveDeal(DealDto dealDto) ;
}
