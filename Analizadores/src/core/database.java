/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.util.HashMap;
import java.util.Map;
import core.table;
/**
 *
 * @author luismonroy
 */
public class database {
    
    
    private String name;
    private String path;
    
    /**
     * 
     */
    private Map<String,table> tables = new HashMap<String,table>();

    public database() {
    }

    public database(String name) {
        this.name = name;
    }
    
    public database(String name, String path) {
        this.name = name;
        this.path = path;
    }
    
    public String addTable(String nombre, table table){
        try{
            this.tables.put(nombre, table);
        }catch(Exception error){
            return error.getMessage();
        }
        return "Tabla creada con exito";
    }
    
    public String addTable(table table){
        try{
            this.tables.put(table.getName(),table);
        }catch(Exception e){
            return e.getMessage();
        }   
        return "Tabla creada con exito";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String addValues(String nameTable, Map<String,Object> values){
        table tabla = this.tables.get(nameTable);
        if(tabla != null){
            tabla.addRows(values);
        }else{
            return "No se agregaron los registros, no existe una tabla con este nombre";
        }
        return "Valores agregados con exito";
    }
    
    

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("database{" + "name=" + name + ", path=" + path);
        string.append(" tables=");
        for(Map.Entry<String,table> valores : this.tables.entrySet()){
            string.append(valores.getKey());
            string.append("\n");
        }
        string.append("}");
        return string.toString();
    }
}
