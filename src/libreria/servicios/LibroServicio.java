package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

public class LibroServicio {

    private final LibroDAO dao;

    public LibroServicio() {
        try {
            dao = new LibroDAO();
        } catch (Exception e) {
            throw e;
        }
    }

    public void crear(String titulo, String isbn, Integer anio, Integer ejemplares,Autor autor, Editorial edit) {

        try {
            Libro a = new Libro();

            a.setIsbn(isbn);
            a.setTitulo(titulo);
            a.setAnio(anio);
            a.setAutor(autor);
            a.setEditorial(edit);
            a.setEjemplares(ejemplares);
            a.setAlta(true);
            dao.guardar(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editar(String titulo, String isbn) {

        try {
            Libro a = new Libro();

            a.setIsbn(isbn);
            a.setTitulo(titulo);

            dao.editar(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(String titulo) {

        try {
            Libro a = new Libro();

            a.setTitulo(titulo);

            dao.eliminar(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarPorISBN(String isbn) {

        try {
            Libro a = new Libro();

            a.setIsbn(isbn);

            dao.buscarPorISBN(isbn);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Libro> listarTitulo(String titulo) {

        try {
            Libro a = new Libro();

            a.setTitulo(titulo);

            return dao.listarPorTitulo(titulo);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarAutor(Autor autor) {

        try {
            Libro a = new Libro();

            a.setAutor(autor);

            dao.listarPorAutor(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarEditorial(Editorial edit) {

        try {
            Libro a = new Libro();

            a.setEditorial(edit);

            dao.listarPorEditorial(edit);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar() {

        try {

            List<Libro> listar = dao.listar();
            
            for (Libro libro : listar) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
