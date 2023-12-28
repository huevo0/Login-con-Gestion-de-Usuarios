package capas.login.logica;

import capas.login.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {

    ControladoraPersistencia controlPersis;

    public Controladora() {
        controlPersis  = new ControladoraPersistencia();
    }
    
    public Usuario validarUsuario(String usuario, String contrasenia) {
        //String mensaje="";
        Usuario usr = null;
        List<Usuario> listaUsuario = controlPersis.traerUsuarios();
        for (Usuario usu : listaUsuario) {
            if(usu.getNombreUsuario().equalsIgnoreCase(usuario)){
                if(usu.getContrasenia().equals(contrasenia)){
                    usr=usu;
                    return usr;
                }
                else { 
                    usr = null;
                    return usr;
                }
            }
            else { 
               usr = null;
            }
        }
        return usr;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contrasenia, String rolRecibido) {
          Usuario usu = new Usuario();
          usu.setNombreUsuario(usuario);
          usu.setContrasenia(contrasenia);
          
          Rol rolEncontrado = new Rol();
          rolEncontrado = this.traerRol(rolRecibido);
          if (rolEncontrado!=null){
              usu.setUnRol(rolEncontrado);
          }
          
          controlPersis.crearUsuario(usu);
          
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol>Roles = controlPersis.traerRoles();
        for (Rol r : Roles) {
            if(r.getNombreRol().equalsIgnoreCase(rolRecibido)){
                return r;
            }
            
        }
        return null;
    }

    public void borrarUsuario(int idUsuario) {
        controlPersis.borrarUsuario(idUsuario);
    }

    public Usuario traerUsuario(int idUsuario) {
        return controlPersis.traerUsuario(idUsuario);
        
    }

    public void editarUsuario(Usuario usuario, String usu, String contrasenia, String rolRecibido) {

        usuario.setNombreUsuario(usu);
        usuario.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
          rolEncontrado = this.traerRol(rolRecibido);
          if (rolEncontrado!=null){
              usuario.setUnRol(rolEncontrado);
          }
          
          controlPersis.editarUsuario(usuario);


    }

    
}
