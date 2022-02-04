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

    public void crear(String nombre, String id) {

        try {
            Editorial a = new Editorial();

            a.setId(id);
            a.setNombre(nombre);

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

    public void eliminar(String nombre, String id) {

        try {
            Editorial a = new Editorial();

            a.setId(id);
            a.setNombre(nombre);

            dao.eliminar(a);
        } catch (Exception e) {
            throw e;
        }
    }
}
