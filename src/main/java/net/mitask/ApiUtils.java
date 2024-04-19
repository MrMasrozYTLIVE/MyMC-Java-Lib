package net.mitask;

import kong.unirest.core.Unirest;
import kong.unirest.core.json.JSONObject;

public class ApiUtils {
    public static JSONObject getRequest(ApiEndpoint endpoint, String token) {
        return Unirest.get("https://api.my-mc.link/" + endpoint)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("x-my-mc-auth", token)
                .asJson().getBody().getObject();
    }

    public static JSONObject deleteRequest(ApiEndpoint endpoint, String token) {
        return Unirest.delete("https://api.my-mc.link/" + endpoint)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("x-my-mc-auth", token)
                .asJson().getBody().getObject();
    }

    public static JSONObject postRequest(ApiEndpoint endpoint, String token, JSONObject data) {
        return Unirest.post("https://api.my-mc.link/" + endpoint)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("x-my-mc-auth", token)
                .body(data)
                .asJson().getBody().getObject();
    }
}
