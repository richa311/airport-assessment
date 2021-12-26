package com.airports.api.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestException extends RuntimeException {

    private String errorMessage;
}
