package cine;

import usuarios.Usuario;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;
import usuarios.empleado.Empleado;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Cine {

    public ArrayList<Cliente>listaClientes=new ArrayList<>();
    public ArrayList<Usuario>listaUsuarios =new ArrayList<>();
    public ArrayList<Empleado>listaEmpleados =new ArrayList<>();
    public ArrayList<Admin>listaAdmin =new ArrayList<>();

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
    public Usuario validarInicioSesion(String idUsuario, String contrasenia){
        for(Usuario usuario: this.listaUsuarios){
            if(usuario.getId().equals(idUsuario) && usuario.getContrasenia().equals(contrasenia)){
                return usuario;
            }
        }
        return null;
    }
    public String generarIdEmpleado(){
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anioactual = fecha.getYear();
        int mesactual = fecha.getMonthValue();
        int diaactual = fecha.getDayOfMonth();
        int longitudCLientesMasUno = this.listaClientes.size()+1;
        int numeroAleatorio = random.nextInt(1, 100000);

        return String.format("C%d%d%d5d%d", anioactual, mesactual, diaactual, longitudCLientesMasUno,numeroAleatorio);
    }


}
