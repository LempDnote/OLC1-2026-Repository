/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.util.HashMap;

import java.util.Map;

/**
 *
 * @author luismonroy
 */
public class table {
    
    
    private String name;
    private Map<String,Object> columns = new HashMap<String,Object>();
    private Map<String,Object> rows = new HashMap<String,Object>();
    private int index = 0;
    
    /*Constructor*/
    public table(){
        
    }
    
    /*Constructor sobrecarga de metodos*/
    public table(String name, Map<String,Object> temp) {
        this.name = name;
        this.columns = temp;
    }
    
    public String createTypes(Map<String,Object> types){
        this.columns = types;
        System.out.println("Columnas cargadas correctamente");
        return "Columnas cargadas correctamente";
    }
    
    public String addRows(Map<String,Object> values) throws java.lang.Error{
        this.rows.put(Integer.toString(index), values);
        return "Filas agregadas correctamente";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public String toString() {
        StringBuilder stringValues = new StringBuilder();
        stringValues.append("Nombre de Columnas");
        for(Map.Entry<String,Object> valores : this.columns.entrySet()){
            stringValues.append(valores.getKey());
            stringValues.append("\n");
        }
        stringValues.append("Valores");
        return stringValues.toString();
    }
    
    

    public Map<String, Object> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, Object> columns) {
        this.columns = columns;
    }
    
    
}
