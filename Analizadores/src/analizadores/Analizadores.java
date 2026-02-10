/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analizadores;


import analisis.Lexer;
import analisis.Parser;
import java.io.StringReader;
import java.util.Scanner;
/**
 *
 * @author luismonroy
 */
public class Analizadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner texto = new Scanner(System.in);
        System.out.println("Ingresa una expresion: ");
        String cadena = texto.nextLine();
        Lexer scanner = new Lexer(new StringReader(cadena));
        Parser parser = new Parser(scanner);
        try{
            Object value = parser.parse().value;
            System.out.println("Token leido:"+ value);
        }catch(Exception error){
            System.out.println("Error al inicializar el parser");
        }
        
        
    }
    
}
