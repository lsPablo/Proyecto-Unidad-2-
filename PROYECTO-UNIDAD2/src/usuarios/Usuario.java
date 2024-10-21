package usuarios;

import cine.Cine;
import usuarios.utils.Rol;
import java.time.LocalDate;

public class Usuario {

    public String id;
    public String nombre;
    public String apellido;
    public String direccion;
    public String telefono;
    public LocalDate fechaNacimiento;
    public String contrasenia;
    public Rol rol;
    protected Cine cine;

    public Usuario(String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String contrasenia, Rol rol, Cine cine) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
        this.rol=rol;
        this.cine= cine;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

}