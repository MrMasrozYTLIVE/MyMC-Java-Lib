package net.mitask.response;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@SuppressWarnings("unused")
public class StatsResponse extends ApiResponse {
    private Stats stats;

    @ToString
    @Getter
    public static class Stats {
        private String serverName, cpu;
        private Memory memory;

        @ToString
        @Getter
        public static class Memory {
            private String raw, percent;
        }
    }
}
