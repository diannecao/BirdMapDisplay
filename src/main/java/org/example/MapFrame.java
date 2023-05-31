package org.example;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class MapFrame /*extends JFrame*/ {
    private GeoApiContext context;

    JFrame mainframe;
//    public void MapComponent() throws IOException {
//        setLayout(new BorderLayout());
//
//        // Create a GeoApiContext
//        context = new GeoApiContext.Builder()
//                .apiKey("AIzaSyDOcoYlYmFNnDkn_jfjW6vioanEeN0va6I")
//                .build();
//
//        // Perform a geocoding request
//        GeocodingResult[] results = GeocodingApi.geocode(context, "1600 Amphitheatre Parkway, Mountain View, CA")
//                .awaitIgnoreError();
//
//        // Process the geocoding results
//        if (results != null && results.length > 0) {
//            double latitude = results[0].geometry.location.lat;
//            double longitude = results[0].geometry.location.lng;
//            System.out.println(latitude);
//            System.out.println(longitude);
//
//            // Create a Google Maps URL for the location
//            String url = "https://www.google.com/maps/embed/v1/view" +
//                    "?center=" + latitude + "," + longitude +
//                    "&zoom=150" +
//                    "&key=AIzaSyDOcoYlYmFNnDkn_jfjW6vioanEeN0va6I";
//            //String hardurl = "https://www.google.com/maps/embed/v1/view?center=37+-122&zoom=15&key=AIzaSyDOcoYlYmFNnDkn_jfjW6vioanEeNOva6I";
//
//
//            // Create an embedded Google Maps web page using a JEditorPane
//            JEditorPane editorPane = new JEditorPane();
//            editorPane.setEditable(false);
//            editorPane.setPage(url);
//
//            // Add the JEditorPane to the JPanel
//            add(new JScrollPane(editorPane), BorderLayout.CENTER);
//        }
//    }

    public MapFrame() throws IOException {
        mainframe = new JFrame();

        mainframe.setTitle("Google Maps API Demo");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe. setSize(800, 600);
        mainframe.setLocationRelativeTo(null); // Center the frame on the screen
        JButton plswork = new JButton("try1");

        mainframe.add(plswork);
        // Create the map component and add it to the frame
         MapComponent mapComponent = new MapComponent();
         mainframe.add(mapComponent.pannel);
       // setContentPane(mapComponent);
       // mainframe.add(mapComponent);
        mainframe.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MapFrame frame = new MapFrame();
//                JButton plswork = new JButton("try");
//                frame.add(plswork);
              //  frame.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
