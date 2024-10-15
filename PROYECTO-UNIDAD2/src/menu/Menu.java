package menu;

import cine.Cine;
import peliculas.Pelicula;
import producto.Producto;
import usuarios.Usuario;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;
import usuarios.empleado.Empleado;
import usuarios.utils.Rol;

import java.time.Duration;
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
                    cine.crearNuevaCuenta();

                    break;

                    case 3:
                        System.out.println("Hasta Luego");
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
            System.out.println("Menú del Cliente");
            System.out.println("1.- VER CARTELERA");
            System.out.println("2.- COMPRAR BOLETOS");
            System.out.println("3.- Salir");

            System.out.println("SELECCIONA UNA OPCION");
            opcion = sc.nextInt();
        }
    }

    private void mostrarMenuEmpleado(Empleado empleado) {
        int opcion = 0;
        while (opcion != 11) {
            System.out.println("MENÚ DE EMPLEADO");
            System.out.println("1.-AÑIADIR PRODUCTOS DULCES A LA DULCERIA");
            System.out.println("2.-AÑIADIR PRODUCTOS SALADOS A LA DULCERIA");
            System.out.println("3.-VER PRODUCTOS DULCES");
            System.out.println("4.- VER PRODUCTOS SALADOS");
            System.out.println("5.-AGREGAR PELICULA");
            System.out.println("6.-ELIMINAR PELICULA");
            System.out.println("7.- MOSTRAR PELICULAS");
            System.out.println("8.-AGREGAR FUNCIÓN");
            System.out.println("9.-ELIMINAR FUNCIÓN");
            System.out.println("10.-MOSTRAR FUNCIONES");
            System.out.println("11.-SALIR");

            System.out.println("SELECCIONA UNA OPCION");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("--AGREGAR PROFUCTOS DULCES A LA DULCERIA--");
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
                    cine.registrarDulce(producto);
                    System.out.println("PRODUCTO REGISTRADO EXITOSAMENTE.");
                    break;
                case 2:
                    System.out.println("--AGREGAR PRODUCTOS DULCES A LA DULCERIA--");
                    System.out.println("INGRESA EL NOMBRE DEL PRODUCTO QUE VAS A INGRESAR: ");
                    String nombredulce = sc.next();
                    break;
                case 3:
                    System.out.println("AQÍ ESTAN LOS PRODUCTOS DULCES: ");
                    cine.mostrarProdDulces();
                    break;
                case 4:

                    break;
                case 5:
                   empleado.agregarPelicula();
                    break;
                case 6:
                    System.out.println("--ELIMINAR PELICULA--");
                    break;
                case 7:
                    System.out.println("--ELIMINAR PELICULA--");
                    break;
                case 8:
                    System.out.println("--AGREGAR FUNCION--");
                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:
                    System.out.println("HASTA LUEGO");
                    return;
                default:
                    System.out.println("OPCION INVALIDA.");
                    break;
            }
        }


    }

    private void mostrarMenuAdmin(Admin admin) {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("---MENÚ ADMINISTRADOR---");
            System.out.println("1.-REGISTRAR EMPLEADO.");
            System.out.println("2.-MOSTRAR DATOS DEL EMPLEADO.");
            System.out.println("3.-SALIR.");

            System.out.println("SELECCIONA UNA OPCION: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("-----HAS ELEGIDO CREAR UNA NUEVA CUENTA-----");
                    cine.registrarNuevoEmpleado();
                    break;
                case 2:
                    System.out.println("---DATOS DE EMPLEADO---");
                    cine.mostrarEmpleado();
                    break;
                case 3:
                    System.out.println("HASTA LUEGO");
                    return;
                default:
                    System.out.println("OPCION INVALIDA.");
                    break;
            }
        }
    }
}
