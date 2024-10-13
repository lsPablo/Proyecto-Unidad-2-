package cine;

import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.empleado.Empleado;

import java.util.ArrayList;

public class Cine {

    public ArrayList<Cliente>listaClientes=new ArrayList<>();
    public ArrayList<Usuario>listaUsuarios =new ArrayList<>();
    public ArrayList<Empleado>listaEmpleados =new ArrayList<>();

    public void registrarCliente(Cliente cliente){
        listaClientes.add(cliente);
        listaUsuarios.add(cliente);
    }
    public void registrarEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
        listaUsuarios.add(empleado);
    }




}
