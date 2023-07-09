package com.progresssoft.clustereddatatask.controller;

import com.progresssoft.clustereddatatask.dto.DealDto;
import com.progresssoft.clustereddatatask.dto.WebResponseDTO;
import com.progresssoft.clustereddatatask.services.DealServices;
import com.progresssoft.clustereddatatask.services.DealServicesImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DealController {

    private final DealServicesImp servicesImp;

    public DealController(DealServicesImp servicesImp) {
        this.servicesImp = servicesImp;
    }

    @PostMapping("/save_deal")
    public ResponseEntity<WebResponseDTO> saveDeal(@RequestBody DealDto dealDto){
        return servicesImp.saveDeal(dealDto);
    }
}
