package data.Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Floristeria {
    private List<Producto> inventario;

    public Floristeria() {
        this.inventario = new ArrayList<>();
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
    
    
    public void agregarFlor(String nombre, String color, int cantidad) {
        Producto producto = buscarProductoPorNombre(nombre);

        if (producto != null && producto instanceof Flor) {
            producto.incrementarCantidad(cantidad);
        } else {
            Flor nuevaFlor = new Flor(nombre, color);
            nuevaFlor.incrementarCantidad(cantidad);
            agregarProducto(nuevaFlor);
        }
    }
    
    public void agregarPlanta(String nombre, String tamaño, int cantidad) {
        Producto producto = buscarProductoPorNombre(nombre);

        if (producto != null && producto instanceof Planta) {
            producto.incrementarCantidad(cantidad);
        } else {
            Planta nuevaPlanta = new Planta(nombre, tamaño);
            nuevaPlanta.incrementarCantidad(cantidad);
            agregarProducto(nuevaPlanta);
        }
    }

    public void reponerProducto(Producto producto, int cantidad) {
        if (producto != null) {
            // Incrementamos la cantidad del producto recibido
            producto.incrementarCantidad(cantidad);
            JOptionPane.showMessageDialog(null, "Producto repuesto correctamente. Nueva cantidad: " + producto.getCantidad(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si el producto es null, mostramos un mensaje de error
            JOptionPane.showMessageDialog(null, "Producto no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public String generarHtmlFlores() {
        // Crear el encabezado del HTML con el CSS aplicado
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
            //.append("<h2>Lista de Flores</h2>")
            .append("<table>")
            .append("<tr><th>Nombre</th><th>Color</th><th>Cantidad</th></tr>");

        // Añadir cada flor a la tabla
        for (Producto producto : inventario) {
            if (producto instanceof Flor) {
                Flor flor = (Flor) producto;
                html.append("<tr>")
                    .append("<td>").append(flor.getNombre()).append("</td>")
                    .append("<td>").append(flor.getColor()).append("</td>")
                    .append("<td>").append(flor.getCantidad()).append("</td>")
                    .append("</tr>");
            }
        }

        html.append("</table>")
            .append("</body>")
            .append("</html>");

        return html.toString();
    }

    public String generarHtmlPlantas() {
        // Crear el encabezado del HTML con el CSS aplicado
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
            //.append("<h2>Lista de Plantas</h2>")
            .append("<table>")
            .append("<tr><th>Nombre</th><th>Tamaño (cm)</th><th>Cantidad</th></tr>");

        // Añadir cada planta a la tabla
        for (Producto producto : inventario) {
            if (producto instanceof Planta) {
                Planta planta = (Planta) producto;
                html.append("<tr>")
                    .append("<td>").append(planta.getNombre()).append("</td>")
                    .append("<td>").append(planta.getTamaño()).append(" cm</td>")
                    .append("<td>").append(planta.getCantidad()).append("</td>")
                    .append("</tr>");
            }
        }

        html.append("</table>")
            .append("</body>")
            .append("</html>");

        return html.toString();
    }

    public String generarHtmlInventario() {
        // Crear el encabezado del HTML con el CSS aplicado
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
            //.append("<h2>Inventario Completo</h2>")
            .append("<table>")
            .append("<tr><th>Nombre</th><th>Tipo</th><th>Cantidad</th></tr>");

        // Añadir todos los productos a la tabla
        for (Producto producto : inventario) {
            String tipo = producto instanceof Flor ? "Flor" : "Planta";
            html.append("<tr>")
                .append("<td>").append(producto.getNombre()).append("</td>")
                .append("<td>").append(tipo).append("</td>")
                .append("<td>").append(producto.getCantidad()).append("</td>")
                .append("</tr>");
        }

        html.append("</table>")
            .append("</body>")
            .append("</html>");

        return html.toString();
    }


}
