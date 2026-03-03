/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbutils;

import java.util.HashMap;
import core.database;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author luismonroy
 * 26/02/26
 */
public class utils {
    
    
    public utils(){
        
    }
    
    //LempDnote: metodo para retornar una base de datos almacenada
    public database findDatabase(List<database> databases, String identifier){
        
        for (database database : databases) {
            if(database.getName().equalsIgnoreCase(identifier)){
                return database;
            }
        }
        return null;
    }   
}
