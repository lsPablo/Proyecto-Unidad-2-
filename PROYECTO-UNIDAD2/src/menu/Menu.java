package menu;

import cine.Cine;
import producto.Producto;
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
                        System.out.println("La contraseña no es la misma, chavo.");
                        System.out.println("Confirma la contraseña:");
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
                    System.out.println("Cuenta creada exitosamente.");

                    break;

                    case 4:
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
        while (opcion != 5) {
            System.out.println("MENÚ DEL EMPLEADO");
            System.out.println("1.-AÑIADIR PRODUCTOS DULCES A LA DULCERIA");
            System.out.println("2.-AÑIADIR PRODUCTOS SALADOS A LA DULCERIA");
            System.out.println("3.-VER PRODUCTOS DULCES");
            System.out.println("4.- VER PRODUCTOS SALADOS");
            System.out.println("5.-SALIR");

            System.out.println("SELECCIONA UNA OPCION");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("--Has seleccionado la opcion de agregar productos dulces a la dulceria--");
                    System.out.println("INGRESA EL ID DEL PRODUCTO A AGREGAR: ");
                    String id = sc.next();
                    System.out.println("Ingresa el nombre del producto que vas a ingresar: ");
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
                                System.out.println("Ingresa el precio del producto CHICO: ");
                                precio = sc.nextDouble();
                                tamaño = "CHICO";
                                break;
                                case 2:
                                    System.out.println("Ingresa el precio del producto CHICO: ");
                                    precio = sc.nextDouble();
                                    tamaño = "MEDIANO";
                                    break;
                                    case 3:
                                        System.out.println("Ingresa el precio del producto CHICO: ");
                                        precio = sc.nextDouble();
                                        tamaño = "GRANDE";
                                        break;
                                        case 4:
                                            System.out.println("Igresa el precio del producto");
                                            precio = sc.nextDouble();
                                            tamaño = "";
                                            break;
                        }
                    }
                    Producto producto = new Producto(id, nombre, tamaño, precio);
                    cine.registrarDulce(producto);
                    System.out.println("Producto registrado exitosamente.");
                    break;
                case 2:
                    System.out.println("--Haz seleccionado la opcion de agregar productos dulces a la dulceria--");
                    System.out.println("Ingresa el nombre del producto que vas a ingresar: ");
                    String nombredulce = sc.next();
                    break;
                    case 3:
                        System.out.println("AQÍ ESTAN LOS PRODUCTOS DULCES: ");
                        cine.mostrarProdDulces();
                        break;
                        case 4:
                            break;
                            case 5:
                                System.out.println("HASTA LUEGO");
                                return;
            }
        }


    }

    private void mostrarMenuAdmin(Admin admin) {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("---Menú del Admin---");
            System.out.println("1.-Registrar Empleado");
            System.out.println("2.-Mostrar datos del Empleado");
            System.out.println("3.-Salir");

            System.out.println("Selecciona una opcion");
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

                    Empleado empleado = new Empleado(id, nombre, apellido, direccion, telefono, fechaNacimiento,curp, nuevaContrasenia);
                    //Empleado empleado = new Empleado(id,nombre,apellido,direccion,telefono,fechaNacimiento,curp,nuevacontrasenia);
                    cine.registrarEmpleado(empleado);
                    System.out.println("Datos del empleado registrados correctamente");
                    break;
                case 2:
                    System.out.println("Aqui estan los datos del Empleado");
                    cine.mostrarEmpleado();
                    break;
                case 3:
                    System.out.println("Hasta Luego");
                    return;
            }
        }
    }
}
