/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.TimeoutHelper;
import org.bson.Document;
//import javax.swing.text.Document;

/**
 *
 * @author jesit
 */
public class DAOLibros {
    
    public void añadir (libros libritos){
        MongoDatabase db = Conexionbd.conectar();
        MongoCollection<Document> todosLibros = db.getCollection("libros"); 
        
        Document nuevoLibro = new Document("name", libritos.getName()).
                append("autor", libritos.getAutor()).
                append("anio", libritos.getAnio()).
                append("disponible", libritos.isDisponible());
        
        todosLibros.insertOne(nuevoLibro);
        
        for (Document doc : todosLibros.find()) {
            System.out.println("Libro añadido a la base de datos" + doc.getString("name"));
        }
    }
    
}
