package net.mitask.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("unused")
public class ApiResponse {
    private boolean success;
    private String message;
}
