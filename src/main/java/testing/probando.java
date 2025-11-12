package testing;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jesit
 */
public class probando {

    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        
        
        String nombre = "";
        String autor = "";
 
        do {
            System.out.println("Introduce el nombre del libro");
            nombre = teclado.nextLine();
            System.out.println("Introduce el autor");
            autor = teclado.nextLine();
           
        } while (nombre.equals(autor));

        System.err.println("Fin..................................");
    }
}
