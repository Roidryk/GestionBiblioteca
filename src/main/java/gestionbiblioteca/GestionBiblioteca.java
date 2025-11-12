/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package gestionbiblioteca;

import com.mongodb.DBRef;
import com.mongodb.client.MongoCollection;
import gestionbiblioteca.libros;
import java.util.ArrayList;
import java.util.Scanner;
import javax.smartcardio.ResponseAPDU;
import org.bson.Document;

/**
 *
 * @author jesit
 */
public class GestionBiblioteca {

    public static void añadirLibro(ArrayList<libros> lista, Scanner teclado) {
        String nombre = "";
        String autor = "";

        DAOLibros libreriabd = new DAOLibros();
        lista = libreriabd.get();
        boolean encontrado;
        do {
            System.out.println("Introduce el nombre del libro");
            nombre = teclado.nextLine();
            System.out.println("Introduce el autor");
            autor = teclado.nextLine();
            encontrado = false;
            for (libros a : lista) {
                if (nombre.equalsIgnoreCase(a.getName()) && autor.equalsIgnoreCase(a.getAutor())) {
                    System.out.println("El libro ya existe");
                    encontrado = true;

                }
            }

        } while (encontrado);

        System.out.println("Quiere seguir con la operacion s/n");
        String resp = teclado.nextLine();

        if (resp.equalsIgnoreCase("s")) {

            System.out.println("Introduce fecha del libro");
            int anio = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Estado del libro");
            boolean disponible = true;
            if (disponible) {
                System.out.println("Disponible");

            }

            libros librozero = new libros(nombre, autor, anio, disponible);

            lista.add(librozero);
            DAOLibros libreriatop = new DAOLibros();
            libreriatop.añadir(librozero);

            System.out.println("Libro añadido correctamente");
        } else {

            System.out.println("Fin de la operación");

        }
    }

    public static void bucasrLibro(ArrayList<libros> lista, Scanner teclado) {
        String buscona = "";
        DAOLibros libreriabd = new DAOLibros();
        lista = libreriabd.get();
        System.out.println("1. Buscar por libro");
        System.out.println("2. Buscar por autor");
        int opcion = teclado.nextInt();
        teclado.nextLine();

        teclado.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Introduce el libro");
                buscona = teclado.nextLine();
                for (libros a : lista) {
                    if (a.getName().toLowerCase().contains(buscona.toLowerCase())) {
                        System.out.println("Opcion: " + lista.indexOf(a) + " \nTitulo libro: " + a.getName() + " \nAutor: " + a.getAutor());
                    }
                }
                break;

            case 2:

                System.out.println("Introduce el autor");
                buscona = teclado.nextLine();

                for (libros a : lista) {
                    if (a.getAutor().toLowerCase().contains(buscona.toLowerCase())) {
                        System.out.println("Opcion: " + lista.indexOf(a) + " \nTitulo libro: " + a.getName());
                    }
                }
                break;

            default:
                throw new AssertionError();
        }

    }

    public static void prestarLibro(ArrayList<libros> lista, Scanner teclado) {
        System.out.println("Libros disponibles para prestar");
        DAOLibros libreriabd = new DAOLibros();
        lista = libreriabd.get();

        for (libros a : lista) {

            if (a.isDisponible() == true) {

                System.out.println("Opcion: " + lista.indexOf(a) + " \nTitulo: " + a.getName() + " \nAutor: " + a.getAutor() + " \nFecha: " + a.getAnio() + " \nDisponible: " + a.isDisponible() + "\n-----------------------");

            }
        }
        System.out.println("Desea pedir prestado algun libro del catalogo? s/n");

        String resp = teclado.next();

        if (resp.equalsIgnoreCase("s")) {

            System.out.println("Elige un libro por la posicion para pedir prestado");

            int prestado = teclado.nextInt();
            while (lista.size() <= prestado || prestado < 0) {

                System.out.println("El libro no existe");

                prestado = teclado.nextInt();

            }

            libros libroPrestado = lista.get(prestado);

            libroPrestado.setDisponible(false);

            DAOLibros libreriatop = new DAOLibros();

            libreriatop.prestarLibro(libroPrestado);

            System.out.println("Se ha prestado el libro correctamente...");

        } else if (resp.equalsIgnoreCase("n")) {
            System.out.println("Saliendo....");
        }

    }

    public static void devolverLibro(ArrayList<libros> lista, Scanner teclado) {
        System.out.println("Libros disponibles para deovoler");
        DAOLibros libreriabd = new DAOLibros();
        lista = libreriabd.get();

        for (libros a : lista) {

            if (a.isDisponible() == false) {

                System.out.println("Opcion: " + lista.indexOf(a) + " \nTitulo: " + a.getName() + " \nAutor: " + a.getAutor() + " \nFecha: " + a.getAnio() + " \nDisponible: " + a.isDisponible() + "\n-----------------------");

            }
        }
        System.out.println("Desea devolver algun libro del catalogo? s/n");
        teclado.nextLine();
        String resp = teclado.next();

        if (resp.equalsIgnoreCase("s")) {

            System.out.println("Elige un libro por la posicion para devolver");
            int prestado = teclado.nextInt();

            while (lista.size() <= prestado || prestado < 0) {

                System.out.println("El libro no existe");
                prestado = teclado.nextInt();

            }

            libros libroPrestado = lista.get(prestado);

            libroPrestado.setDisponible(true);

            DAOLibros librosbd = new DAOLibros();

            librosbd.devolerLibro(libroPrestado);

            System.out.println("Se ha devuelto el libro correctamente");
        } else if (resp.equalsIgnoreCase("n")) {
            System.out.println("Saliendo...");

        }

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner teclado = new Scanner(System.in);

        ArrayList<libros> listalibros = new ArrayList<>();

        System.out.println("Gestio de Biblioteca");
        System.out.println("1. Agregar libro");
        System.out.println("2. Ver todos los libros");
        System.out.println("3. Buscar libro");
        System.out.println("4. Prestar libro");
        System.out.println("5. Devolver libro");
        System.out.println("6. Salir");

        int opcion = 0;

        while (opcion != 6) {
            System.out.println("Elige una opcion again");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:

                    añadirLibro(listalibros, teclado);

                    break;

                case 2:
                    System.out.println("Todos los libros");
                    DAOLibros librosbd = new DAOLibros();
                    librosbd.mostrarLibrosBD();

                    break;
                case 3:

                    bucasrLibro(listalibros, teclado);

                    break;
                case 4:
                    prestarLibro(listalibros, teclado);
                    break;
                case 5:
                    devolverLibro(listalibros, teclado);
                    break;

                case 6:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Error de seleccion");
            }
        }

    }
}
