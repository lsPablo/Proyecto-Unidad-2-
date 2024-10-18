package cine;

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
    public ArrayList<Producto>listaSalado = new ArrayList<>();
    public ArrayList<Producto>listaDulce =new ArrayList<>();
    public ArrayList<Producto>listaCompras =new ArrayList<>();
    public ArrayList<Pelicula>listaPeliculas =new ArrayList<>();
    public ArrayList<Sala>listaSalas =new ArrayList<>();

    public Cine(){
        LocalDate fechaNcimiento=LocalDate.of(1990,11,05);
        Admin admin =new Admin("AD-01", "Josue","Marquez","Calle #5 Mayo-#127", "4321564686",fechaNcimiento,"54321*", Rol.ADMINISTRADOR);
        this.listaUsuarios.add(admin);
        this.listaAdmin.add(admin);
    }

    public void Salas(){
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

    public String generarIdSala(){
        int longitudSalasMasUno = this.listaSalas.size() + 1;
        String idSala = String.format("S%d", longitudSalasMasUno);
        return idSala;
    }



    public void registrarPelicula(Pelicula pelicula){
        listaPeliculas.add(pelicula);
    }

    public void crearNuevaCuenta(){
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

        Cliente cliente = new Cliente(id, nombre, apellido, direccion, telefono, fechaNacimiento, nuevaContrasenia);
        registrarCliente(cliente);
        System.out.println("Cuenta creada exitosamente.");
    }

    public void agregarProductoDulce(){
        System.out.println("INGRESA EL ID DEL PRODUCTO A AGREGAR: ");
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
        Producto producto = new Producto(id, nombre, tamaño, precio);
        registrarDulce(producto);
        System.out.println("PRODUCTO REGISTRADO EXITOSAMENTE.");
    }

    public void agregarProductoSalado(){
        System.out.println("INGRESA EL ID DEL PRODUCTO A AGREGAR: ");
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
        Producto productos = new Producto(ids, nombres, tamaños, precios);
        registrarSalado(productos);
        System.out.println("PRODUCTO REGISTRADO EXITOSAMENTE.");
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

    /*public Funcion obtenerCarteleraPorId(String idCartelera) {
        for (Funcion funcion : this.listaFunciones){
            if(funcion.getId().equalsIgnoreCase(idCartelera)){
                return funcion;
            }
        }
        return null;
    }*/



}
