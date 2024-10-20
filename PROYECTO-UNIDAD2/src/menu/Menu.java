package menu;

import cine.Cine;
import funcion.Funcion;
import peliculas.Pelicula;
import salas.Sala;
import usuarios.Usuario;
import usuarios.admin.Admin;
import usuarios.cliente.Cliente;
import usuarios.empleado.Empleado;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Menu {
    public Cine cine = new Cine();
    public Pelicula pelicula;
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

                    Cliente cliente = new Cliente(id, nombre, apellido, direccion, telefono, fechaNacimiento, nuevaContrasenia, cine);
                    cine.registrarCliente(cliente);
                    System.out.println("Cuenta creada exitosamente.");

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
        while (opcion != 5) {
            System.out.println("Menú del Cliente");
            System.out.println("1.- VER CARTELERA");
            System.out.println("2.- COMPRAR BOLETOS");
            System.out.println("3.- METODO DE PAGO");
            System.out.println("4.- COMPRAR EN DULCERIA");
            System.out.println("5.- Salir");

            System.out.println("SELECCIONA UNA OPCION");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("--- CARTELERA ---");
                    cine.mostrarCartelera();

                    sc.nextLine();
                    System.out.println("¿QUÉ PELICULA VEREMOS HOY? ");
                    String peliculaVer = sc.nextLine();

                    cine.infoPeliculasEnCartelera(peliculaVer);
                    int op = 0;
                    while (op != 2 ){
                        System.out.println("1.- COMPRAR BOLETOS");
                        System.out.println("2.- SALIR.");
                        op = sc.nextInt();

                        switch (op) {
                            case 1:
                                System.out.println("--- COMPRAR BOLETOS ---");
                                sc.nextLine();
                                System.out.println("ELIGE LA HORA DE LA FUNCION (HH:MM)");
                                String hora = sc.nextLine();
                                LocalTime horaFuncionElegida = LocalTime.parse(hora);
                                System.out.println("EN QUE SALA: ");
                                String salaDeseada = sc.nextLine();
                                Funcion funcionElegida = cine.buscarFuncion(peliculaVer,horaFuncionElegida, salaDeseada);
                                cine.mostrarDistribucionSala(horaFuncionElegida, salaDeseada);
                                System.out.println("Elige la cantidad de asientos");
                                int cantidadAsientos=sc.nextInt();

                                Double totalAsientos = 0.00;
                                for (int i = 0; i < cantidadAsientos; i++) {
                                    System.out.println("Ingresa el Asiento deseado");
                                    String asiento = sc.next();
                                    totalAsientos = totalAsientos + funcionElegida.getSala().reservarAsiento(asiento);
                                }
                                System.out.println("TOTAL ASIENTOS: "+totalAsientos);

                                break;
                            case 2:
                                System.out.println("HASTA LUEGO.");
                                break;
                            default:
                                System.out.println("OPCION INVALIDA");
                                break;
                        }
                    }

                    System.out.println("");
                    break;
                case 2:
                    System.out.println("--- COMPRAR BOLETOS ---");
                    //Crear boleto.
                    break;
                    case 3:
                        int tipopago = 0;
                        while (tipopago != 3){
                            System.out.println("***SELECCIONA EL METODO DE PAGO");
                            System.out.println("1.- EFECTIVO");
                            System.out.println("2.- PAGO CON TERJETA");
                            System.out.println("3.- SALIR");
                            tipopago = sc.nextInt();

                            switch (tipopago){
                                case 1:
                                    System.out.println("HAZ SELECCIONADO LA OPCION DE PAGO EN EFECTIVO");
                                    break;
                                case 2:
                                    System.out.println("HAZ SELECCIONADO LA OPCION DE PAGO CON TARJETA");
                                    cliente.registrarTarjeta();
                                    //aplicarDescuentosSiMesNacimiento(cliente);
                                    cliente.mostrarTotalCompra();
                                    break;
                                case 3:
                                    System.out.println("HASTA LUEGO");
                                    break;
                                default:
                                    System.out.println("OPCION INVALIDA");
                                    break;
                            }
                        }
                        break;
                        case 4:
                            System.out.println("BIENVENIDO A LA DULCERIA");
                            cliente.mostrarProdcliente();
                            int verprod = 0;
                            while (verprod != 3){
                                System.out.println("1.- COMPRAR PRODUCTO");
                                System.out.println("2.- QUIERO VER QUE SALE");
                                System.out.println("3.- SALIR");
                                System.out.println("SELECCIONA UNA OPCION");
                                verprod = sc.nextInt();

                                switch (verprod){
                                    case 1:
                                        cliente.agregarProductoACompras();
                                        break;
                                    case 2:
                                        cliente.mostrarTotalCompra();
                                        break;
                                    case 3:
                                        System.out.println("HASTA LUEGO");
                                        break;
                                    default:
                                        System.out.println("OPCION INVALIDA");
                                        break;
                                }
                            }
                            break;
                case 5:
                    System.out.println("HASTA TU PROXIMA VISITA");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
            }
        }
    }

    private void mostrarMenuEmpleado(Empleado empleado) {
        int opcion = 0;
        while (opcion != 13) {
            System.out.println("MENÚ DE EMPLEADO");
            System.out.println("1.-AGREGAR PRODUCTOS DULCES A LA DULCERIA");
            System.out.println("2.-AGREGAR PRODUCTOS SALADOS A LA DULCERIA");
            System.out.println("3.-VER PRODUCTOS DULCES");
            System.out.println("4.-VER PRODUCTOS SALADOS");
            System.out.println("5.-ELIMINAR PRODUCTOS");
            System.out.println("6.-AGREGAR PELICULA");
            System.out.println("7.-MOSTRAR PELICULAS");
            System.out.println("8.-ELIMINAR PELICULAS");
            System.out.println("9.-VER SALAS");
            System.out.println("10.-AGREGAR FUNCIONES");
            System.out.println("11.-MOSTRAR FUNCIONES");
            System.out.println("12.-ELIMINAR FUNCIONES");
            System.out.println("13.-SALIR");

            System.out.println("SELECCIONA UNA OPCION");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("--AGREGAR PRODUCTOS DULCES A LA DULCERIA--");
                    empleado.agregarProductoDulce();
                    break;
                case 2:
                    System.out.println("--AGREGAR PRODUCTO SALADO A LA DULCERIA--");
                    empleado.agregarProductoSalado();

                    break;
                case 3:
                    System.out.println("AQÍ ESTAN LOS PRODUCTOS DULCES: ");
                    empleado.mostrarProdDulces();
                    break;
                case 4:
                    System.out.println("PRODUCTOS SALADOS: ");
                    empleado.mostrarProductoSalado();
                    break;
                case 5:
                    System.out.println("ELIMINAR PRODUCTO: ");
                    empleado.eliminarProductos();
                    break;
                case 6:
                    System.out.println("--AGREGAR PELÍCULA--");
                    empleado.agregarPelicula();
                    break;
                case 7:
                    System.out.println("--MOSTRAR PELICULA--");
                    empleado.mostrarPeliculas();
                    break;
                case 8:
                    System.out.println("--ELIMINAR PELICULA--");
                    empleado.eliminarPelicula();
                    break;
                case 9:
                    System.out.println("--VER SALAS--");
                    empleado.verSalas();
                    break;
                case 10:
                    System.out.println("--AGREGAR FUNCIONES--");
                    empleado.agregarFunciones();
                    break;
                case 11:
                    System.out.println("--MOSTRAR FUNCIONES--");
                    sc.nextLine();
                    System.out.println("INGRESA LA PELICULA DE INTERES: ");
                    String peliculaInteres = sc.nextLine();

                    empleado.mostratrarFunciones(peliculaInteres);
                    break;
                case 12:
                    System.out.println("--ELIMINAR FUNCIONES--");

                    sc.nextLine();
                    System.out.println("INGRESA LA PELICULA DE INTERES: ");
                    peliculaInteres = sc.nextLine();

                    empleado.mostratrarFunciones(peliculaInteres);

                    empleado.eliminarFuncion(peliculaInteres);
                    break;
                case 13:
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

                    Empleado empleado = new Empleado(id, nombre, apellido, direccion, telefono, fechaNacimiento,curp, nuevaContrasenia, Rol.EMPLEADO, cine);
                    cine.registrarEmpleado(empleado);
                    System.out.println("Datos del empleado registrados correctamente");
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
