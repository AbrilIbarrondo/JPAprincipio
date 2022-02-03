
package libreria.persistencia;

import libreria.entidades.Editorial;


public final class EditorialDAO extends DAO {
    
     public void guardar(Editorial objeto) {
        
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Editorial editar(Editorial objeto) {
        
        conectar();
        em.getTransaction().begin();
        Editorial a = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        
        return a;
    }
    
    public void eliminar(Editorial objeto) {
        
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}
