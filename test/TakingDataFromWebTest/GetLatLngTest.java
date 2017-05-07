/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TakingDataFromWebTest;


/**
 *
 * @author Arnoldas
 */
import junit.framework.Assert;
import org.junit.Test;
import takingdatafromweb.*;


public class GetLatLngTest {
    Gas station = new Gas("Neste Taikos žiedo", "Taikos pr. 80A, Kaunas", "false", "false", "true");
    
    @Test
    public void TestGetAdress(){
        Assert.assertEquals("Taikos pr. 80A, Kaunas", station.getAdress());
    }
    
    @Test
    public void TestGetLatLng_WhenNotSet(){
        Assert.assertEquals(null, station.getLatitude());
        Assert.assertEquals(null, station.getLongtitude());
    }
    
    @Test
    public void TestGetLocationFromAdress() throws Exception{
        String[] expected = new String[] {"54.9120819", "23.9726480"};
        String[] result = GetLatLng.getLocationFromAddress(station.getAdress());
        Assert.assertEquals(expected[0], result[0]);
        Assert.assertEquals(expected[1], result[1]);
    }
    
    @Test
    public void TestSetLatLng(){
        station.setLatLng("54.9120819", "23.9726480");
        Assert.assertEquals("54.9120819", station.getLatitude());
        Assert.assertEquals("23.9726480", station.getLongtitude());
    }
}
