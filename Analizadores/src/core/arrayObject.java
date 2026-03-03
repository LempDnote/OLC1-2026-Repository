/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luismonroy
 */
public class arrayObject {
    private List<Object> arreglos = new ArrayList<Object>();

    public arrayObject() {
    }

    
    
    public List<Object> getArreglos() {
        return arreglos;
    }

    public void setArreglos(List<Object> arreglos) {
        this.arreglos = arreglos;
    }
    
    public Object filter(int index){
        return arreglos.get(index);
    }
    
    
}
