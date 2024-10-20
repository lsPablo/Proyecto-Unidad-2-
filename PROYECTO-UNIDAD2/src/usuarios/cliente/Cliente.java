package usuarios.cliente;

import cine.Cine;
import producto.Producto;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {
    private Scanner sc = new Scanner(System.in);



    public Cliente (String id, String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, String contrasenia, Cine cine) {
        super(id, nombre, apellido, direccion, telefono, fechaNacimiento, contrasenia, Rol.CLIENTE, cine);
    }

    public String mostrarDatosCliente() {
        String datos = String.format("Id: %s, Nombre: %s, Apellido: %s, Direccion: %s, Telefono: %s, Fecha de Nacimiento: %s",
                id, nombre, apellido, direccion, telefono, fechaNacimiento);
        return datos;
    }

    public void mostrarProdcliente(){
        System.out.println("ESTOS SON LOS PRODUCTO DULCES");
        int iterador = 1;
        for(Producto producto: this.cine.listaDulce){
            System.out.println("Este es e producto: " +iterador);
            System.out.println(producto.mostrarProductoCliente());
            iterador++;
        }
        System.out.println("ESTOS SON LOS PRODUCTOS SALADOS");
        int iterador1 = 1;
        for (Producto producto: this.cine.listaSalado){
            System.out.println("Este es e producto: " +iterador1);
            System.out.println(producto.mostrarProductoCliente());
            iterador1++;
        }

    }

    public double obtenerProd(){
        System.out.println("INGRESA EL ID DEL PRODUCTO QUE DESEAS COMPRAR");
        String idProducto = sc.next();
        for (Producto producto : this.cine.listaProductos){
            if (producto.getNombre().equals(idProducto)){
                return producto.getPrecio();
            }
        }
        return 0;
    }

    public void agregarProductoACompras() {
        System.out.println("INGRESA EL ID DEL PRODUCTO QUE DESEAS COMPRAR");
        String idProducto = sc.next();
        for (Producto producto : this.cine.listaProductos) {
            if (producto.getID().equals(idProducto)) {
                System.out.println("Producto agregado a la lista de compras: " + producto.getNombre());
                cine.listaCompras.add(producto);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void mostrarTotalCompra() {
        double total = 0;
        System.out.println("Productos en la lista de compras:");
        for (Producto producto : this.cine.listaCompras) {
            System.out.println(producto.getNombre() + " - " + producto.getPrecio());
            total += producto.getPrecio();
        }
        double descuento = aplicarDescuento();
        if (descuento > 0) {
            total = total *(1-descuento);
        }
        System.out.println("Total a pagar: " + total);
    }

    public void registrarTarjeta(){

        System.out.println("INGRESA LOS DATOS DE TU TARJETA");
        String idTarjeta;
        while(true){
            System.out.println("INGRESA EL ID DE TU TARJETA");
            idTarjeta = sc.next();
            if (idTarjeta.matches("\\d{1,18}")){
                break;
            }else {
                System.out.println("Número de tarjeta inválido. Por favor, ingresa un número de hasta 18 dígitos");
            }
        }

        String CVV;
        while(true){
            System.out.println("INGRESA EL CVV DE TU TARJETA");
            CVV = sc.next();
            if (CVV.matches("\\d{3}")){
                break;
            }else{
                System.out.println("CVV INVALIDO, INGRESA EL CORRECTO");
            }
        }
        YearMonth fechaanio;
        while(true){
            System.out.println("INGRESA EL ANIO DE VENCIMIENTO DE TU TARJETA");
            int anio = sc.nextInt();
            System.out.println("Ingresa el mes de vencimiento");
            int mes = sc.nextInt();
            try{
                fechaanio = YearMonth.of(anio, mes);
                if (!cine.validarFechaCorrectas(fechaanio)){
                    System.out.println("Fecha de tarjeta vencida, intenta nuevamente");
                }else {
                    break;
                }
            }catch (DateTimeParseException e){
                System.out.println("Fecha de vencimiento invalida, intenta nuevamente");
            }
        }
        System.out.println("TARJETA REGISTRADA");
    }

    public double aplicarDescuento(){
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int mesNacimiento = fechaActual.getMonthValue();

        if (mesActual == mesNacimiento){
            System.out.println("¡FELICIDADES! TIENES UN DESCUENTO POR TU MES DE NACIMIENTO");
            return 0.2;
        }
        return 0;
    }
}
