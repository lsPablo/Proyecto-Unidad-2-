package cine;

import cartelera.Cartelera;
import funcion.Funcion;
import peliculas.Pelicula;
import producto.Producto;
import salas.Sala;
import usuarios.Usuario;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;
import usuarios.empleado.Empleado;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Cine {
    Scanner sc = new Scanner(System.in);

    public ArrayList<Cliente>listaClientes=new ArrayList<>();
    public ArrayList<Usuario>listaUsuarios =new ArrayList<>();
    public ArrayList<Empleado>listaEmpleados =new ArrayList<>();
    public ArrayList<Admin>listaAdmin =new ArrayList<>();
    public ArrayList<Producto> listaProductos =new ArrayList<>();
    public ArrayList<Producto>listaSalado = new ArrayList<>();
    public ArrayList<Producto>listaDulce =new ArrayList<>();
    public ArrayList<Producto>listaCompras =new ArrayList<>();
    public ArrayList<Pelicula>listaPeliculas =new ArrayList<>();
    public ArrayList<Sala>listaSalas =new ArrayList<>();
    public Cartelera cartelera = new Cartelera();

    public Cine(){
        LocalDate fechaNcimiento=LocalDate.of(1990,11,05);
        Admin admin =new Admin("A", "Josue","Marquez","Calle #5 Mayo-#127", "4321564686",fechaNcimiento,"1", Rol.ADMINISTRADOR, this);
        this.listaUsuarios.add(admin);
        this.listaAdmin.add(admin);
        generarSalas();

    }

    public void generarSalas(){
        for (int i = 0; i < 11; i++) {
            String idSala = generarIdSala();
            Sala sala = new Sala(idSala);
            sala.llenarDistribucion();
            listaSalas.add(sala);
        }
    }

    public void registrarCliente(Cliente cliente){
        listaClientes.add(cliente);
        listaUsuarios.add(cliente);
    }

    public void registrarEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
        listaUsuarios.add(empleado);
    }

    public void registrarAdmin(Admin admin){
        listaAdmin.add(admin);
    }

    public void registrarProducto(Producto producto){
        listaProductos.add(producto);
    }

    public void registrarSalado(Producto producto){
        listaSalado.add(producto);
    }

    public void registrarDulce(Producto producto){
        listaDulce.add(producto);
    }

    public void registrarCompra(Producto producto){
        listaCompras.add(producto);
    }

    public Usuario validarInicioSesion(String idUsuario, String contrasenia){
        for(Usuario usuario: this.listaUsuarios){
            if(usuario.getId().equals(idUsuario) && usuario.getContrasenia().equals(contrasenia)){
                return usuario;
            }
        }
        return null;
    }

    public void mostrarCliente(){
        int iterador = 1;
        System.out.println("--Datos del Cliente--");
        for(Cliente cliente: this.listaClientes){
            System.out.println("Este es el cliente"+iterador);
            System.out.println(cliente.mostrarDatosCliente());
        }
    }

    public void mostrarProdDulces(){
        int iterador = 1;
        System.out.println("--PRODUCTOS DULCES--");
        for(Producto producto: this.listaDulce){
            System.out.println("Este es el producto: "+iterador);
            System.out.println(producto.mostrarProductoEmpleado());
        }
    }

    public void mostrarProductoSalado(){
        int iterador = 1;
        System.out.println("--PRODUCTOS SALDO--");
        for(Producto producto: this.listaSalado){
            System.out.println("Este es el producto: "+iterador);
            System.out.println(producto.mostrarProductoEmpleado());
        }
    }

    public void mostrarEmpleado(){
        int iterador = 1;
        System.out.println("--Datos del Empleado--");
        for(Empleado empleado: this.listaEmpleados){
            System.out.println("Este es el empleado" +iterador);
            System.out.println(empleado.mostrarDatosEmpleado());
        }
    }

    public void registrarNuevoEmpleado(){
        System.out.println("INGRESA TU NOMBRE COMPLETO: ");
        String nombre = sc.next();

        System.out.println("INGRESA TU APELLIDO: ");
        String apellido = sc.next();
        System.out.println("INGRESA TU NOMBRE DE USUARIO: ");
        String id = sc.next();
        System.out.println("INGRESA TU CONTRASEÑA:");
        String nuevaContrasenia = sc.next();
        System.out.println("CONFIRMA TU CONTRASEÑA:");
        String confirmaContrasenia = sc.next();

        while (!nuevaContrasenia.equals(confirmaContrasenia)) {
            System.out.println("La contraseña no es la misma, chavo.");
            System.out.println("Confirma la contraseña:");
            confirmaContrasenia = sc.next();
        }

        System.out.println("INGRESA TU AÑO DE NACIMIENTO (YYYY): ");
        int anio = sc.nextInt();
        System.out.println("INGRESA TU MES DE NACIMIENTO (MM): ");
        int mes = sc.nextInt();
        System.out.println("INGRESA TU FECHA DE NACIMIENTO (DD): ");
        int dia = sc.nextInt();
        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);

        System.out.println("INGRESA TU DIRECCIÓN:");
        String direccion = sc.next();
        System.out.println("INGRESA TU TELÉFONO: ");
        String telefono = sc.next();
        System.out.println("INGRESA TU CURP");
        String curp = sc.next();

        Empleado empleado = new Empleado(id, nombre, apellido, direccion, telefono, fechaNacimiento,curp, nuevaContrasenia, this);
        //Empleado empleado = new Empleado(id,nombre,apellido,direccion,telefono,fechaNacimiento,curp,nuevacontrasenia);
        registrarEmpleado(empleado);
        System.out.println("Datos del empleado registrados correctamente");
    }

    public String generarIdProductoSalado(){
        int longitudProdMasUno = this.listaSalado.size() + 1;
        return String.format("ProdS%d",longitudProdMasUno);
    }

    public String generarIdDulce(){
        int longitudDulceMasUno = this.listaDulce.size() + 1;
        return String.format("ProdD%d",longitudDulceMasUno);
    }

    public String generarIdPelicula(){
        int longitudPeliculasMasUno = this.listaPeliculas.size() + 1;
        String idPelicula = String.format("P%d", longitudPeliculasMasUno);
        return idPelicula;
    }

    public String generarIdSala(){
        int longitudSalasMasUno = this.listaSalas.size() + 1;
        String idSala = String.format("S%d", longitudSalasMasUno);
        return idSala;
    }

    public void registrarPelicula(Pelicula pelicula){
        listaPeliculas.add(pelicula);
    }

    public void crearNuevaCuenta(){
        sc.nextLine();
        System.out.println("INGRESA TU NOMBRE COMPLETO: ");
        String nombre = sc.nextLine();

        System.out.println("INGRESA TU APELLIDO: ");
        String apellido = sc.next();


        System.out.println("INGRESA TU NOMBRE DE USUARIO: ");
        String id = sc.next();
        System.out.println("INGRESA TU CONTRASEÑA:");
        String nuevaContrasenia = sc.next();
        System.out.println("CONFIRMA TU CONTRASEÑA:");
        String confirmaContrasenia = sc.next();

        while (!nuevaContrasenia.equals(confirmaContrasenia)) {
            System.out.println("La contraseña no es la misma, chavo.");
            System.out.println("Confirma la contraseña:");
            confirmaContrasenia = sc.next();
        }

        System.out.println("INGRESA TU AÑO DE NACIMIENTO (YYYY): ");
        String anio = sc.next();
        System.out.println("INGRESA TU MES DE NACIMIENTO (MM): ");
        String mes = sc.next();
        System.out.println("INGRESA TU FECHA DE NACIMIENTO (DD): ");
        String dia = sc.next();
        LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));

        System.out.println("INGRESA TU DIRECCIÓN:");
        String direccion = sc.next();
        System.out.println("INGRESA TU TELÉFONO: ");
        String telefono = sc.next();

        Cliente cliente = new Cliente(id, nombre, apellido, direccion, telefono, fechaNacimiento, nuevaContrasenia, this);
        registrarCliente(cliente);
        System.out.println("Cuenta creada exitosamente.");
    }

    public boolean existePelícula(String nombrePelicula) {
        for (Pelicula pelicula : this.listaPeliculas) {
            if (pelicula.getTitulo().equals(nombrePelicula)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeSala(String idSala) {
        for (Sala sala : this.listaSalas) {
            if (sala.getId().equals(idSala)) {
                return true;
            }
        }
        return false;
    }

    public Pelicula obtenerPeliculaPorNombre(String nombrePelicula) {
        for (Pelicula pelicula : this.listaPeliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(nombrePelicula)) {
                return pelicula;
            }
        }
        return null;
    }

    public Sala obtenerSalaPorId(String idSala) {
        for (Sala sala : this.listaSalas) {
            if (sala.getId().equalsIgnoreCase(idSala)) {
                return sala;
            }
        }
        return null;
    }

    public void mostrarCartelera(){
        if (listaPeliculas.size() == 0){
            System.out.println("NO HAY PELICULAS REGISTRADAS");
        }

        for (Pelicula pelicula : this.listaPeliculas){
            System.out.println(pelicula.mostrarTitulo());
        }
    }

    public void infoPeliculasEnCartelera(String tituloPelicula){

    }
}
