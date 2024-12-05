package data.Controlador;

import GUI.Ventana;
import data.Modelo.Flor;
import data.Modelo.Floristeria;

public class App implements Runnable {
    private Floristeria floristeria;
    private Ventana vista;
    private boolean modoDebug = false;

    public App(Floristeria floristeria, Ventana vista) {
        this.floristeria = floristeria;
        this.vista = vista;
    }

    @Override
    public void run() {
        vista.setVisible(true);

        if (modoDebug) {
            cargarDatosDePrueba();
        }
    }

    private void cargarDatosDePrueba() {
        // Agregar flores al inventario con precio
        floristeria.agregarFlor("Rosa", "Rojo", 10, 1.50);
        floristeria.agregarFlor("Margarita", "Blanco", 15, 0.75);
        floristeria.agregarFlor("Tulipán", "Amarillo", 8, 2.00);

        // Agregar plantas al inventario con precio
        floristeria.agregarPlanta("Helecho", "Grande", 5, 10.00);
        floristeria.agregarPlanta("Cactus", "Pequeño", 12, 8.50);
        floristeria.agregarPlanta("Bonsái", "Mediano", 3, 20.00);

        // Mostrar confirmación en consola
        System.out.println("Datos de prueba cargados:");
        floristeria.getInventario().forEach(producto -> 
            System.out.printf("Producto: %s, Tipo: %s, Cantidad: %d, Precio: %.2f%n",
                producto.getNombre(),
                producto instanceof Flor ? "Flor" : "Planta",
                producto.getCantidad(),
                producto.getPrecio()
            )
        );
    }

    public Floristeria getFloristeria() {
        return floristeria;
    }

    public void setFloristeria(Floristeria floristeria) {
        this.floristeria = floristeria;
    }

    public Ventana getVista() {
        return vista;
    }

    public void setVista(Ventana vista) {
        this.vista = vista;
    }
}
