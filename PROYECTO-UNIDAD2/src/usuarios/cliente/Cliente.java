package usuarios.cliente;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {

    public Cliente (String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String contrasenia) {
        super(id, nombre, apellido, direccion, telefono, fechaNacimiento, contrasenia, Rol.CLIENTE);
    }

    public void mostrarDatos() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Direccion: " + getDireccion());
        System.out.println("Telefono: " + getTelefono());
        System.out.println("Fecha Nacimiento: " + getFechaNacimiento());
        System.out.println("Contrasenia: " + getContrasenia());
    }

}
