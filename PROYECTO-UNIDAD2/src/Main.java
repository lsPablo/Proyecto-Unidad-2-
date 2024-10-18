import cine.Cine;
import menu.Menu;
import usuarios.empleado.Empleado;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Cine cine = new Cine();
        LocalDate fechaNcimiento=LocalDate.of(1990,11,05);
        Empleado empleado = new Empleado("EM", "Josue","Marquez","Calle #5 Mayo-#127", "4321564686",fechaNcimiento,"fasdfasdf","123");
        cine.listaUsuarios.add(empleado);
        cine.listaEmpleados.add(empleado);
        menu.login();

        //Id Administrador: AD-01
        //Contrasenia: 54321*

        //ID EMPLEADO: EM
        // COTRASEÑA: 123

    }
}