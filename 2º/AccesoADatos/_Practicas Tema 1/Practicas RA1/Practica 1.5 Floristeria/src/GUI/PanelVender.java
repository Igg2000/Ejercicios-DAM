/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import PanelesGUI.NBoton;
import PanelesGUI.PanelElegirObjeto;
import data.Modelo.Producto;
import data.Modelo.Venta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Panel para realizar ventas de productos.
 * @author Nacho
 */
public class PanelVender extends PanelElegirObjeto {

    private final Ventana v;
    private final JPanel panelAnterior;

    public PanelVender(Ventana v, JPanel panelAnterior, List<Object> objetos, String titulo) {
        super(objetos, titulo, v.color1, v.color2, v.fuenteTitulo, v.fuenteBotones, v.colorLetraTitulo, v.colorLetraBotones);
        this.v = v;
        this.panelAnterior = panelAnterior;

        setBotonVolver(new NBoton("Volver", v.color1, v.color2));
        getBotonVolver().setFont(v.fuenteBotones);
        setBotonConfirmar(new NBoton("Vender", v.color1, v.color2));
        getBotonConfirmar().setFont(v.fuenteBotones);
    }

    @Override
    public void accionConfirmar() {
        String cadProductoElegido = "";

        try {
            // Obtener el producto seleccionado
            cadProductoElegido = getObjetoSeleccionado().toString();

            // Validar cantidad ingresada
            int cantidad;
            String cantidadTexto = JOptionPane.showInputDialog(v, "Seleccione la cantidad que desea vender");
            if (cantidadTexto == null) {
                // Si el usuario cancela, salir del método
                return;
            }

            try {
                cantidad = Integer.parseInt(cantidadTexto);
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(v, "La cantidad debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(v, "Debe ingresar un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar el producto en el inventario y procesar la venta
            List<Producto> inventario = v.getFloristeria().getInventario();
            for (Producto p : inventario) {
                if (cadProductoElegido.equals(p.toString())) {
                    if (cantidad > p.getCantidad()) {
                        JOptionPane.showMessageDialog(v, "No hay suficiente stock disponible.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Registrar la venta
                    Calendar fecha = Calendar.getInstance();
                    v.getFloristeria().registrarVenta(p, cantidad, fecha);

                    // Mostrar confirmación
                    JOptionPane.showMessageDialog(v, "Se vendieron " + cantidad + " unidades del producto: " + cadProductoElegido);

                    // Actualizar la lista al momento
                    List nuevaListaObjetos = new ArrayList(v.getFloristeria().getInventario());
                    setObjetos(nuevaListaObjetos);
                    return;
                }
            }

            // Si el producto no se encuentra
            JOptionPane.showMessageDialog(v, "El producto no se encuentra en el inventario.", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v, "No has seleccionado ningún objeto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void accionVolver() {
        v.ponPanel(panelAnterior);
    }
}
