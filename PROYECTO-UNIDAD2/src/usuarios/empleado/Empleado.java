package usuarios.empleado;

import cartelera.Cartelera;
import peliculas.Pelicula;
import producto.Producto;
import salas.Sala;
import usuarios.Usuario;
import usuarios.utils.Rol;
import cine.Cine;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
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

    public void verSalas(){
        System.out.println("---SALAS---");
        cine.Salas();
        for (Sala sala : this.cine.listaSalas){
            System.out.println(sala.getId());
            sala.mostrarDistribucion();
        }
    }

    public void agregarFunciones(){
            System.out.println("INGRESA EL NOMBRE DE LA PELICULA A PROYECTAR: ");
            String nombrePelicula = sc.nextLine();
            if (!cine.existePelícula(nombrePelicula)){
                System.out.println("NO EXISTE ESA PELICULA");
            }else{
                System.out.println("INGRESA EL ID DE LA SALA: ");
                String idSala = sc.nextLine();
                if (!cine.existeSala(idSala)){
                    System.out.println("NO EXISTE TAL SALA");
                }else {
                    System.out.println("INGRESA LA HORA DE PROYECCIÓN (HH:MM): ");
                    String hora = sc.nextLine();
                    LocalTime horaFuncion = LocalTime.parse(hora);
                    Duration duracionPelicula = cine.obtenerPeliculaPorNombre(nombrePelicula).getDuracion();
                    Duration duracionTotal = duracionPelicula.plusMinutes(20);
                    boolean conflictoEnHoras = false;

                    for (Cartelera cartelera : cine.listaFunciones) {
                        LocalTime horaInicioExistente = cartelera.getHoraProyeccion();
                        Duration duracionExistente = cartelera.getPelicula().getDuracion();
                        Duration duracionTotalExistente = duracionExistente.plusMinutes(20);
                        LocalTime horaTerminoExistente = horaInicioExistente.plus(duracionTotalExistente);

                        if ((horaFuncion.equals(horaInicioExistente) || (horaFuncion.isAfter(horaInicioExistente) && horaFuncion.isBefore(horaTerminoExistente)) || (horaFuncion.plus(duracionTotal).isAfter(horaInicioExistente) && horaFuncion.plus(duracionTotal).isBefore(horaTerminoExistente)))) {

                            System.out.println("YA HAY UNA FUNCIÓN PARA ESA HORA.");
                            conflictoEnHoras = true;
                            break;
                        }
                    }

                    if (!conflictoEnHoras) {
                        Pelicula pelicula = cine.obtenerPeliculaPorNombre(nombrePelicula);
                        Sala sala = cine.obtenerSalaPorId(idSala);
                        Cartelera cartelera = new Cartelera(pelicula, sala, horaFuncion);
                        cine.listaFunciones.add(cartelera);
                        System.out.println("FUNCIÓN AGREGADA EXITOSAMENTE");
                    }
                }
            }
    }

    public void mostrarFunciones(){
        if (cine.listaFunciones.size() == 0){
            System.out.println("NO HAY FUNCIONES REGISTRADAS");
        }

        for (Cartelera cartelera : this.cine.listaFunciones){
        //en proceso
        }
    }

    public void eliminarFunciones(){

    }

    public void eliminarProductos(){
        if (cine.listaSalado.size() == 0 && cine.listaDulce.size() == 0){
            System.out.println("NO HAY PRODUCTOS REGISTRADOS");
        }
        System.out.println("INGRESA EL ID DEL PRODUCTO A ELIMINAR");
        String idProducto = sc.nextLine();
        for(Producto producto : this.cine.listaSalado){
            int posicion = cine.listaSalado.indexOf(producto);
            System.out.println();
        }
    }
}
