package net.mitask.response;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@SuppressWarnings("unused")
public class TimeResponse extends ApiResponse {
    private String keyexpireString, expireDate;
    private long expireEpoch;
}
