
package libreria.servicios;

import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;


public class AutorServicio {
    
    private final AutorDAO dao;

    public AutorServicio() {
        dao = new AutorDAO();
    }
    
    public void crear(String nombre, String id) {
        
        Autor a = new Autor();
        
        a.setId(id);
        a.setNombre(nombre);
        
        dao.guardar(a);
    }
    
}
