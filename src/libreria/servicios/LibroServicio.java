
package libreria.servicios;

import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;


public class LibroServicio {
    
    private final LibroDAO dao;

    public LibroServicio() {
        dao = new LibroDAO();
    }
    
    public void crear(String titulo, String isbn, Integer anio, Autor autor, Editorial edit) {
        
        Libro a = new Libro();
        
        a.setIsbn(isbn);
        a.setTitulo(titulo);
        a.setAnio(anio);
        a.setAutor(autor);
        a.setEditorial(edit);
        
        dao.guardar(a);
    }
}
