package menu;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Menu {
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
