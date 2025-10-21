/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

/**
 *
 * @author jesit
 */
public class libros {
    
    String name;
    String autor;
    int anio;
    boolean disponible;
    
   public libros(String name, String autor, int anio, boolean disponible) {
        this.name = name;
        this.autor = autor;
        this.anio = anio;
        this.disponible = disponible;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

 
    
}
