package usuarios.empleado;

import cine.ValidadorCine;
import funcion.Funcion;
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

    public String curp;
    private Scanner sc = new Scanner(System.in);

    public Empleado(String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String curp, String nuevacontrasenia, Rol rol,  Cine cine) {
        super(id, nombre, apellido, direccion, telefono, fechaNacimiento, nuevacontrasenia, Rol.EMPLEADO, cine);
        this.curp = curp;
    }

    public String getCurp() {
        return curp;
    }

    public String mostrarDatosEmpleado() {
        return String.format("id: %s, Nombre: %s, Apellido: %s, Direccion: %s, Telefono: %s, Fecha de Nacimiento: %s, Cuerp: %s",id,nombre, apellido, direccion,
                telefono, fechaNacimiento, curp);
    }

    public void agregarProductoDulce(){

        String ID = cine.generarIdDulce();
        System.out.println("INGRESA LA CATEGORIA DEL PRODUCTO A AGREGAR: ");
        String id = sc.next();
        System.out.println("INGRESA EL NOMBRE DEL PRODUCTO QUE VAS A INGRESAR: ");
        String nombre = sc.next();

        int opciontamaño =0;
        double precio =0;
        String tamaño = "";
        while(opciontamaño < 1 || opciontamaño > 4){
            System.out.println("EL PRODUCTO A INGRESAR TIENE TAMAÑO");
            System.out.println("1.- CHICO");
            System.out.println("2.- MEDIANO");
            System.out.println("3.- GRANDE");
            System.out.println("4.- NO TIENE TAMAÑO");
            System.out.println("SELECCIONA UNA OPCION");
            opciontamaño = sc.nextInt();

            switch (opciontamaño){
                case 1:
                    System.out.println("INGRESA EL PRECIO DEL PRODUCTO CHICO: ");
                    precio = sc.nextDouble();
                    tamaño = "CHICO";
                    break;
                case 2:
                    System.out.println("INGRESA EL PRECIO DEL PRODUCTO MEDIANO: ");
                    precio = sc.nextDouble();
                    tamaño = "MEDIANO";
                    break;
                case 3:

                    System.out.println("INGRESA EL PRECIO DEL PRODUCTO GRANDE: ");
                    precio = sc.nextDouble();
                    tamaño = "GRANDE";
                    break;
                case 4:
                    System.out.println("INGRESA EL PRECIO DEL PRODUCTO:");
                    precio = sc.nextDouble();
                    tamaño = "";
                    break;
            }
        }
        Producto producto = new Producto(ID,id, nombre, tamaño, precio);
        cine.registrarDulce(producto);
        cine.registrarProducto(producto);
        System.out.println("PRODUCTO REGISTRADO EXITOSAMENTE.");
    }

    public void agregarProductoSalado(){
        String ID = cine.generarIdProductoSalado();
        System.out.println("INGRESA LA CATEGORIA DEL PRODUCTO A AGREGAR: ");
        String ids = sc.next();
        System.out.println("INGRESA EL NOMBRE DEL PRODUCTO QUE VAS A INGRESAR: ");
        String nombres = sc.next();

        int opciontamaños =0;
        double precios =0;
        String tamaños = "";
        while(opciontamaños < 1 || opciontamaños > 4){
            System.out.println("EL PRODUCTO A INGRESAR TIENE TAMAÑO");
            System.out.println("1.- CHICO");
            System.out.println("2.- MEDIANO");
            System.out.println("3.- GRANDE");
            System.out.println("4.- NO TIENE TAMAÑO");
            System.out.println("SELECCIONA UNA OPCION");
            opciontamaños = sc.nextInt();

            switch (opciontamaños){
                case 1:
                    System.out.println("INGRESA EL PRECIO DEL PRODUCTO CHICO: ");
                    precios = sc.nextDouble();
                    tamaños = "CHICO";
                    break;
                case 2:
                    System.out.println("INGRESA EL PRECIO DEL PRODUCTO MEDIANO: ");
                    precios = sc.nextDouble();
                    tamaños = "MEDIANO";
                    break;
                case 3:

                    System.out.println("INGRESA EL PRECIO DEL PRODUCTO GRANDE: ");
                    precios = sc.nextDouble();
                    tamaños = "GRANDE";
                    break;
                case 4:
                    System.out.println("INGRESA EL PRECIO DEL PRODUCTO:");
                    precios = sc.nextDouble();
                    tamaños = "";
                    break;
            }
        }
        Producto producto = new Producto(ID,ids, nombres, tamaños, precios);
        cine.registrarSalado(producto);
        cine.registrarProducto(producto);
        System.out.println("PRODUCTO REGISTRADO EXITOSAMENTE.");
    }

    public void mostrarProdDulces(){
        int iterador = 1;
        System.out.println("--PRODUCTOS DULCES--");
        for(Producto producto: this.cine.listaDulce){
            System.out.println("Este es el producto: "+iterador);
            System.out.println(producto.mostrarProductoEmpleado());
            iterador++;
        }
    }

    public void mostrarProductoSalado(){
        int iterador = 1;
        System.out.println("--PRODUCTOS SALDO--");
        for(Producto producto: this.cine.listaSalado){
            System.out.println("Este es el producto: "+iterador);
            System.out.println(producto.mostrarProductoEmpleado());
            iterador++;
        }
    }

    public void eliminarProdDulce(String idProducto){
        for (Producto producto : this.cine.listaDulce){
            if (producto.getID().equals(idProducto)){
                this.cine.listaDulce.remove(producto);
                return;
            }
        }
    }

    public void eliminarProdSalado(String idProducto){
        for (Producto producto : this.cine.listaSalado){
            if (producto.getID().equals(idProducto)){
                this.cine.listaSalado.remove(producto);
                return;
            }
        }
    }

    public Producto obtenerProdporId(String idProducto){
        for (Producto producto : this.cine.listaProductos){
            if (producto.getID().equals(idProducto)){
                return producto;
            }
        }
        return null;
    }


    public void eliminarProductos(){
        if (cine.listaProductos.size() == 0){
            System.out.println("NO HAY PRODUCTOS REGISTRADOS");
            return;
        }
        System.out.println("INGRESA EL ID DEL PRODUCTO A ELIMINAR:");
        String idProducto = sc.next();

        Producto producto = obtenerProdporId(idProducto);
        if (producto == null){
            System.out.println("No existe un producto con el ID: " + idProducto);
            return;
        }
        this.eliminarProdDulce(idProducto);
        this.eliminarProdSalado(idProducto);
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

    public void mostrarPeliculas() {
        if (cine.listaPeliculas.size() == 0) {
            System.out.println("NO HAY PELICULAS REGISTRADAS");
        }

        for (Pelicula pelicula : this.cine.listaPeliculas) {
            System.out.println(pelicula.mostrarDatos());
        }
    }

    public void eliminarPelicula(){
        if (cine.listaPeliculas.size() == 0){
            System.out.println("NO HAY PELICULAS REGISTRADAS");
            return;
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
            return;
        }

        System.out.println("INGRESA EL ID DE LA SALA: ");
        String idSala = sc.nextLine();

        if (!cine.existeSala(idSala)){
            System.out.println("NO EXISTE TAL SALA");
            return;
        }

        System.out.println("INGRESA LA HORA DE PROYECCIÓN (HH:MM): ");
        String hora = sc.nextLine();
        LocalTime horaFuncion = LocalTime.parse(hora);
        Duration duracionPelicula = cine.obtenerPeliculaPorNombre(nombrePelicula).getDuracion();
        Duration duracionTotal = duracionPelicula.plusMinutes(20);
        boolean chocanHoras = false;

        Pelicula pelicula = cine.obtenerPeliculaPorNombre(nombrePelicula);

        for (Funcion funcion : pelicula.listaFunciones) {
            LocalTime horaInicioExistente = funcion.getHoraProyeccion();
            Duration duracionExistente = pelicula.getDuracion();
            Duration duracionTotalExistente = duracionExistente.plusMinutes(20);
            LocalTime horaTerminoExistente = horaInicioExistente.plus(duracionTotalExistente);

            if ((horaFuncion.equals(horaInicioExistente) || (horaFuncion.isAfter(horaInicioExistente)
                    && horaFuncion.isBefore(horaTerminoExistente)) || (horaFuncion.plus(duracionTotal).isAfter(horaInicioExistente)
                    && horaFuncion.plus(duracionTotal).isBefore(horaTerminoExistente)))) {
                System.out.println("YA HAY UNA FUNCIÓN PARA ESA HORA.");
                System.out.println("LA HORA PROXIMA DISPONIBE ES DE LAS: " + horaTerminoExistente);
                chocanHoras = true;
                break;
            }
        }

        if (!chocanHoras) {
            Sala sala = cine.obtenerSalaPorId(idSala);
            String idFuncion = pelicula.generarIdFuncion();
            Funcion funcion = new Funcion(idFuncion, sala, horaFuncion);
            pelicula.listaFunciones.add(funcion);
            System.out.println("FUNCIÓN AGREGADA EXITOSAMENTE");
        }

    }

    public void eliminarFuncion(String tituloPeli){
        //MOSTRAR FUNCIONES
        //pelicula.mostrarFunciones(tituloPeli);

        System.out.println("INGRESA EL ID DE LA FUNCION A ELIMINAR: ");
        String idFuncion = sc.nextLine();

        for (Pelicula pelicula : this.cine.listaPeliculas) {
            if (pelicula.getTitulo().equals(tituloPeli)) {
                for (Funcion funcion: pelicula.listaFunciones){
                    if (funcion.getId().equals(idFuncion)) {
                        pelicula.listaFunciones.remove(funcion);
                        System.out.println(pelicula.listaFunciones.size());//eliminar despues
                        return;
                    }
                }
            }
        }
        System.out.println("NO EXISTE ESA FUNCION.");
    }

    public void mostratrarFunciones(String tituloPeli){

        Pelicula peliculaInteres = cine.obtenerPeliculaPorNombre(tituloPeli);
        for (Funcion funcion : peliculaInteres.listaFunciones) {
            System.out.println(funcion.mostrarFuncion());
        }
    }


}
