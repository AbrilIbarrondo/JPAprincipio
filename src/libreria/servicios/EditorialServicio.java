package libreria.servicios;

import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicio {

    private final EditorialDAO dao;

    public EditorialServicio() {
        try {
            dao = new EditorialDAO();
        } catch (Exception e) {
            throw e;
        }
    }

    public void crear(String nombre, String id, Boolean alta) {

        try {
            Editorial a = new Editorial();

            a.setId(id);
            a.setNombre(nombre);
            a.setAlta(alta);
            dao.guardar(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editar(String nombre, String id) {
        try {

            Editorial a = new Editorial();

            a.setId(id);
            a.setNombre(nombre);

            dao.editar(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(String nombre) {

        try {
            Editorial a = new Editorial();

            a.setNombre(nombre);

            dao.eliminar(a);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Editorial buscarPorID(String id) {

        try {
            Editorial a = new Editorial();

            a.setId(id);

           return  dao.buscarPorID(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
