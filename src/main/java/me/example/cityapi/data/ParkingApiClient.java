package me.example.cityapi.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.example.cityapi.model.Parking;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingApiClient {
    private static final String API_URL = "https://data.nantesmetropole.fr/api/explore/v2.1/catalog/datasets/244400404_parkings-publics-nantes-disponibilites/records";
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    public ParkingApiClient() {
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public List<Parking> getParkings() throws IOException {
        Request request = new Request.Builder()
                .url(API_URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Error during API call: " + response);
            }

            String responseBody = response.body().string();
            JsonNode root = objectMapper.readTree(responseBody);
            JsonNode results = root.get("results");
            
            List<Parking> parkings = new ArrayList<>();
            for (JsonNode result : results) {
                String name = result.get("grp_nom").asText();
                int availableSpaces = result.get("grp_disponible").asInt();
                int userSpaces = result.get("grp_exploitation").asInt();
                
                parkings.add(new Parking(name, availableSpaces, userSpaces));
            }
            
            return parkings;
        }
    }
} 