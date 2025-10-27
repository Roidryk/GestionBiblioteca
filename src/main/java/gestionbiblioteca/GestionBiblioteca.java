/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package gestionbiblioteca;

import gestionbiblioteca.libros;
import java.util.ArrayList;
import java.util.Scanner;
import javax.smartcardio.ResponseAPDU;

/**
 *
 * @author jesit
 */
public class GestionBiblioteca {

    public static void añadirLibro(ArrayList<libros> lista, Scanner teclado) {

        System.out.println("Introduce el nombre del libro");
        String nombre = teclado.nextLine();

        System.out.println("Introduce el autor");
        String autor = teclado.nextLine();
        System.out.println("Introduce fecha del libro");
        int anio = teclado.nextInt();
        System.out.println("Estado del libro");
        boolean disponible = true;
        if (disponible) {
            System.out.println("Disponible");
        }

        libros librozero = new libros(nombre, autor, anio, disponible);
        lista.add(librozero);
        System.out.println("Libro añadido correctamente");

    }

    public static void bucasrLibro(ArrayList<libros> lista, Scanner teclado) {
        String buscona = "";
        for (libros a : lista) {
            System.out.println("1. Buscar por libro");
            System.out.println("2. Buscar por autor");
            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el libro");
                    buscona = teclado.nextLine();

                    if (a.getName().toLowerCase().contains(buscona.toLowerCase())) {
                        System.out.println("Opcion: " + lista.indexOf(a) + " \nTitulo libro: " + a.getName() + " \nAutor: " + a.getAutor());
                    } else {
                        System.out.println("No se ha encontraddo el libro");
                    }
                    break;

                case 2:

                    System.out.println("Introduce el autor");
                    buscona = teclado.nextLine();

                    if (a.getAutor().toLowerCase().contains(buscona.toLowerCase())) {
                        System.out.println("Opcion: " + lista.indexOf(a) + " \nTitulo libro: " + a.getName());
                    } else {
                        System.out.println("No se ha encontraddo el libro");
                    }
                    break;

                default:
                    throw new AssertionError();
            }
        }
    }

    public static void prestarLibro(ArrayList<libros> lista, Scanner teclado) {
        System.out.println("Libros disponibles para prestar");
        for (libros a : lista) {

            if (a.isDisponible() == true) {

                System.out.println("Opcion: " + lista.indexOf(a) + " \nTitulo: " + a.getName() + " \nAutor: " + a.getAutor() + " \nFecha: " + a.getAnio() + " \nDisponible: " + a.isDisponible() + "\n-----------------------");

                System.out.println("Desea pedir prestado algun libro del catalogo? s/n");
                teclado.nextLine();
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

                    System.out.println("Se ha prestado el libro correctamente...");

                } else if (resp.equalsIgnoreCase("n")) {
                    System.out.println("Saliendo....");
                }

            } else {
                System.out.println("No hay libros disponibles");
            }
        }

    }

    public static void devolverLibro(ArrayList<libros> lista, Scanner teclado) {
        System.out.println("Libros disponibles para deovoler");
        for (libros a : lista) {

            if (a.isDisponible() == false) {

                System.out.println("Opcion: " + lista.indexOf(a) + " \nTitulo: " + a.getName() + " \nAutor: " + a.getAutor() + " \nFecha: " + a.getAnio() + " \nDisponible: " + a.isDisponible() + "\n-----------------------");

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

                    System.out.println("Se ha devuelto el libro correctamente");
                } else if (resp.equalsIgnoreCase("n")) {
                    System.out.println("Saliendo...");

                }

            } else {
                System.out.println("No hay libros disponibles");
            }
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

                    for (libros a : listalibros) {
                        System.out.println("Opcion: " + listalibros.indexOf(a) + " \nTitulo: " + a.getName() + " \nAutor: " + a.getAutor() + " \nFecha: " + a.getAnio() + " \nDisponible: " + a.isDisponible() + "\n-----------------------");
                    }
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
