package cine;

import producto.Producto;
import usuarios.Usuario;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;
import usuarios.empleado.Empleado;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;


public class Cine {

    public ArrayList<Cliente>listaClientes=new ArrayList<>();
    public ArrayList<Usuario>listaUsuarios =new ArrayList<>();
    public ArrayList<Empleado>listaEmpleados =new ArrayList<>();
    public ArrayList<Admin>listaAdmin =new ArrayList<>();
    public ArrayList<Producto>listaSalado = new ArrayList<>();
    public ArrayList<Producto>listaDulce =new ArrayList<>();
    public ArrayList<Producto>listaCompras =new ArrayList<>();

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
            System.out.println("Este es el empleado"+iterador);
            System.out.println(empleado.mostrarDatosEmpleado());
        }
    }


}
