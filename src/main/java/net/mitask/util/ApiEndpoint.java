package net.mitask.util;

import lombok.Getter;
import net.mitask.response.*;

@Getter
public enum ApiEndpoint {
    HELLO("hello", ApiMethod.GET, ApiResponse.class),
    TIME("time", ApiMethod.GET, TimeResponse.class),
    STATS("stats", ApiMethod.GET, StatsResponse.class),
    LOG("log", ApiMethod.GET, ApiResponse.class),
    START("start", ApiMethod.GET, ApiResponse.class),
    STOP("stop", ApiMethod.GET, ApiResponse.class),
    RESTART("restart", ApiMethod.GET, ApiResponse.class),
    MY_LINK("my-link", ApiMethod.GET, UrlResponse.class),
    MY_GEYSER_LINK("my-geyser-link", ApiMethod.GET, UrlResponse.class),
    MY_SFTP("my-sftp", ApiMethod.GET, SftpResponse.class),
    MY_HASH("my-hash", ApiMethod.GET, HashResponse.class),
    MY_GEYSER_HASH("my-geyser-hash", ApiMethod.GET, HashResponse.class),
    MY_HASH_SFTP("my-sftp-hash", ApiMethod.GET, HashResponse.class),
    LIST_PLAYERS("list-players", ApiMethod.GET, PlayerListResponse.class),
    WEBSITE("website", ApiMethod.GET, ApiResponse.class),
    MAP("map", ApiMethod.GET, ApiResponse.class),
    BAN("ban",ApiMethod.POST, ApiResponse.class),
    UNBAN("unban", ApiMethod.POST, ApiResponse.class),
    SAY("say", ApiMethod.POST, ApiResponse.class),
    TELL("tell", ApiMethod.POST, ApiResponse.class),
    CONSOLE("console", ApiMethod.POST, ApiResponse.class),
    GIVE("give", ApiMethod.POST, GiveResponse.class),
    INSTALL("install", ApiMethod.POST, ModResponse.class),
    UNINSTALL("uninstall", ApiMethod.POST, ModResponse.class),
    SEARCH("search", ApiMethod.POST, SearchResponse.class),
    MOD_LIST("mod-list", ApiMethod.GET, ModListResponse.class);

    private final String endpoint;
    private final ApiMethod method;
    private final Class<? extends ApiResponse> endpointClass;

    @SuppressWarnings("unchecked")
    <T extends Class<?>> ApiEndpoint(String endpoint, ApiMethod method, T endpointClass) {
        this.endpoint = endpoint;
        this.method = method;
        this.endpointClass = (Class<? extends ApiResponse>) endpointClass;
    }
}
