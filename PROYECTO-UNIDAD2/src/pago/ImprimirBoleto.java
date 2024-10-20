package pago;

import boleto.Boleto;
import producto.Producto;
import usuarios.cliente.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class ImprimirBoleto {

    String id;
    //sala
    //asiento
    public Cliente cliente;
    //nombre pelicula
    //precio
    //tipo de asiento
    //tipo descuento.
    public Boleto boleto;
    public LocalDateTime fechaCompra;
    public Producto producto;

    public ImprimirBoleto(Cliente cliente, Producto producto, LocalDateTime fechaCompra, Boleto boleto) {
        this.cliente = cliente;
        this.producto = producto;
        this.fechaCompra = LocalDateTime.now();
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

    public String generarIdBoleto(){
        Random random = new Random();
        int AnioActual = LocalDate.now().getYear();
        int MesActual = LocalDate.now().getMonthValue();
        int DiaActual = LocalDate.now().getDayOfMonth();
        int numeroAleatorio =random.nextInt(1000000);
        return String.format("%d%d%d%d",AnioActual,numeroAleatorio,MesActual,DiaActual);
    }

    public String mostrarBoleto(){
        return String.format("ID: %s, Cliente: %s, Fecha: %s",id,cliente.getNombre(),fechaCompra);
    }

}
