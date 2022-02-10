package libreria.servicios;

import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicio {

    private final AutorDAO dao;

    public AutorServicio() {
        try {
            dao = new AutorDAO();
        } catch (Exception e) {
            throw e;
        }
    }

    public void crear(String nombre, String id, Boolean alta) {

        try {
            Autor a = new Autor();

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
            Autor a = new Autor();

            a.setId(id);
            a.setNombre(nombre);

            dao.editar(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(String nombre) {

        try {
            Autor a = new Autor();

            a.setNombre(nombre);

            dao.eliminar(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public Autor buscarPorID(String id) {

        try {
            Autor a = new Autor();

            a.setId(id);

            return dao.buscarPorID(id);
            
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void listar() {

        try {
            dao.listarTodo();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarNombre(String nombre) {

        try {
            Autor a = new Autor();

            a.setNombre(nombre);

            dao.listarPorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
}
