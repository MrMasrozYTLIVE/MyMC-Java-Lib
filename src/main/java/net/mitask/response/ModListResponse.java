package net.mitask.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
@SuppressWarnings("unused")
public class ModListResponse extends ApiResponse {
    private List<ModResult> mods;

    @Getter
    @ToString(callSuper = true)
    public static class ModResult {
        private String name, id, fileName, version, source, dependencies;
        private boolean essential;
    }
}
