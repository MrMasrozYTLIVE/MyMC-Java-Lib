package net.mitask;

import kong.unirest.core.json.JSONObject;
import net.mitask.response.*;
import net.mitask.util.ApiEndpoint;
import net.mitask.util.ApiUtils;

@SuppressWarnings("unused")
public class MyMCLib {
    private final String token;

    public MyMCLib(String token) {
        this.token = token;

        ApiResponse reqBody = this.verifyToken();
        boolean tokenValid = reqBody.isSuccess();
        if(!tokenValid) throw new RuntimeException(reqBody.getMessage());
    }

    private ApiResponse verifyToken() {
        return ApiUtils.getRequest(ApiEndpoint.HELLO, this.token);
    }

    public TimeResponse getTime() {
        return ApiUtils.getRequest(ApiEndpoint.TIME, this.token);
    }

    public StatsResponse getStats() {
        return ApiUtils.getRequest(ApiEndpoint.STATS, this.token);
    }

    public ApiResponse getLog() {
        return ApiUtils.getRequest(ApiEndpoint.LOG, this.token);
    }

    public ApiResponse startServer() {
        return ApiUtils.getRequest(ApiEndpoint.START, this.token);
    }

    public ApiResponse stopServer() {
        return ApiUtils.getRequest(ApiEndpoint.STOP, this.token);
    }

    public ApiResponse restartServer() {
        return ApiUtils.getRequest(ApiEndpoint.RESTART, this.token);
    }

    public UrlResponse createMyLink() {
        return ApiUtils.getRequest(ApiEndpoint.MY_LINK, this.token);
    }

    public UrlResponse createMyGeyserLink() {
        return ApiUtils.getRequest(ApiEndpoint.MY_GEYSER_LINK, this.token);
    }

    public SftpResponse createLinkSFTP() {
        return ApiUtils.getRequest(ApiEndpoint.MY_SFTP, this.token);
    }

    public HashResponse getConnectionHash() {
        return ApiUtils.getRequest(ApiEndpoint.MY_HASH, this.token);
    }

    public HashResponse getGeyserHash() {
        return ApiUtils.getRequest(ApiEndpoint.MY_GEYSER_HASH, this.token);
    }

    public HashResponse getConnectionHashSFTP() {
        return ApiUtils.getRequest(ApiEndpoint.MY_HASH_SFTP, this.token);
    }

    public PlayerListResponse getOnlinePlayers() {
        return ApiUtils.getRequest(ApiEndpoint.LIST_PLAYERS, this.token);
    }

    public ApiResponse getWebsiteURL() {
        return ApiUtils.getRequest(ApiEndpoint.WEBSITE, this.token);
    }

    public ApiResponse getMapURL() {
        return ApiUtils.getRequest(ApiEndpoint.MAP, this.token);
    }

    public ApiResponse postBan(String username) {
        return ApiUtils.postRequest(ApiEndpoint.BAN, this.token,
                new JSONObject().append("username", username));
    }

    public ApiResponse postUnban(String username) {
        return ApiUtils.postRequest(ApiEndpoint.UNBAN, this.token,
                new JSONObject().append("username", username));
    }

    public ApiResponse postSay(String message) {
        return ApiUtils.postRequest(ApiEndpoint.SAY, this.token,
                new JSONObject().append("message", message));
    }

    public ApiResponse postTell(String username, String message) {
        return ApiUtils.postRequest(ApiEndpoint.TELL, this.token,
                new JSONObject().append("username", username).append("message", message));
    }

    public ApiResponse postConsole(String command) {
        return ApiUtils.postRequest(ApiEndpoint.CONSOLE, this.token,
                new JSONObject().append("message", command));
    }

    public GiveResponse postGive(String username, String item, int amount) {
        return ApiUtils.postRequest(ApiEndpoint.GIVE, this.token,
                new JSONObject().append("username", username).append("item", item).append("amount", amount));
    }

    public ModResponse installMod(String modID) {
        return ApiUtils.postRequest(ApiEndpoint.INSTALL, this.token,
                new JSONObject().append("mod", modID));
    }

    public ModResponse uninstallMod(String modID) {
        return ApiUtils.postRequest(ApiEndpoint.UNINSTALL, this.token,
                new JSONObject().append("mod", modID));
    }

    public SearchResponse searchMod(String modID) {
        return ApiUtils.postRequest(ApiEndpoint.SEARCH, this.token,
                new JSONObject().append("mod", modID));
    }
    public SearchResponse searchMod(String modID, int offset) {
        return ApiUtils.postRequest(ApiEndpoint.SEARCH, this.token,
                new JSONObject().append("mod", modID).append("offset", offset));
    }

    public ModListResponse getInstalledMods() {
        return ApiUtils.getRequest(ApiEndpoint.MOD_LIST, this.token);
    }
}
