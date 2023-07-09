package com.progresssoft.clustereddatatask.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class WebResponseDTO {
    private final HttpStatus status;
    private final String massage;
    private final ZonedDateTime time = ZonedDateTime.now();
}
