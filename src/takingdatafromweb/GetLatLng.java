/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takingdatafromweb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;

/**
 *
 * @author Arnoldas
 */
public class GetLatLng {
    
    public static void main(String[] args) throws Exception {
        Gas[] stationArray = readFiles("stationsAuto.txt");
        writeStationsToFile(stationArray, "stationsAutoLatLng.txt");
    }
    
    public static Gas[] readFiles(String filepath) throws Exception{
        List<String> stations = readLine(filepath);
        Gas[] stationArray = new Gas[stations.size()];
        StationMaking(stations, stationArray);
        for (Gas station : stationArray) {
            try{
            String[] LatLng = getLocationFromAddress(station.adresas);
            System.out.printf("%s %s %s\n", station.adresas, LatLng[0], LatLng[1]);
            station.setLatLng(LatLng[0], LatLng[1]);
            } 
            catch (Exception e) {
            e.printStackTrace();
            }
        }
        return stationArray;
    }



    public static List<String> readLine(String path) {
        List<String> mLines = new ArrayList<>();

        try {
            FileReader fr = new FileReader(path);
            BufferedReader reader = new BufferedReader(fr);
            String line;

            while ((line = reader.readLine()) != null)
                mLines.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mLines;
    }

    private static void StationMaking(List<String> stations, Gas[] stationArray){
        int i = 0;
        for (String station : stations){
            String[] parts = station.split(";");
            if (parts.length > 3)
                stationArray[i++] = new Gas(parts[1], parts[0], parts[2], parts[3], parts[4]);
        }
    }
    
    private static String[] getLocationFromAddress(String address) throws Exception{
        TimeUnit.MILLISECONDS.sleep(250);
        int responseCode = 0;
        String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
        System.out.println("URL : "+api);
        URL url = new URL(api);
        HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
        httpConnection.connect();
        responseCode = httpConnection.getResponseCode();
            if(responseCode == 200)
            {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
            Document document = builder.parse(httpConnection.getInputStream());
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/GeocodeResponse/status");
            String status = (String)expr.evaluate(document, XPathConstants.STRING);
            if(status.equals("OK"))
                {
                    expr = xpath.compile("//geometry/location/lat");
                    String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
                    expr = xpath.compile("//geometry/location/lng");
                    String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
                    return new String[] {latitude, longitude};
                }
            else
                throw new Exception("Error from the API - response status: "+status);
            }      
        return null;
    }
    
    public static void writeStationsToFile(Gas[] stations, String filename) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
            for (int i = 0; i < stations.length; i++) {
                if (stations[i].latitude != null && stations[i].longtitude != null){
                    writer.write(stations[i].toStringWithLatLng());
                    writer.newLine();
                }
            }
        }
    }
}
