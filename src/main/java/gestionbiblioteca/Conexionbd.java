/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionbiblioteca;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author jesit
 */
public class Conexionbd {

   /* private MongoDatabase conectar;
    
    public Conexionbd(){
        
        String url = "mongodb://localhost:27017";

        MongoClient clienteMongo = MongoClients.create(url);

        MongoDatabase database = clienteMongo.getDatabase("GestionLibros");

        System.out.println("Conexion exitosa a: " + database.getName());
        
    }
    
      public MongoDatabase getConectar() {
        return conectar;
    }*/
    
    
    public static MongoDatabase conectar() {

        String url = "mongodb://localhost:27017";

        MongoClient clienteMongo = MongoClients.create(url);

        MongoDatabase database = clienteMongo.getDatabase("GestionLibros");

        System.out.println("Conexion exitosa a: " + database.getName());

        return database;

    }

    /*public static void main(String[] args) {
        conectar();
    }*/

  
    
    
}
