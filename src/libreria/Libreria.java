package libreria;

import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

public class Libreria {

    public static void main(String[] args) {

        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        LibroServicio ls = new LibroServicio();
        Scanner leer = new Scanner(System.in);

        System.out.println("~~¡BIENVENIDO!~~");
        System.out.println("----------------------------------------");
        System.out.println("1. Buscar libro por titulo");
        System.out.println("----------------------------------------");
        System.out.println("2. Buscar libro por isbn");
        System.out.println("----------------------------------------");
        System.out.println("3. Buscar libro por autor");
        System.out.println("----------------------------------------");
        System.out.println("4. Buscar libro por editorial");
        System.out.println("----------------------------------------");
        System.out.println("5. Guardar un nuevo libro");
        System.out.println("----------------------------------------");
        System.out.println("6. Editar un libro");
        System.out.println("----------------------------------------");
        System.out.println("7. Eliminar un libro del sistema");
        System.out.println("----------------------------------------");
        System.out.println("8. Guardar nueva editorial");
        System.out.println("----------------------------------------");
        System.out.println("9. Editar una editorial");
        System.out.println("----------------------------------------");
        System.out.println("10. Eliminar una editorial");
        System.out.println("----------------------------------------");
        System.out.println("11. Guardar un nuevo autor");
        System.out.println("----------------------------------------");
        System.out.println("12. Editar un autor");
        System.out.println("----------------------------------------");
        System.out.println("13. Eliminar un autor");
        System.out.println("----------------------------------------");
        System.out.print("- ");

        int n = leer.nextInt();

        try {
            switch (n) {
                case 1:
                    System.out.println("Ingrese el titulo del libro a buscar");
                    System.out.print("- ");
                    String titulo = leer.next();
                    ls.listarTitulo(titulo);
                    break;
                case 2:
                    System.out.println("Ingrese el isbn del libro a buscar");
                    System.out.print("- ");
                    String isbn = leer.next();
                    ls.buscarPorISBN(isbn);
                    break;
                case 3:
                    System.out.println("Ingrese el autor del libro a buscar");
                    System.out.print("- ");
                    String id = leer.next();
                    String nombre = leer.next();
                    Autor a = new Autor();
                    a.setId(id);
                    a.setNombre(nombre);
                    ls.listarAutor(a);
                    break;
                case 4:
                    System.out.println("Ingrese la editorial del libro a buscar");
                    System.out.print("- ");
                    id = leer.next();
                    nombre = leer.next();
                    Editorial e = new Editorial();
                    e.setId(id);
                    e.setNombre(nombre);
                    ls.listarEditorial(e);
                    break;
                case 5:
                    System.out.println("Ingrese el isbn del nuevo libro");
                    System.out.print("- ");
                    isbn = leer.next();
                    System.out.println("Ingrese el titulo del nuevo libro");
                    System.out.print("- ");
                    titulo = leer.next();
                    System.out.println("Ingrese el año de emision del libro");
                    System.out.print("- ");
                    Integer anio = leer.nextInt();
                    System.out.println("Ingrese el nombre y el id del autor del libro");
                    System.out.print("- ");
                    nombre = leer.next();
                    System.out.print("- ");
                    id = leer.next();
                    a = null;
                    a.setId(id);
                    a.setNombre(nombre);
                    System.out.println("Ingrese el nombre y el id de editorial del nuevo libro");
                    System.out.print("- ");
                    String nombreE = leer.next();
                    System.out.print("- ");
                    String idE = leer.next();
                    e = null;
                    e.setId(idE);
                    e.setNombre(nombreE);
                    ls.crear(titulo, isbn, anio, a, e);
                    break;
                case 6:
                    System.out.println("Ingrese el nuevo titulo");
                    System.out.print("- ");
                    titulo = leer.next();
                    System.out.println("Ingrese el nuevo isbn");
                    System.out.print("- ");
                    isbn = leer.next();
                    ls.editar(titulo, isbn);
                    break;
                case 7:
                    System.out.println("Ingrese el titulo e isbn del libro a eliminar");
                    System.out.print("- ");
                    titulo = leer.next();
                    System.out.print("- ");
                    isbn = leer.next();
                    ls.eliminar(titulo, isbn);
                    break;
                case 8:
                    System.out.println("Ingrese el nombre y id");
                    System.out.print("- ");
                    nombre = leer.next();
                    System.out.print("- ");
                    id = leer.next();
                    es.crear(nombre, id);
                    break;
                case 9:
                    System.out.println("Ingrese el nuevo id y nombre");
                    System.out.print("- ");
                    id = leer.next();
                    System.out.print("- ");
                    nombre = leer.next();
                    es.editar(nombre, id);
                    break;
                case 10:
                    System.out.println("Ingrese el nombre e id de la editorial a eliminar");
                    System.out.print("- ");
                    nombre = leer.next();
                    System.out.print("- ");
                    id = leer.next();
                    es.eliminar(nombre, id);
                    break;
                case 11:
                    System.out.println("Ingrese el nombre y el id");
                    System.out.print("- ");
                    nombre = leer.next();
                    System.out.print("- ");
                    id = leer.next();
                    as.crear(nombre, id);
                    break;
                case 12:
                    System.out.println("Ingrese el nuevo nombre y id");
                    System.out.print("- ");
                    nombre = leer.next();
                    System.out.print("- ");
                    id = leer.next();
                    as.editar(nombre, id);
                    break;
                case 13:
                    System.out.println("Ingrese el nombre y id del autor a eliminar");
                    System.out.print("- ");
                    nombre = leer.next();
                    System.out.print("- ");
                    id = leer.next();
                    as.eliminar(nombre, id);
                    break;
                default:

                    System.out.println("GRACIAS POR CONFIAR EN NOSOTROS <3");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
