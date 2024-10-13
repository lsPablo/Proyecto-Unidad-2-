package menu;

import cine.Cine;
import usuarios.cliente.Cliente;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;



public class Menu {
    public Cine cine =new Cine();
    Scanner sc = new Scanner(System.in);
    public void login(){
        System.out.println("-----------------BIENVENIDO A LA FAMILIA CINEPOLLIS-----------------");
        int opcion= 0;
        while(opcion != 3){
            System.out.println("1.- INICIAR SESIÓN.");
            System.out.println("2.- CREAR CUENTA.");
            System.out.println("3.- SALIR.");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    int intentosMaximos = 5, intentosUsuario = 0;
                    System.out.println("-----------------INICIO DE SESIÓN-----------------");

                    while(intentosMaximos > 0){
                        System.out.print("INGRESA TU ID DE USUARIO: ");
                        String idUsuario = sc.nextLine();
                        System.out.print("INGRESA TU CONTRASEÑA:");
                        String contrasenia = sc.nextLine();

                        //ya solo espero que este terminado todo lo relacionado con los usuario

                    }
                break;
                case 2:
                    System.out.println("#### HAS ELEGIDO CREAR UNA NUEVA CUENTA ####");
                    System.out.println("INGRESA TU NOMBRE COMPLETO: ");
                    String nombre = sc.nextLine();
                    sc.nextLine();

                    System.out.println("INGRESA TU APELLIDO: ");
                    String apellido = sc.nextLine();
                    System.out.println("INGRESA TU NOMBRE DE USUARIO: ");
                    String id = sc.nextLine();
                    System.out.println("INGRESA TU CONTRASENIA:");
                    String nuevaContrasenia = sc.nextLine();
                    System.out.println("CONFIRMA TU CONTRSENIA");
                    String confirmaContrasenia = sc.nextLine();
                    while (!nuevaContrasenia.equals(confirmaContrasenia)) {
                        System.out.println("La contraseña no es la misma, chavo.");
                        System.out.println("Confirma la contraseña:");
                        confirmaContrasenia = sc.nextLine();
                    }

                    System.out.println("INGRESA TU ANIO DE NACIMIENTO (YYYY): ");
                    String anio = sc.nextLine();
                    System.out.println("INGRESA TU MES DE NACIMIENTO (MM): ");
                    String mes = sc.nextLine();
                    System.out.println("INGRESA TU FECHA DE NACIMIENTO (DD): ");
                    String dia = sc.nextLine();
                    LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));

                    System.out.println("INGRESA TU DIRECCION:");
                    String direccion = sc.nextLine();
                    System.out.println("INGRESA TU TELEFONO: ");
                    String telefono = sc.nextLine();
                    sc.nextLine();

                    Cliente cliente= new Cliente(id,nombre,apellido,direccion,telefono,fechaNacimiento,nuevaContrasenia);

                    cine.registrarCliente(cliente);


                    break;
                case 3:
                    System.out.println("HASTA LUEGO");
                    sc.nextLine();
                    break;
                default:
                    System.out.println("OPCION INVALIDA.");
                    break;
            }
        }
    }


}
