
package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;


public final class LibroDAO extends DAO {
    
     public void guardar(Libro objeto) {
        
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Libro editar(Libro objeto) {
        
        conectar();
        em.getTransaction().begin();
        Libro a = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        
        return a;
    }
    
    public void eliminar(Libro objeto) {
        
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Libro buscarPorISBN(String isbn) {

        return em.find(Libro.class, isbn);
    }
    
    public List<Libro> listarPorTitulo(String titulo) {
        
        return (List<Libro>) em.createQuery("SELECT a FROM Libro a WHERE a.titulo LIKE :titulo")
                .setParameter("titulo", "%" + titulo + "%")
                .getResultList();
    }
    
    public List<Libro> listarPorAutor(Autor autor) {
        
        return (List<Libro>) em.createQuery("SELECT a FROM Libro a WHERE a.autor LIKE :autor")
                .setParameter("autor", "%" + autor + "%")
                .getResultList();
    }
    
    public List<Libro> listarPorAutor(Editorial edit) {
        
        return (List<Libro>) em.createQuery("SELECT a FROM Libro a WHERE a.adit LIKE :edit")
                .setParameter("edit", "%" + edit + "%")
                .getResultList();
    }
    
    
}
