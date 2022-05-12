package com.staff.flight.entity.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonRootName("error")
public class ErrorResponse {
    private String message;
    private int code;

    public ErrorResponse(Exception e, int code) {
        this(e.getMessage(), code);
    }

    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
