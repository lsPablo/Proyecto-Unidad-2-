package menu;

import cine.Cine;
import usuarios.Usuario;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;
import usuarios.empleado.Empleado;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    public Cine cine = new Cine();
    Scanner sc = new Scanner(System.in);

    public void login() {
        System.out.println("-----------------BIENVENIDO A LA FAMILIA CINEPOLLIS-----------------");
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("1.- INICIAR SESIÓN.");
            System.out.println("2.- CREAR CUENTA.");
            System.out.println("3.- SALIR.");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea después de sc.nextInt()

            switch (opcion) {
                case 1:
                    int intentosMaximos = 5, intentosUsuario = 0;
                    System.out.println("-----------------INICIO DE SESIÓN-----------------");

                    while (intentosUsuario < intentosMaximos) {
                        System.out.print("INGRESA TU ID DE USUARIO: ");
                        String idUsuario = sc.nextLine();
                        System.out.print("INGRESA TU CONTRASEÑA: ");
                        String contrasenia = sc.nextLine();

                        Usuario usuarioEnSesion = cine.validarInicioSesion(idUsuario, contrasenia);
                        if (usuarioEnSesion instanceof Usuario) {
                            if (usuarioEnSesion.getRol() == Rol.CLIENTE) {
                                Cliente clienteEnSesion = (Cliente) usuarioEnSesion;
                                this.mostrarMenuCliente(clienteEnSesion);
                                intentosUsuario = 0;
                            } else if (usuarioEnSesion.getRol() == Rol.EMPLEADO) {
                                Empleado empleadoEnSesion = (Empleado) usuarioEnSesion;
                                this.mostrarMenuEmpleado(empleadoEnSesion);
                                intentosUsuario = 0;
                            } else {
                                Admin adminEnSesion = (Admin) usuarioEnSesion;
                                this.mostrarMenuAdmin(adminEnSesion);
                                intentosUsuario = 0;
                            }
                            break; // Salir del bucle de inicio de sesión si es exitoso
                        } else {
                            intentosUsuario = this.mostrarErrorInicioSesion(intentosUsuario);
                        }
                    }
                    if (intentosUsuario >= intentosMaximos) {
                        System.out.println("INTENTOS MÁXIMOS ALCANZADOS");
                    }
                    break;

                case 2:
                    System.out.println("-----HAS ELEGIDO CREAR UNA NUEVA CUENTA-----");
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
                        System.out.println("LA CONTRASEÑA NO ES LA MISMA, CHAVO..");
                        System.out.println("CONFIRMA TU CONTRASEÑA:");
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
                    cine.registrarCliente(cliente);
                    System.out.println("CUENTA CREADA EXITOSAMENTE");
                    break;

                case 3:
                    System.out.println("HASTA LUEGO");
                    break;

                default:
                    System.out.println("OPCIÓN INVÁLIDA.");
                    break;
            }
        }
    }

    private int mostrarErrorInicioSesion(int intentosUsuario) {
        System.out.println("USUARIO O CONTRASEÑA INVÁLIDOS, INTENTA DE NUEVO");
        return intentosUsuario + 1;
    }

    private void mostrarMenuCliente(Cliente cliente) {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("MENÚ CLIENTE");
            // Lógica del menú del cliente
        }
    }

    private void mostrarMenuEmpleado(Empleado empleado) {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("MENÚ DE EMPLEADO");
            System.out.println("1.-AGREGAR PELICULA");
            System.out.println("2.-ELIMINAR PELICULA");
            System.out.println("3.-AGREGAR FUNCIÓN");
            System.out.println("4.-ELIMINAR FUNCIÓN");
            System.out.println("5.-SALIR");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("INGRESA EL NOMBRE DE LA PELICULA: ");
                    String nombrePelicula = sc.nextLine();
                    System.out.println("INGRESA SU GENERO: ");
                    String generoPelicula = sc.nextLine();
                    System.out.println("INGRESA SU CLASIFICACIÓN: ");
                    String clasificacionPelicula = sc.nextLine();
                    System.out.println("");//me falta lo de la duracion pero lo iba a cambiar a que fuera de tipo time pero ya me dio sueño xd
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;

            }
        }
    }

    private void mostrarMenuAdmin(Admin admin) {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("MENÚ DE ADMINISTRADOR");
        }
    }
}
