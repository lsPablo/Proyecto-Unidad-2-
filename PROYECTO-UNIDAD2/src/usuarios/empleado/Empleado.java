package usuarios.empleado;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;
public class Empleado extends Usuario {

    public String curp;

    public Empleado(String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String curp, String nuevacontrasenia) {
        super(id, nombre, apellido, direccion, telefono, fechaNacimiento, nuevacontrasenia, Rol.EMPLEADO);
        this.curp = curp;
    }

    public String getCurp() {
        return curp;
    }

    public String mostrarDatosEmpleado() {
        String datos = String.format ("id: %d, Nombre: %s, Apellido: %s, Direccion: %s, Telefono: %s, " +
                "Fecha de Nacimiento: %s, CURP: %s", id, nombre,apellido,direccion,telefono,fechaNacimiento,curp);
        return datos;
    }
}
