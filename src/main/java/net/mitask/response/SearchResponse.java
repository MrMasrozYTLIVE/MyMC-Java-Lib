package net.mitask.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
@SuppressWarnings("unused")
public class SearchResponse extends ApiResponse {
    private int limit, offset, totalHits;
    private List<SearchResult> results;

    @Getter
    @ToString(callSuper = true)
    public static class SearchResult {
        private String title, description, server, client, installID;
        private int downloads;
    }
}
