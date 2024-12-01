package itson.mx.moxxdesignsdto;

import java.util.List;

/**
 *
 * @author olive
 */
public class UsuarioDTO {

    private String email;
    private String password;
    private String apellido ;
    private String nombre ;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String password, String apellido, String nombre) {
        this.email = email;
        this.password = password;
        this.apellido = apellido ;
        this.nombre = nombre ;
    }
    
    public UsuarioDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
