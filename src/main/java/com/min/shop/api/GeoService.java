package com.min.shop.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class GeoService {

    private static final String GOOGLE_MAPS_API_KEY = "구글맵스 API KEY를 여기에 입력";
    private static final String GEOCODING_API_URL = "https://maps.googleapis.com/maps/api/geocode/json?latlng=%s,%s&key=%s";


    public String getAddressFromCoordinates(double latitude, double longitude) {
        try {
            String url = String.format(GEOCODING_API_URL, latitude, longitude, GOOGLE_MAPS_API_KEY);
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);
                JsonArray results = jsonObject.getAsJsonArray("results");
                if (results.size() > 0) {
                    JsonObject firstResult = results.get(0).getAsJsonObject();
                    return firstResult.get("formatted_address").getAsString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
