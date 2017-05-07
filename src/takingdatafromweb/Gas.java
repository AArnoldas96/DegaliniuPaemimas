/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takingdatafromweb;

import java.util.List;

/**
 *
 * @author X
 */
public class Gas {
    private String adresas;
    private String pav;
    private String food;
    private String air;
    private String carwash;
    private String latitude;
    private String longtitude;
    
    public Gas(){
        
    }
    public Gas(String pav, String adresas, String maistas, String oras, String plovykla){
        this.pav = pav;
        this.adresas=adresas;
        this.food = maistas;
        this.air = oras;
        this.carwash = plovykla;
    }
    
    @Override
    public String toString(){
        String result = this.adresas+";"+this.pav+";"+this.food+";"+this.air+";"+this.carwash;
        return result;
    }
    
    public String toStringWithLatLng(){
        String result = this.adresas+";"+this.pav+";"+this.food+";"+this.air+";"+this.carwash+";"+this.latitude+";"+this.longtitude;
        return result;
    }
    
    public void setLatLng(String lat, String lng){
        this.latitude = lat;
        this.longtitude = lng;
    }
    
    public String getAdress(){
        return this.adresas;
    }
    
    public String getLatitude(){
        return this.latitude;
    }
    
    public String getLongtitude(){
        return this.longtitude;
    }
}
