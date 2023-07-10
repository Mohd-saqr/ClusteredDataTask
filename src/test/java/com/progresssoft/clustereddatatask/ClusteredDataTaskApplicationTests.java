package com.progresssoft.clustereddatatask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.progresssoft.clustereddatatask.controller.DealController;
import com.progresssoft.clustereddatatask.dto.DealDto;
import com.progresssoft.clustereddatatask.dto.WebResponseDTO;
import com.progresssoft.clustereddatatask.exception.BusinessException;
import com.progresssoft.clustereddatatask.exception.DealAlreadyExists;
import com.progresssoft.clustereddatatask.services.DealServicesImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebMvcTest(controllers = DealController.class)
@AutoConfigureMockMvc
class ClusteredDataTaskApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DealServicesImp servicesImp;

    @Test
    public void testSaveDeal() throws Exception {
        // Create a DealDto object for the request body
        DealDto dealDto = new DealDto();
        dealDto.setFromCurrency("USD");
        dealDto.setToCurrency("EUR");
        dealDto.setDealDate(new Date());
        dealDto.setDealAmount(BigInteger.valueOf(100));

        WebResponseDTO expectedResponse = WebResponseDTO.builder()
                .massage("Deal Processed Successfully")
                .status(HttpStatus.CREATED)
                .build();


        Mockito.when(servicesImp.saveDeal(Mockito.any(DealDto.class))).thenReturn(ResponseEntity.status(HttpStatus.CREATED).body(expectedResponse));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/save_deal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dealDto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.massage").value(expectedResponse.getMassage())) // Updated JSON path
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(expectedResponse.getStatus().name()));
    }

    @Test
    public void testSaveDeal_DuplicateDeal() throws Exception {

        DealDto dealDto = new DealDto();
        dealDto.setFromCurrency("USD");
        dealDto.setToCurrency("EUR");
        dealDto.setDealDate(new Date());
        dealDto.setDealAmount(BigInteger.valueOf(100));


        Mockito.when(servicesImp.saveDeal(Mockito.any(DealDto.class)))
                .thenThrow(DealAlreadyExists.class);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/save_deal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dealDto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testSaveDeal_InvalidData() throws Exception {

        DealDto dealDto = new DealDto();
        dealDto.setFromCurrency("USD");
        dealDto.setToCurrency("EUR");
        dealDto.setDealDate(new Date());
        dealDto.setDealAmount(BigInteger.valueOf(-100));

        Mockito.when(servicesImp.saveDeal(Mockito.any(DealDto.class)))
                .thenThrow(BusinessException.class);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/save_deal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dealDto)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
