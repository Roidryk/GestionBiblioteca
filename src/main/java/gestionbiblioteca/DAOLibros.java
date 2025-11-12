/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.TimeoutHelper;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.internal.connection.tlschannel.util.Util;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;
import org.bson.Document;
//import javax.swing.text.Document;

/**
 *
 * @author jesit
 */
public class DAOLibros {

    public void añadir(libros libritos) {
        MongoDatabase db = Conexionbd.conectar();
        MongoCollection<Document> todosLibros = db.getCollection("libros");

        Document nuevoLibro = new Document("name", libritos.getName()).
                append("autor", libritos.getAutor()).
                append("anio", libritos.getAnio()).
                append("disponible", libritos.isDisponible());

        todosLibros.insertOne(nuevoLibro);

        System.out.println("Se ha insertado correctamente el libro" + libritos.getName());
    }

    public void prestarLibro(libros libritos) {

        MongoDatabase db = Conexionbd.conectar();
        MongoCollection<Document> todosLibros = db.getCollection("libros");

        //Filters.eq("name", libritos.getName());
        //Updates.set("disponible", libritos.isDisponible());
        libritos.setDisponible(false);
        todosLibros.updateOne(Filters.eq("name", libritos.getName()), Updates.set("disponible", libritos.isDisponible()));
        System.out.println("Libro prestado " + libritos.getName());

    }

    public void devolerLibro(libros libritos) {

        MongoDatabase db = Conexionbd.conectar();
        MongoCollection<Document> todosLibros = db.getCollection("libros");

        libritos.setDisponible(true);
        todosLibros.updateOne(Filters.eq("name", libritos.getName()), Updates.set("disponible", libritos.isDisponible()));
        System.out.println("Libro devuelto" + libritos.getName());
    }

    public void mostrarLibrosBD() {
        MongoDatabase db = Conexionbd.conectar();
        MongoCollection<Document> todosLibros = db.getCollection("libros");

        FindIterable<Document> lista = todosLibros.find();

        for (Document doc : lista) {

            System.out.println("Titulo: " + doc.getString("name"));
            System.out.println("Autor: " + doc.getString("autor"));
            System.out.println("Anio: " + doc.getInteger("anio"));
            System.out.println("Disponible: " + doc.getBoolean("disponible"));
            System.out.println("--------------------------");

            
        }

    }

    public ArrayList<libros> get() {

        ArrayList<libros> listaPrincipal = new ArrayList<>();
        MongoDatabase db = Conexionbd.conectar();
        MongoCollection<Document> todosLibros = db.getCollection("libros");
        
       for (Document doc : todosLibros.find()) {

            String titulo = doc.getString("name");
            String autor = doc.getString("autor");
            int anio = doc.getInteger("anio");
            boolean disponible = doc.getBoolean("disponible");
           

            libros librosbd = new libros(titulo, autor, anio, disponible);
            
            listaPrincipal.add(librosbd);
            
        }
        
       return  listaPrincipal;

    }

}
