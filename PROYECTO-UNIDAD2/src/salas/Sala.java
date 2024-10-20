package salas;

import funcion.Funcion;
import peliculas.Pelicula;
import usuarios.cliente.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sala {
    public String id;
    private String[][] distribucion = new String [12][10];
    public ArrayList<Funcion> listaFunciones;

    public Sala(String id) {
        this.id = id;
        this.listaFunciones = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<Funcion> getListaFunciones() {
        return listaFunciones;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void llenarDistribucion() {
        for (int i = 0; i < 10; i++) {
            char letra = 'L'; // Inicia con la letra 'L'
            for (int j = 0; j < 12; j++) {
                if (letra == 'L' || letra == 'K') {
                    distribucion[j][i] = letra + "V" + (i + 1);
                } else if (letra == 'J' || letra == 'I') {
                    distribucion[j][i] = letra + "P" + (i + 1);
                } else {
                    distribucion[j][i] = letra + "G" + (i + 1);
                }
                letra--; // Decrementa la letra después de su uso
            }
        }
    }

    public void mostrarDistribucion() {
        for (int i = 0; i < 12; i++) { // Corrige el rango a 11
            for (int j = 0; j < 10; j++) { // Corrige el rango a 9
                System.out.print(distribucion[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("                --------PANTALLA--------  ");
    }

    public Double reservarAsiento(String asiento) {
            Double precioAsiento = 0.00;

            asiento = asiento.trim().toUpperCase();

            boolean asientoEncontrado = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 10; j++) {
                    if (distribucion[i][j].equals(asiento)) {
                        asientoEncontrado = true;

                        // VIP
                        if (distribucion[i][j].startsWith("LV") || distribucion[i][j].startsWith("KV")) {
                            if (!distribucion[i][j].equals(" X ")) {
                                precioAsiento = 400.00;


                                distribucion[i][j] = " X ";
                                System.out.println("Asiento VIP reservado.");
                            } else {
                                System.out.println("Asiento ya reservado.");
                                return null;
                            }
                        }
                        else if (distribucion[i][j].startsWith("JP") || distribucion[i][j].startsWith("IP")) {
                            if (!distribucion[i][j].equals(" X ")) {
                                precioAsiento = 200.00;
                                distribucion[i][j] = " X ";
                                System.out.println("Asiento Preferente reservado.");
                            } else {
                                System.out.println("Asiento ya reservado.");
                                return null;
                            }
                        }
                        else {
                            if (!distribucion[i][j].equals(" X ")) {
                                precioAsiento = 75.00;
                                distribucion[i][j] = " X ";
                                System.out.println("Asiento General reservado.");
                            } else {
                                System.out.println("Asiento ya reservado.");
                                return null;
                            }
                        }
                        return precioAsiento;
                    }
                }
            }

            if (!asientoEncontrado) {
                System.out.println("Asiento no encontrado.");
            }
        return null;
        }




}

