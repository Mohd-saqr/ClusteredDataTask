package com.progresssoft.clustereddatatask.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class RestExceptionObject {
    private final String massage;
    private final HttpStatus status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final ZonedDateTime time=ZonedDateTime.now();
}
