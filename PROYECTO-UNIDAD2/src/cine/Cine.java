package cine;

import peliculas.Pelicula;
import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.empleado.Empleado;

import java.util.ArrayList;

public class Cine {

    public ArrayList<Cliente>listaClientes=new ArrayList<>();
    public ArrayList<Usuario>listaUsuarios =new ArrayList<>();
    public ArrayList<Empleado>listaEmpleados =new ArrayList<>();
    public ArrayList<Pelicula> listaPeliculas=new ArrayList<>();

    public void registrarCliente(Cliente cliente){
        listaClientes.add(cliente);
        listaUsuarios.add(cliente);
    }
    public void registrarEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
        listaUsuarios.add(empleado);
    }
    public Usuario validarInicioSesion(String idUsuario, String contrasenia){
        for(Usuario usuario: this.listaUsuarios){
            if(usuario.getId().equals(idUsuario) && usuario.getContrasenia().equals(contrasenia)){
                return usuario;
            }
        }
        return null;
    }



}
