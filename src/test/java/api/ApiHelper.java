package api;


import com.squareup.okhttp.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiHelper {
    public static final String API_URL = "http://34.248.50.202/api/v0";

    public String login(String username, String password) throws IOException {
        Map parameters = new HashMap();
        parameters.put("username", username);
        parameters.put("password", password);
        return post("/auth-users/get-auth-token/", parameters);
    }

    public String post(String url, Map params) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, new JSONObject(params).toString());
        Request request = new Request.Builder()
                .url(API_URL + url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }
}
