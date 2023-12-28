package capas.login.persistencia;

import capas.login.logica.Rol;
import capas.login.logica.Usuario;
import capas.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
        
    UsuarioJpaController usuariojpa = new UsuarioJpaController();
    RolJpaController roljpa = new RolJpaController();
    
    public List<Usuario> traerUsuarios() {
        
        List<Usuario> usuarios = usuariojpa.findUsuarioEntities();
        return usuarios;
    }

    public List<Rol> traerRoles() {
        return roljpa.findRolEntities();
    }    

    public void crearUsuario(Usuario usu) {
        usuariojpa.create(usu);
    }

    public void borrarUsuario(int idUsuario) {
        try {
            usuariojpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int idUsuario) {
        return usuariojpa.findUsuario(idUsuario);
    }

    public void editarUsuario(Usuario usuario) {

        try {
            usuariojpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
