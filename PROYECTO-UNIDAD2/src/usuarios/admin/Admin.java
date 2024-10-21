package usuarios.admin;

import usuarios.Usuario;
import usuarios.utils.Rol;
import cine.Cine;
import java.time.LocalDate;

public class Admin extends Usuario {
    public Admin(String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String contrasenia, Rol rol, Cine cine ) {
        super(id, nombre, apellido,direccion, telefono, fechaNacimiento, contrasenia, Rol.ADMINISTRADOR, cine);
    }

}
