package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

public final class AutorDAO extends DAO {

    public void guardar(Autor objeto) {

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

    public Autor editar(Autor objeto) {

        try {
            conectar();
            em.getTransaction().begin();
            Autor a = em.merge(objeto);
            em.getTransaction().commit();
            desconectar();

            return a;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Autor objeto) {

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

    public Autor buscarPorID(String id) {

        try {
            return em.find(Autor.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    public Autor buscarID2(String id) {

        try {
            Autor a = (Autor) em.createQuery("SELECT a FROM Autor a WHERE A.id LIKE :id")
                    .setParameter("id", id)
                    .getSingleResult();

            return a;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Autor> listarTodo() {

        try {
            return em.createQuery("SELECT a FROM Autor a").getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Autor> listarPorNombre(String nombre) {

        try {
            return (List<Autor>) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }
    }
}
