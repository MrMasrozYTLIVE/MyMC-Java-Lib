package net.mitask.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@SuppressWarnings("unused")
public class ModResponse extends ApiResponse {
    private String log;
}
