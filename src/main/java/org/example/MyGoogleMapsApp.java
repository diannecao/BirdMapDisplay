package org.example;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class MyGoogleMapsApp {
    public static int latitude;
    public static int longitude;
    public static void main(String[] args) {
        // Create a GeoApiContext
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDOcoYlYmFNnDkn_jfjW6vioanEeN0va6I")
                .build();

        // Perform a geocoding request
        GeocodingResult[] results = GeocodingApi.geocode(context, "1600 Amphitheatre Parkway, Mountain View, CA")
                .awaitIgnoreError();

        // Process the geocoding results
        if (results != null && results.length > 0) {
            latitude = (int) results[0].geometry.location.lat;
            longitude = (int) results[0].geometry.location.lng;
            System.out.println("Latitude: " + latitude);
            System.out.println("Longitude: " + longitude);
        }
    }
}