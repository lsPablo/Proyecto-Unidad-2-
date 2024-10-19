package cine;

import boleto.Boleto;
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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Cine {

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
        LocalDate fechaNacimiento1 = LocalDate.of(2005,11,30);
        Empleado empleado = new Empleado("E","Victor", "Hernandez","Patzcuaro","654987321",fechaNacimiento1,"Curp","123",Rol.EMPLEADO, this);
        this.listaUsuarios.add(empleado);
        this.listaEmpleados.add(empleado);
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

    public void mostrarEmpleado(){
        int iterador = 1;
        System.out.println("--Datos del Empleado--");
        for(Empleado empleado: this.listaEmpleados){
            System.out.println("Este es el empleado" +iterador);
            System.out.println(empleado.mostrarDatosEmpleado());
        }
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
        if (listaPeliculas.size() == 0){
            System.out.println("NO HAY PELICULAS REGISTRADAS");
        }
        for (Pelicula pelicula : this.listaPeliculas){
            if (pelicula.getTitulo().equals(tituloPelicula)){
                System.out.println(pelicula.mostrarDatos());
                System.out.println("--FUNCIONES--");
                for (Funcion funcion: pelicula.listaFunciones){
                    System.out.println(funcion.mostrarFuncion());
                }
            }
        }
    }

    public Funcion buscarFuncion(String titulo, LocalTime hora) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                for (Funcion funcion : pelicula.listaFunciones) {
                    if (funcion.getHoraProyeccion().equals(hora)) {
                        return funcion; // Retorna la función si se encuentra
                    }
                }
            }
        }
        System.out.println("Funcion no encontrada");
        return null; // Retorna null si no se encuentra la función
    }

    public void mostrarDistribucionSalaPorId(String idSala){
        for(Sala sala : this.listaSalas){
            if(sala.getId().equals(idSala)){
                sala.mostrarDistribucion();
            }
        }
    }

}

