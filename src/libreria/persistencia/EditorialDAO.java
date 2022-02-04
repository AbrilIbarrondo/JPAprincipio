package libreria.persistencia;

import libreria.entidades.Editorial;

public final class EditorialDAO extends DAO {

    public void guardar(Editorial objeto) {

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

    public Editorial editar(Editorial objeto) {

        try {
            conectar();
            em.getTransaction().begin();
            Editorial a = em.merge(objeto);
            em.getTransaction().commit();
            desconectar();

            return a;
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Editorial objeto) {

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
}
