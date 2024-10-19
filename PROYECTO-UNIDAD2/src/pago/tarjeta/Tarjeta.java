package pago.tarjeta;

import pago.MetodoPago;
import producto.Producto;
import usuarios.cliente.Cliente;

import java.time.LocalDateTime;

public class Tarjeta extends MetodoPago {

    public String tarjeta;

    public Tarjeta(String id, Cliente cliente, Producto producto, LocalDateTime fechaCompra, String tarjeta) {
        super(id, cliente, producto, fechaCompra);
        this.tarjeta = tarjeta;
    }

    public String getTarjeta() {
        return tarjeta;
    }
   // public String pagar(){
       // return String.format("")
    ///}
}
