package org.dmitry.testtask.dto;

import lombok.Data;

@Data
public class Response {
    private final int result;
    private final String error;
}
