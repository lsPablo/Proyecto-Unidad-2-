package producto;

public class Producto {
    String id;
    String nombre;
    double precio;
    String tamaño;

    public Producto(String id, String nombre, String tamaño ,Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tamaño = tamaño;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTamaño(){
        return tamaño;
    }

    public String mostrarProductoEmpleado(){

        return String.format("Id %s: Nombre: %s Tamaño: %s Precio: $%.2f", id, nombre, tamaño, precio);
    }
    public String mostrarProductoCliente(){
        return String.format("%s: %s Tamaño: %s. $%.2f",id, nombre, tamaño ,precio );
    }
}
