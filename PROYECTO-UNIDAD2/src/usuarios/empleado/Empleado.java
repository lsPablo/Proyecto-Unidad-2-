package usuarios.empleado;

import peliculas.Pelicula;
import producto.Producto;
import usuarios.Usuario;
import usuarios.utils.Rol;
import cine.Cine;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Scanner;


public class Empleado extends Usuario {
    Scanner sc = new Scanner(System.in);
    public Cine cine = new Cine();
    public String curp;

    public Empleado(String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String curp, String nuevacontrasenia) {
        super(id, nombre, apellido, direccion, telefono, fechaNacimiento, nuevacontrasenia, Rol.EMPLEADO);
        this.curp = curp;
    }

    public String getCurp() {
        return curp;
    }

    public String mostrarDatosEmpleado() {
        String datos = String.format ("id: %s, Nombre: %s, Apellido: %s, Direccion: %s, Telefono: %s, " +
                "Fecha de Nacimiento: %s, CURP: %s", id, nombre,apellido,direccion,telefono,fechaNacimiento,curp);
        return datos;
    }

    public void agregarPelicula(){
        String idPelicula = cine.generarIdPelicula();
        System.out.println("--AGREGAR PELÍCULA--");
        System.out.println("INGRESA EL NOMBRE DE LA PELICULA: ");
        String nombrePelicula = sc.nextLine();
        System.out.println("INGRESA EL GENERO: ");
        String generoPelicula = sc.nextLine();
        System.out.println("INGRESA SU CLASIFICACIÓN (A|B|C|): ");
        char clasificacionPelicula = sc.next().charAt(0);

        System.out.println("INGRESA LOS MINUTOS DE DURACIÓN: ");
        int minutosPelicula = sc.nextInt();
        sc.nextLine();
        Duration duracion = Duration.ofMinutes(minutosPelicula);
        System.out.println("INGRESA UNA SINOPSIS: ");
        String sinopsisPelicula = sc.nextLine();

        Pelicula pelicula = new Pelicula(idPelicula, nombrePelicula ,generoPelicula,clasificacionPelicula,duracion,sinopsisPelicula);
        cine.registrarPelicula(pelicula);
    }

    public void mostrarPeliculas(){
        if (cine.listaPeliculas.size() == 0){
            System.out.println("NO HAY PELICULAS REGISTRADAS");
        }

        for (Pelicula pelicula : this.cine.listaPeliculas){
            System.out.println(pelicula.mostrarDatos());
        }
    }

    public void eliminarPelicula(){
        if (cine.listaPeliculas.size() == 0){
            System.out.println("NO HAY PELICULAS REGISTRADAS");
        }

        System.out.println("INGRESA EL NOMBRE DE LA PELICULA A ELIMINAR:");
        String nombrePelicula = sc.nextLine();

        for (Pelicula pelicula : this.cine.listaPeliculas){
            if (pelicula.getTitulo().equals(nombrePelicula)){
                int posicion = cine.listaPeliculas.indexOf(pelicula);
                cine.listaPeliculas.remove(posicion);
                break;
            }
        }
        System.out.println("NO HAY PELICULAS REGISTRADAS CON ESE NOMBRE.");
    }
    public void eliminarProductos(){
        if (cine.listaSalado.size() == 0 && cine.listaDulce.size() == 0){
            System.out.println("NO HAY PRODUCTOS REGISTRADOS");
        }
        System.out.println("INGRESA EL ID DEL PRODUCTO A ELIMINAR");
        String idProducto = sc.nextLine();
        for(Producto producto : this.cine.listaProductos){
            int posicion = cine.listaProductos.indexOf(producto);
            System.out.println();
        }
    }
}
