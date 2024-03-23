package com.app.library.handlers;

import com.app.library.exceptions.ErrorCodes;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private ErrorCodes code;
    private String message;
    private Set<String> errors=new HashSet<>();
}
