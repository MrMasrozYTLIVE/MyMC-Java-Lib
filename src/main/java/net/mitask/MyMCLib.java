package net.mitask;

import kong.unirest.core.json.JSONObject;

public class MyMCLib {
    private final String token;

    public MyMCLib(String token) {
        this.token = token;

        JSONObject reqBody = this.verifyToken();
        boolean tokenValid = reqBody.getBoolean("success");
        if(!tokenValid) throw new RuntimeException(reqBody.getString("message"));
    }

    private JSONObject verifyToken() {
        return ApiUtils.getRequest(ApiEndpoint.HELLO, this.token);
    }

    public JSONObject getTime() {
        return ApiUtils.getRequest(ApiEndpoint.TIME, this.token);
    }

    public JSONObject getStats() {
        return ApiUtils.getRequest(ApiEndpoint.STATS, this.token);
    }

    public JSONObject getLog() {
        return ApiUtils.getRequest(ApiEndpoint.LOG, this.token);
    }

    public JSONObject startServer() {
        return ApiUtils.getRequest(ApiEndpoint.START, this.token);
    }

    public JSONObject stopServer() {
        return ApiUtils.getRequest(ApiEndpoint.STOP, this.token);
    }

    public JSONObject restartServer() {
        return ApiUtils.getRequest(ApiEndpoint.RESTART, this.token);
    }

    public JSONObject createMyLink() {
        return ApiUtils.getRequest(ApiEndpoint.MY_LINK, this.token);
    }

    public JSONObject deleteMyLink() {
        return ApiUtils.deleteRequest(ApiEndpoint.MY_LINK, this.token);
    }

    public JSONObject createLinkSFTP() {
        return ApiUtils.getRequest(ApiEndpoint.MY_SFTP, this.token);
    }

    public JSONObject deleteLinkSFTP() {
        return ApiUtils.deleteRequest(ApiEndpoint.MY_SFTP, this.token);
    }

    public JSONObject getConnectionHash() {
        return ApiUtils.getRequest(ApiEndpoint.MY_HASH, this.token);
    }

    public JSONObject getConnectionHashSFTP() {
        return ApiUtils.getRequest(ApiEndpoint.MY_HASH_SFTP, this.token);
    }

    public JSONObject getOnlinePlayers() {
        return ApiUtils.getRequest(ApiEndpoint.LIST_PLAYERS, this.token);
    }

    public JSONObject getWebsiteURL() {
        return ApiUtils.getRequest(ApiEndpoint.WEBSITE, this.token);
    }

    public JSONObject getMapURL() {
        return ApiUtils.getRequest(ApiEndpoint.MAP, this.token);
    }

    public JSONObject postBan(String username) {
        return ApiUtils.postRequest(ApiEndpoint.BAN, this.token,
                new JSONObject().append("username", username));
    }

    public JSONObject postUnban(String username) {
        return ApiUtils.postRequest(ApiEndpoint.UNBAN, this.token,
                new JSONObject().append("username", username));
    }

    public JSONObject postSay(String message) {
        return ApiUtils.postRequest(ApiEndpoint.SAY, this.token,
                new JSONObject().append("message", message));
    }

    public JSONObject postTell(String username, String message) {
        return ApiUtils.postRequest(ApiEndpoint.TELL, this.token,
                new JSONObject().append("username", username).append("message", message));
    }

    public JSONObject postConsole(String command) {
        return ApiUtils.postRequest(ApiEndpoint.CONSOLE, this.token,
                new JSONObject().append("message", command));
    }

    public JSONObject postGive(String username, String item, int amount) {
        return ApiUtils.postRequest(ApiEndpoint.GIVE, this.token,
                new JSONObject().append("username", username).append("item", item).append("amount", amount));
    }

    public JSONObject installMod(String modID) {
        return ApiUtils.postRequest(ApiEndpoint.INSTALL, this.token,
                new JSONObject().append("mod", modID));
    }

    public JSONObject uninstallMod(String modID) {
        return ApiUtils.postRequest(ApiEndpoint.UNINSTALL, this.token,
                new JSONObject().append("mod", modID));
    }

    public JSONObject getInstalledMods() {
        return ApiUtils.getRequest(ApiEndpoint.MOD_LIST, this.token);
    }
}
