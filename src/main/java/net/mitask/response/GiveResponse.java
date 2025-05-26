package net.mitask.response;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@SuppressWarnings("unused")
public class GiveResponse extends ApiResponse {
    private String username, item;
    private int amount;
}
