package usuarios.admin;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Admin extends Usuario {

    public Admin(String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String contrasenia, Rol rol ) {
        super(id, nombre, apellido,direccion, telefono, fechaNacimiento, contrasenia, Rol.ADMINISTRADOR);

    }
}
