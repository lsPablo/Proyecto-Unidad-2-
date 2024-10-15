package cine;

import peliculas.Pelicula;
import producto.Producto;
import usuarios.Usuario;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;
import usuarios.empleado.Empleado;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cine {

    public ArrayList<Cliente>listaClientes=new ArrayList<>();
    public ArrayList<Usuario>listaUsuarios =new ArrayList<>();
    public ArrayList<Empleado>listaEmpleados =new ArrayList<>();
    public ArrayList<Admin>listaAdmin =new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public ArrayList<Producto>listaSalado = new ArrayList<>();
    public ArrayList<Producto>listaDulce =new ArrayList<>();
    public ArrayList<Producto>listaCompras =new ArrayList<>();
    public ArrayList<Pelicula>listaPeliculas =new ArrayList<>();

    public Cine(){
        LocalDate fechaNcimiento=LocalDate.of(1990,11,05);
        Admin admin =new Admin("AD-01", "Josue","Marquez","Calle #5 Mayo-#127", "4321564686",fechaNcimiento,"54321*", Rol.ADMINISTRADOR);
        this.listaUsuarios.add(admin);
        this.listaAdmin.add(admin);
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

        Empleado empleado = new Empleado(id, nombre, apellido, direccion, telefono, fechaNacimiento,curp, nuevaContrasenia);
        //Empleado empleado = new Empleado(id,nombre,apellido,direccion,telefono,fechaNacimiento,curp,nuevacontrasenia);
        registrarEmpleado(empleado);
        System.out.println("Datos del empleado registrados correctamente");
    }

    public String generarIdPelicula(){
        int longitudPeliculasMasUno = this.listaPeliculas.size() + 1;
        String idPelicula = String.format("P%d", longitudPeliculasMasUno);
        return idPelicula;
    }

    public void registrarPelicula(Pelicula pelicula){
        listaPeliculas.add(pelicula);
    }

    public void mostrarPelicula(){}


    public void crearNuevaCuenta(){
        System.out.println("INGRESA TU NOMBRE COMPLETO: ");
        String nombre = sc.nextLine();

        System.out.println("INGRESA TU APELLIDO: ");
        String apellido = sc.nextLine();
        System.out.println("INGRESA TU NOMBRE DE USUARIO: ");
        String id = sc.nextLine();
        System.out.println("INGRESA TU CONTRASEÑA:");
        String nuevaContrasenia = sc.nextLine();
        System.out.println("CONFIRMA TU CONTRASEÑA:");
        String confirmaContrasenia = sc.nextLine();

        while (!nuevaContrasenia.equals(confirmaContrasenia)) {
            System.out.println("La contraseña no es la misma, chavo.");
            System.out.println("Confirma la contraseña:");
            confirmaContrasenia = sc.nextLine();
        }

        System.out.println("INGRESA TU AÑO DE NACIMIENTO (YYYY): ");
        String anio = sc.nextLine();
        System.out.println("INGRESA TU MES DE NACIMIENTO (MM): ");
        String mes = sc.nextLine();
        System.out.println("INGRESA TU FECHA DE NACIMIENTO (DD): ");
        String dia = sc.nextLine();
        LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));

        System.out.println("INGRESA TU DIRECCIÓN:");
        String direccion = sc.nextLine();
        System.out.println("INGRESA TU TELÉFONO: ");
        String telefono = sc.nextLine();

        Cliente cliente = new Cliente(id, nombre, apellido, direccion, telefono, fechaNacimiento, nuevaContrasenia);
        registrarCliente(cliente);
        System.out.println("Cuenta creada exitosamente.");
    }
    //hola
}
