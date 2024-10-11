package usuarios;

import java.time.LocalDate;

public class Usuario {


    public String id;
    public String nombre;
    public String apellido;
    public String direccion;
    public String telefono;
    public LocalDate fechaNacimiento;
    public String contrasenia;

    public Usuario(String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
    }
}
