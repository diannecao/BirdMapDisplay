package org.example;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MapComponent/* extends JPanel */{

    private GeoApiContext context;
    JPanel pannel;

    public MapComponent() throws IOException {
        pannel = new JPanel();
        pannel.setLayout(new BorderLayout());

        // Create a GeoApiContext
        context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDOcoYlYmFNnDkn_jfjW6vioanEeN0va6I")
                .build();

        // Perform a geocoding request
        GeocodingResult[] results = GeocodingApi.geocode(context, "1600 Amphitheatre Parkway, Mountain View, CA")
                .awaitIgnoreError();

        // Process the geocoding results
        if (results != null && results.length > 0) {
            double latitude = results[0].geometry.location.lat;
            double longitude = results[0].geometry.location.lng;
            System.out.println(latitude);
            System.out.println(longitude);

            // Create a Google Maps URL for the location
            String url = "https://www.google.com/maps/embed/v1/view" +
                    "?center=" + latitude + "," + longitude +
                    "&zoom=150" +
                    "&key=AIzaSyDOcoYlYmFNnDkn_jfjW6vioanEeN0va6I";
            //String hardurl = "https://www.google.com/maps/embed/v1/view?center=37+-122&zoom=15&key=AIzaSyDOcoYlYmFNnDkn_jfjW6vioanEeNOva6I";


            // Create an embedded Google Maps web page using a JEditorPane

            //edior pain is the problem :8)

            //posible fix: rip html from url, put it in one string, setText to be the string with html
            JEditorPane editorPane = new JEditorPane(url);
            editorPane.setEditable(false);
            //editorPane.setPage(url);
            editorPane.setContentType("text/html");
            editorPane.setText("<html><body><h1>Hello</h1></body></html>");

            JButton plswokr = new JButton("try 2");
            pannel.add(plswokr);

            // Add the JEditorPane to the JPanel
//            pannel.add(new JScrollPane(editorPane), BorderLayout.CENTER);
            pannel.add(editorPane, BorderLayout.CENTER);
        }
    }
}
