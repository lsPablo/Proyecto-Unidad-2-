package usuarios.cliente;

import cine.Cine;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {

    public Cliente (String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String contrasenia, Cine cine) {
        super(id, nombre, apellido, direccion, telefono, fechaNacimiento, contrasenia, Rol.CLIENTE, cine);
    }

    public String mostrarDatosCliente() {
        String datos = String.format("Id: %s, Nombre: %s, Apellido: %s, Direccion: %s, Telefono: %s, Fecha de Nacimiento: %s",
                id, nombre, apellido, direccion, telefono, fechaNacimiento);
        return datos;
    }

}
