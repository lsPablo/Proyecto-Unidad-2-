package producto;

public class Producto {
    String ID;
    String id;
    String nombre;
    double precio;
    String tamaño;

    public Producto(String ID, String id, String nombre, String tamaño ,Double precio) {
        this.ID = ID;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tamaño = tamaño;
    }
    public String getID() {
        return ID;
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
        return String.format("ID: %s, Categoria: %s, Nombre : %s, Tamaño: %s, Precio: $%.2f", ID,id, nombre, tamaño, precio);
    }

    public String mostrarProductoCliente(){
        return String.format("ID: %s, %s: %s Tamaño: %s. $%.2f",ID,id, nombre, tamaño ,precio );
    }

}
