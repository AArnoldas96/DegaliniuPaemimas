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
    String miestas;
    String degaline;
    String adresas;
    String telefonas;
    String produktai;
    String [] papild;
    public Gas(){
        
    }
    public Gas(String miestas, String degaline, String adresas,String telefonas,String produktai,String [] papild){
        this.miestas=miestas;
        this.degaline=degaline;
        this.adresas=adresas;
        this.telefonas=telefonas;
        this.produktai=produktai;
        this.papild=papild;
    }
    
    
}
