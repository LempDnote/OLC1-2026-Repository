/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analizadores;

import analisis.Lexer;
import analisis.Parser;
import core.database;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luismonroy
 */
public class Analizadores {

    Class<?> tipo = Object.class;
    Class<?> tipo2 = Integer.class;
    Class<?> tipo3 = String.class;
    Class<?> tipo4 = Float.class;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map<String, String> eli_db = new HashMap<String, String>();
        List<database> databases = new ArrayList<>();
        database activeDB = new database();
        database datos = new database();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa una expresion (termina con END):");

            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equals("END")) {
                    break;
                }
                sb.append(line).append("\n");
            }

            String cadena = sb.toString();
            Lexer scanner = new Lexer(new StringReader(cadena));
            List<String> errores = scanner.getErrors();
            for (String error : errores) {
                System.out.println(error);
            }
            Parser parser = new Parser(scanner);
            try {
                parser.setDatabases(databases);
                parser.setActiveDB(activeDB);
                Object value = parser.parse().value;
                databases = parser.getDatabases();
                activeDB = parser.getActiveDB();
                for (database database : databases) {
                    System.out.println(database.toString());
                }
            } catch (Exception e) {
                System.out.println("Error al inicializar el parser");
                e.printStackTrace();
            }
        }

    }

    public void Mensaje() {

    }

}
