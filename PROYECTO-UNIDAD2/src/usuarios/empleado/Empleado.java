package usuarios.empleado;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;
public class Empleado extends Usuario {

    public String curp;

    public Empleado(String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String curp, String contrasenia) {
        super(id, nombre, apellido, direccion, telefono, fechaNacimiento, contrasenia, Rol.EMPLEADO);
        this.curp = curp;
    }

    public String getCurp() {
        return curp;
    }

    public void mostrarDatos() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Direccion: " + getDireccion());
        System.out.println("Telefono: " + getTelefono());
        System.out.println("Fecha de nacimiento: " + getFechaNacimiento());
        System.out.println("Curp: " + getCurp());
        System.out.println("Contrasenia: " + getContrasenia());
    }
}
