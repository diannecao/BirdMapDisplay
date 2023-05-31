package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


// video to load jar
//https://www.youtube.com/watch?v=QAJ09o3Xl_0

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.Document;

// Program for print data in JSON format.
public class ReadJson {
    public static ArrayList<String> birdnames = new ArrayList<>();
    public static ArrayList<String> birdObserve = new ArrayList<>();

    public static void main(String args[]) throws ParseException {
        // In java JSONObject is used to create JSON object
        // which is a subclass of java.util.HashMap.

        JSONObject file = new JSONObject();
        file.put("Full Name", "Ritu Sharma");
        file.put("Roll No.", new Integer(1704310046));
        file.put("Tution Fees", new Double(65400));

        // To print in JSON format.
        // System.out.print(file.get("Tution Fees"));
        pull();
        pull2();
        Compare();



    }



    public static void pull2() throws ParseException {
        System.out.println("Start of pull 2: ");
        String output = "abc";
        String totlaJson="";
        try {

            URL url2 = new URL("https://api.ebird.org/v2/data/obs/US-MA/recent");
            //URL bird = new URL(url+"");
            HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-eBirdApiToken", "2h84e0svjti3");
            //conn.setRequestProperty("Accept", "application/json");



            if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            //System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                totlaJson+=output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONParser parser = new JSONParser();
            //System.out.println(str);
            Object test = (Object) parser.parse(totlaJson);
            //System.out.println(test);
            JSONArray hold= (JSONArray) test;



            JSONObject birdhold1;
            String birdhold2;
            for(int x=0;x<hold.size();x++) {
                JSONObject object1 = (JSONObject) hold.get(x);
                birdhold2 = (String) object1.get("sciName");
                birdObserve.add(birdhold2);
                // System.out.println(birdhold2);
            }
            System.out.println(birdObserve);

        }

        catch (Exception e) {
            e.printStackTrace();
        }






    }




    public static void pull() throws ParseException {
        String output = "abc";
        String totlaJson="";
        try {

            URL url = new URL("https://nuthatch.lastelm.software/birds");
            //URL bird = new URL(url+"");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("API-Key", "3570670e-1892-482a-8a2c-60c79374c897");
            //conn.setRequestProperty("Accept", "application/json");



            if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            //System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                //     System.out.println(output);
                totlaJson+=output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONParser parser = new JSONParser();
        //System.out.println(str);
        Object test = (Object) parser.parse(totlaJson);
        //System.out.println(test);
        JSONArray hold= (JSONArray) test;
        //System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");


        //System.out.println(hold.get(0));

        try {


            JSONObject birdhold1;
            String birdhold2;
            for(int x=0;x<hold.size();x++) {
                JSONObject object1 = (JSONObject) hold.get(x);
                birdhold2 = (String) object1.get("sciName");
                birdnames.add(birdhold2);
                // System.out.println(birdhold2);
            }
            System.out.println(birdnames);





/*

                org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("films");
                int n =   msg.size(); //(msg).length();
                for (int i = 0; i < n; ++i) {
                    String test =(String) msg.get(i);
                    System.out.println(test);
                   // System.out.println(person.getInt("key"));
                }
                String name= (String)jsonObject.get("name");
                System.out.println(name);

 */
        }

        catch (Exception e) {
            e.printStackTrace();
        }



    }
    public static void Compare(){
        int oblength = birdObserve.size();
        int namelength = birdnames.size();
        ArrayList<String> overlaplist = new ArrayList<>();
        int overlap=0;
        System.out.println("oblength+ " + oblength+ "       namelength+ "+ namelength);
        for(int n=0; n<namelength;n++){
            for(int o=0; o<oblength;o++){
                if(birdObserve.get(o).equals(birdnames.get(n))){
                    overlap++;
                    overlaplist.add(birdObserve.get(o));
                }
            }
        }
        System.out.println(overlap);

    }

}

