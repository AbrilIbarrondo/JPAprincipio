package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public final class LibroDAO extends DAO {

    public void guardar(Libro objeto) {

        try {

            conectar();
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            desconectar();

        } catch (Exception e) {
            throw e;
        }
    }

    public Libro editar(Libro objeto) {

        try {
            conectar();
            em.getTransaction().begin();
            Libro a = em.merge(objeto);
            em.getTransaction().commit();
            desconectar();

            return a;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Libro objeto) {

        try {
            conectar();
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }

    public Libro buscarPorISBN(String isbn) {

        try {
            return em.find(Libro.class, isbn);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Libro> listarPorTitulo(String titulo) {

        try {
            return (List<Libro>) em.createQuery("SELECT a FROM Libro a WHERE a.titulo LIKE :titulo")
                    .setParameter("titulo", "%" + titulo + "%")
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Libro> listarPorAutor(Autor autor) {

        try {
            return (List<Libro>) em.createQuery("SELECT a FROM Libro a WHERE a.autor LIKE :autor")
                    .setParameter("autor", "%" + autor + "%")
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Libro> listarPorEditorial(Editorial edit) {

        try {
            return (List<Libro>) em.createQuery("SELECT a FROM Libro a WHERE a.edit LIKE :edit")
                    .setParameter("edit", "%" + edit + "%")
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

}
