package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

public final class AutorDAO extends DAO {

    public void guardar(Autor objeto) {

        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    public Autor editar(Autor objeto) {

        conectar();
        em.getTransaction().begin();
        Autor a = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();

        return a;
    }

    public void eliminar(Autor objeto) {

        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    public Autor buscarPorID(String id) {

        return em.find(Autor.class, id);
    }

    public Autor buscarID2(String id) {

        Autor a = (Autor) em.createQuery("SELECT a FROM Autor a WHERE A.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();

        return a;
    }

    public List<Autor> listarTodo() {

        return em.createQuery("SELECT a FROM Autor a").getResultList();
    }
    
    public List<Autor> listarPorNombre(String nombre) {
        
        return (List<Autor>) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
    }
}
