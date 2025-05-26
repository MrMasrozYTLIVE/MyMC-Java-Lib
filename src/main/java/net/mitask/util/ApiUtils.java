package net.mitask.util;

import kong.unirest.core.Unirest;
import kong.unirest.core.json.JSONObject;
import net.mitask.response.ApiResponse;

@SuppressWarnings("unused")
public class ApiUtils {
    /**
     * @param endpoint API Endpoint to send "GET" request
     * @param token API Token
     * @throws IllegalStateException if API Endpoint is not GET
     * @return Object that extends ApiResponse if success, null otherwise
     * @since 1.2.0
     * @author MiTask
     */
    @SuppressWarnings("unchecked")
    public static <T extends ApiResponse> T getRequest(ApiEndpoint endpoint, String token) {
        if(endpoint.getMethod() != ApiMethod.GET)
            throw new IllegalStateException("Tried to send a " + endpoint.getMethod() + " request to endpoint " + endpoint + " but only GET requests are supported");

        var req = Unirest.get("https://api.my-mc.link/" + endpoint.getEndpoint())
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("x-my-mc-auth", token);

        return (T) req
                .asObject(endpoint.getEndpointClass())
                .getBody();
    }

    /**
     * @param endpoint API Endpoint to send "POST" request
     * @param token API Token
     * @throws IllegalStateException if API Endpoint is not POST
     * @since 1.2.0
     * @author MiTask
     */
    @SuppressWarnings("unchecked")
    public static <T extends ApiResponse> T postRequest(ApiEndpoint endpoint, String token, JSONObject data) {
        if(endpoint.getMethod() != ApiMethod.POST)
            throw new IllegalStateException("Tried to send a " + endpoint.getMethod() + " request to endpoint " + endpoint + " but only POST requests are supported");

        return (T) Unirest.post("https://api.my-mc.link/" + endpoint)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("x-my-mc-auth", token)
                .body(data)
                .asObject(endpoint.getEndpointClass())
                .getBody();
    }

    /**
     * @param endpoint API Endpoint to send "GET" request
     * @param token API Token
     * @throws IllegalStateException if API Endpoint is not GET
     * @author MiTask
     */
    public static JSONObject getRequestJSON(ApiEndpoint endpoint, String token) {
        if(endpoint.getMethod() != ApiMethod.GET)
            throw new IllegalStateException("Tried to send a " + endpoint.getMethod() + " request to endpoint " + endpoint + " but only GET requests are supported");


        return Unirest.get("https://api.my-mc.link/" + endpoint)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("x-my-mc-auth", token)
                .asJson().getBody().getObject();
    }

    /**
     * @param endpoint API Endpoint to send "POST" request
     * @param token API Token
     * @throws IllegalStateException if API Endpoint is not POST
     * @author MiTask
     */
    public static JSONObject postRequestJSON(ApiEndpoint endpoint, String token, JSONObject data) {
        if(endpoint.getMethod() != ApiMethod.GET)
            throw new IllegalStateException("Tried to send a " + endpoint.getMethod() + " request to endpoint " + endpoint + " but only POST requests are supported");


        return Unirest.post("https://api.my-mc.link/" + endpoint)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("x-my-mc-auth", token)
                .body(data)
                .asJson().getBody().getObject();
    }

    /**
     * NOT USED SINCE 1.1.0
     * @deprecated
     * @param endpoint API Endpoint to send "DELETE" request
     * @param token API Token
     * @author MiTask
     */
    public static JSONObject deleteRequest(ApiEndpoint endpoint, String token) {
        return Unirest.delete("https://api.my-mc.link/" + endpoint)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("x-my-mc-auth", token)
                .asJson().getBody().getObject();
    }
}
