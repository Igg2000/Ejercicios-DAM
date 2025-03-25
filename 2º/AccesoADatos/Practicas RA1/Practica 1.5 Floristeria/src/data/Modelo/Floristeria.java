package data.Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class Floristeria {
    private List<Producto> inventario;
    private List<Venta> ventas;

    public Floristeria() {
        this.inventario = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    public List<Producto> getInventario() {
        return inventario;
    }

    public void agregarFlor(String nombre, String color, int cantidad, double precio) {
        Producto producto = buscarProductoPorNombre(nombre);

        if (producto != null && producto instanceof Flor) {
            producto.incrementarCantidad(cantidad);
            producto.setPrecio(precio); // Actualizamos el precio si ya existe
        } else {
            Flor nuevaFlor = new Flor(nombre, color, precio);
            nuevaFlor.incrementarCantidad(cantidad);
            agregarProducto(nuevaFlor);
        }
    }

    public void agregarPlanta(String nombre, String tamaño, int cantidad, double precio) {
        Producto producto = buscarProductoPorNombre(nombre);

        if (producto != null && producto instanceof Planta) {
            producto.incrementarCantidad(cantidad);
            producto.setPrecio(precio); // Actualizamos el precio si ya existe
        } else {
            Planta nuevaPlanta = new Planta(nombre, tamaño, precio);
            nuevaPlanta.incrementarCantidad(cantidad);
            agregarProducto(nuevaPlanta);
        }
    }

    public void reponerProducto(Producto producto, int cantidad) {
        if (producto != null) {
            producto.incrementarCantidad(cantidad);
            JOptionPane.showMessageDialog(null, "Producto repuesto correctamente. Nueva cantidad: " + producto.getCantidad(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Producto no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String generarHtmlFlores() {
        StringBuilder html = new StringBuilder();

        html.append("<html>")
            .append("<head>")
            .append("<style>")
            .append("body { font-family: Arial, sans-serif; background-color: #669966; color: #EAFEEA; }")
            .append("table { width: 100%; border-collapse: collapse; }")
            .append("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }")
            .append("th { background-color: #225522; color: white; }")
            .append("</style>")
            .append("</head>")
            .append("<body>")
            .append("<table>")
            .append("<tr><th>Nombre</th><th>Color</th><th>Cantidad</th><th>Precio (€)</th></tr>");

        for (Producto producto : inventario) {
            if (producto instanceof Flor) {
                Flor flor = (Flor) producto;
                html.append("<tr>")
                    .append("<td>").append(flor.getNombre()).append("</td>")
                    .append("<td>").append(flor.getColor()).append("</td>")
                    .append("<td>").append(flor.getCantidad()).append("</td>")
                    .append("<td>").append(flor.getPrecio()).append("</td>")
                    .append("</tr>");
            }
        }

        html.append("</table>")
            .append("</body>")
            .append("</html>");

        return html.toString();
    }

    public String generarHtmlPlantas() {
        StringBuilder html = new StringBuilder();

        html.append("<html>")
            .append("<head>")
            .append("<style>")
            .append("body { font-family: Arial, sans-serif; background-color: #669966; color: #EAFEEA; }")
            .append("table { width: 100%; border-collapse: collapse; }")
            .append("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }")
            .append("th { background-color: #225522; color: white; }")
            .append("</style>")
            .append("</head>")
            .append("<body>")
            .append("<table>")
            .append("<tr><th>Nombre</th><th>Tamaño</th><th>Cantidad</th><th>Precio (€)</th></tr>");

        for (Producto producto : inventario) {
            if (producto instanceof Planta) {
                Planta planta = (Planta) producto;
                html.append("<tr>")
                    .append("<td>").append(planta.getNombre()).append("</td>")
                    .append("<td>").append(planta.getTamaño()).append("</td>")
                    .append("<td>").append(planta.getCantidad()).append("</td>")
                    .append("<td>").append(planta.getPrecio()).append("</td>")
                    .append("</tr>");
            }
        }

        html.append("</table>")
            .append("</body>")
            .append("</html>");

        return html.toString();
    }

    public String generarHtmlInventario() {
        StringBuilder html = new StringBuilder();

        html.append("<html>")
            .append("<head>")
            .append("<style>")
            .append("body { font-family: Arial, sans-serif; background-color: #669966; color: #EAFEEA; }")
            .append("table { width: 100%; border-collapse: collapse; }")
            .append("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }")
            .append("th { background-color: #225522; color: white; }")
            .append("</style>")
            .append("</head>")
            .append("<body>")
            .append("<table>")
            .append("<tr><th>Nombre</th><th>Tipo</th><th>Cantidad</th><th>Precio (€)</th></tr>");

        for (Producto producto : inventario) {
            String tipo = producto instanceof Flor ? "Flor" : "Planta";
            html.append("<tr>")
                .append("<td>").append(producto.getNombre()).append("</td>")
                .append("<td>").append(tipo).append("</td>")
                .append("<td>").append(producto.getCantidad()).append("</td>")
                .append("<td>").append(producto.getPrecio()).append("</td>")
                .append("</tr>");
        }

        html.append("</table>")
            .append("</body>")
            .append("</html>");

        return html.toString();
    }
    
     // Métodos para ventas

    /**
     * Agrega una venta a la lista de ventas.
     * 
     * @param producto El producto vendido.
     * @param cantidad La cantidad vendida.
     * @param fecha La fecha de la venta.
     */
    public void registrarVenta(Producto producto, int cantidad, Calendar fecha) {
        if (producto == null) {
            JOptionPane.showMessageDialog(null, "El producto no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidad <= 0 || cantidad > producto.getCantidad()) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida o insuficiente en el inventario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Reducir la cantidad en el inventario
        producto.reducirCantidad(cantidad);

        // Crear y agregar la venta a la lista
        Venta nuevaVenta = new Venta(producto, cantidad, fecha);
        ventas.add(nuevaVenta);

        JOptionPane.showMessageDialog(null, "Venta registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Sobrecarga para registrar una venta con la fecha actual.
     * 
     * @param producto El producto vendido.
     * @param cantidad La cantidad vendida.
     */
    public void registrarVenta(Producto producto, int cantidad) {
        registrarVenta(producto, cantidad, Calendar.getInstance());
    }

    /**
     * Devuelve la lista de todas las ventas registradas.
     * 
     * @return Lista de ventas.
     */
    public List<Venta> getVentas() {
        return ventas;
    }

    /**
     * Calcula el total de ganancias obtenidas por todas las ventas.
     * 
     * @return Total de ganancias.
     */
    public double calcularTotalGanancias() {
        double total = 0.0;
        for (Venta venta : ventas) {
            total += venta.calcularTotalVenta();
        }
        return total;
    }

    /**
     * Genera un informe en formato HTML con todas las ventas.
     * 
     * @return Informe de ventas en formato HTML.
     */
    public String generarHtmlVentas() {
        double gananciasTotales = 0.0;

        // Calcular las ganancias totales
        for (Venta venta : ventas) {
            gananciasTotales += venta.calcularTotalVenta();
        }

        // Construir el HTML
        StringBuilder html = new StringBuilder();

        html.append("<html>")
            .append("<head>")
            .append("<style>")
            .append("h1 { text-align : center;}")
            .append("body { font-family: Arial, sans-serif; background-color: #669966; color: #EAFEEA; }")
            .append("table { width: 100%; border-collapse: collapse; }")
            .append("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }")
            .append("th { background-color: #225522; color: white; }")
            .append("</style>")
            .append("</head>")
            .append("<body>")
            .append("<h1>Ganancias Totales: €").append(String.format("%.2f", gananciasTotales)).append("</h1>") // Encabezado
            .append("<table>")
            .append("<tr><th>Producto</th><th>Cantidad</th><th>Fecha</th><th>Total (€)</th></tr>");

        // Añadir cada venta a la tabla
        for (Venta venta : ventas) {
            Calendar fecha = venta.getFechaVenta();
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int mes = fecha.get(Calendar.MONTH) + 1; // Los meses empiezan en 0
            int año = fecha.get(Calendar.YEAR);

            html.append("<tr>")
                .append("<td>").append(venta.getProducto().getNombre()).append("</td>")
                .append("<td>").append(venta.getCantidadVendida()).append("</td>")
                .append("<td>").append(String.format("%02d/%02d/%d", dia, mes, año)).append("</td>")
                .append("<td>").append(String.format("%.2f", venta.calcularTotalVenta())).append("</td>")
                .append("</tr>");
        }

        html.append("</table>")
            .append("</body>")
            .append("</html>");

        return html.toString();
    }

}
