package com.employeemanagement.exception;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyErrorDetails {
    private LocalDateTime localDateTime;
    private String message;
    private String details;
}