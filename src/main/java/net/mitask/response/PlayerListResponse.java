package net.mitask.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
@Getter
@SuppressWarnings("unused")
public class PlayerListResponse extends ApiResponse {
    private List<String> players;
}
