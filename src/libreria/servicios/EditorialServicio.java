
package libreria.servicios;

import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;


public class EditorialServicio {
    
    private final EditorialDAO dao;

    public EditorialServicio() {
        dao = new EditorialDAO();
    }
    
    public void crear(String nombre, String id) {
        
        Editorial a = new Editorial();
        
        a.setId(id);
        a.setNombre(nombre);
        
        dao.guardar(a);
    }
}
