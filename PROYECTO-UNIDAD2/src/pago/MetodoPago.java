package pago;

import producto.Producto;
import usuarios.cliente.Cliente;

import java.time.LocalDateTime;

public class MetodoPago {

    String id;
    //sala
    //asiento
    public Cliente cliente;
    //nombre pelicula
    //precio
    //tipo de asiento
    //tipo descuento.
    public LocalDateTime fechaCompra;
    public Producto producto;

    public MetodoPago(String id, Cliente cliente, Producto producto, LocalDateTime fechaCompra){
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.fechaCompra = fechaCompra;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void operaciones(){

    }

}
