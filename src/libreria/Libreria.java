package libreria;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

public class Libreria {

    public static void main(String[] args) {

        try {
            EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
            EntityManager em = EMF.createEntityManager();

            AutorServicio as = new AutorServicio();
            EditorialServicio es = new EditorialServicio();
            LibroServicio ls = new LibroServicio();
            Libro l = new Libro();
            Scanner leer = new Scanner(System.in).useDelimiter("\n");

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
            System.out.println("14. Listar todo");
            System.out.println("----------------------------------------");
            System.out.print("- ");

            int n = leer.nextInt();

            try {
                Autor a = new Autor();
                Editorial e = new Editorial();

                switch (n) {
                    case 1:
                        System.out.println("Ingrese el titulo del libro a buscar");
                        System.out.print("- ");
                        String titulo = leer.next();
                        System.out.println(ls.listarTitulo(titulo));
                        break;
                    case 2:
                        System.out.println("Ingrese el isbn del libro a buscar");
                        System.out.print("- ");
                        String isbn = leer.next();
                        ls.buscarPorISBN(isbn);
                        break;
                    case 3:
                        System.out.println("Ingrese el ID del autor del libro a buscar");
                        System.out.print("- ");
                        String id = leer.next();
                        ls.listarAutor(as.buscarPorID(id));
                        break;
                    case 4:
                        System.out.println("Ingrese el ID de la editorial del libro a buscar");
                        System.out.print("- ");
                        id = leer.next();
                        ls.listarEditorial(es.buscarPorID(id));
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
                        Integer eje = 1;
                        System.out.println("Ingrese el ID del autor del libro");
                        System.out.print("- ");
                        id = leer.next();
                        System.out.println("Ingrese el ID de la editorial del libro");
                        System.out.print("- ");
                        String idE = leer.next();
                        ls.crear(titulo, isbn, anio, eje, as.buscarPorID(id), es.buscarPorID(idE));

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
                        System.out.println("Ingrese el titulo del libro a eliminar");
                        System.out.print("- ");
                        titulo = leer.next();
                        ls.eliminar(titulo);
                        break;
                    case 8:
                        System.out.println("Ingrese el nombre y id");
                        System.out.print("- ");
                        String nombre = leer.next();
                        System.out.print("- ");
                        id = leer.next();
                        boolean alta = true;
                        es.crear(nombre, id, alta);
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
                        System.out.println("Ingrese el nombre de la editorial a eliminar");
                        System.out.print("- ");
                        nombre = leer.next();
                        es.eliminar(nombre);
                        break;
                    case 11:
                        System.out.println("Ingrese el nombre y el id");
                        System.out.print("- ");
                        nombre = leer.next();
                        System.out.print("- ");
                        id = leer.next();
                        alta = true;
                        as.crear(nombre, id,alta);
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
                        System.out.println("Ingrese el nombre del autor a eliminar");
                        System.out.print("- ");
                        nombre = leer.next();
                        as.eliminar(nombre);
                        break;
                    case 14:
                        ls.listar();
                    default:

                        System.out.println("GRACIAS POR CONFIAR EN NOSOTROS <3");
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }

    }

}
