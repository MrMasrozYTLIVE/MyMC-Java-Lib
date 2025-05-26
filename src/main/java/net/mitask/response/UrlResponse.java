package net.mitask.response;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@SuppressWarnings("unused")
public class UrlResponse extends ApiResponse {
    private String action, hostname;
    private int port;
}
