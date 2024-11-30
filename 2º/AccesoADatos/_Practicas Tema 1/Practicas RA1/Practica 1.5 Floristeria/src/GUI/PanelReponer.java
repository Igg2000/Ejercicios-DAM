/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import PanelesGUI.NBoton;
import PanelesGUI.PanelAltas;
import PanelesGUI.PanelElegirObjeto;
import data.Modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nacho
 */
public class PanelReponer extends PanelElegirObjeto {

    private final Ventana v;

    private final MenuAltas panelAnterior;

    public PanelReponer(Ventana v, MenuAltas panelAnterior, List<Object> objetos, String titulo) {
        super(objetos, titulo, v.color1, v.color2, v.fuenteTitulo, v.fuenteBotones, v.colorLetraTitulo, v.colorLetraBotones);
        this.v = v;
        this.panelAnterior = panelAnterior;
        
        setBotonVolver(new NBoton("Volver", v.color1, v.color2));
        getBotonVolver().setFont(v.fuenteBotones);
        setBotonConfirmar(new NBoton("Reponer", v.color1, v.color2));
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
            
            String cantidadTexto = JOptionPane.showInputDialog(v, "Seleccione la cantidad que desea reponer");
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


            // Procesar la reposición con la cantidad validada
            JOptionPane.showMessageDialog(v, "Se repondrá " + cantidad + " unidades del producto: " + cadProductoElegido);

            
            
            List<Producto> inventario = v.getFloristeria().getInventario();
            for (Producto p : inventario) {
                if(cadProductoElegido.equals(p.toString()))
                    v.getFloristeria().reponerProducto(p, cantidad);
            }
            
            //esto actualiza la lista al momento
            List nuevaListaObjetos = new ArrayList(v.getFloristeria().getInventario());
            setObjetos(nuevaListaObjetos);
            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v, "No has seleccionado ningún objeto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Override
    public void accionVolver() {
        v.ponPanel(panelAnterior);
    }
    
}
