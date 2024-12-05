/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelesGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

/**
 *
 * @author Nacho
 */
public abstract class PanelElegirObjeto extends javax.swing.JPanel {

    List<Object> objetos;
    String titulo;
    Color colorDeFondo;
    Color colorDeFondoLista;
    Font fuenteTitulo;
    Font fuenteLista;
    Color colorTitulo;
    Color colorLista;
    
    /**
     * Este es el constructor mas basico de todos
     * @param objetos Lista de objetos que se van a mostrar
     */
    public PanelElegirObjeto(List<Object> objetos) {
        inicializar(objetos, null, null, null, null, null, null, null);
    }
    /**
     * Establece los objetos a mostrar y un titulo que aparecera en la parte superior
     * @param objetos Lista de objetos a mostrar
     * @param titulo titulo que aparecerá en la parte superior
     */
    public PanelElegirObjeto(List<Object> objetos, String titulo) {
        inicializar(objetos, titulo, null, null, null, null, null, null);
    }
    
    /**
     * Establece los objetos a mostrar, un titulo en la parte superior
     * y un color de fondo
     * @param objetos Lista de objetos a mostrar
     * @param titulo titulo que aparecerá en la parte superior
     * @param colorDeFondo Color que tendrá el fondo del panel
     */
    public PanelElegirObjeto(List<Object> objetos, String titulo, Color colorDeFondo) {
        inicializar(objetos, titulo ,colorDeFondo, null, null, null, null, null);
    }

    /**
     * Establece los objetos a mostrar, un titulo en la parte superior
     * , un color de fondo y un color de fondo de la lista
     * @param objetos Lista de objetos a mostrar
     * @param titulo titulo que aparecerá en la parte superior
     * @param colorDeFondo Color que tendrá el fondo del panel
     * @param colorDeFondoLista Color que tendrá el fondo de la lista
     */
    public PanelElegirObjeto(List<Object> objetos, String titulo, Color colorDeFondo, Color colorDeFondoLista) {
        inicializar(objetos,titulo,colorDeFondo,colorDeFondoLista, null, null, null, null);
    }

    /**
     * Establece los objetos a mostrar, un titulo en la parte superior
     * , un color de fondo de panel y de lista y una fuente para el titulo
     * @param objetos Lista de objetos a mostrar
     * @param titulo titulo que aparecerá en la parte superior
     * @param colorDeFondo Color que tendrá el fondo del panel
     * @param colorDeFondoLista Color que tendrá el fondo de la lista
     * @param fuenteTitulo Fuente que tendrá el titulo
     */
    public PanelElegirObjeto(List<Object> objetos, String titulo, Color colorDeFondo, Color colorDeFondoLista, Font fuenteTitulo) {
        inicializar(objetos,titulo,colorDeFondo,colorDeFondoLista,fuenteTitulo, null, null, null);
    }

    /**
     * Establece los objetos a mostrar, un titulo en la parte superior
     * , un color de fondo de panel y de lista, una fuente para el titulo
     * una fuente para los elementos de la lista, y los colores de las letras
     * del titulo y de los elementos de la lista
     * @param objetos Lista de objetos a mostrar
     * @param titulo titulo que aparecerá en la parte superior
     * @param colorDeFondo Color que tendrá el fondo del panel
     * @param colorDeFondoLista Color que tendrá el fondo de la lista
     * @param fuenteTitulo Fuente que tendrá el titulo
     * @param fuenteLista Fuente que tendrán los elementos de la lista
     * @param colorTitulo Color que tendrá el titulo del panel
     * @param colorLista Color que tendrán los elementos de la lista
     */
    public PanelElegirObjeto(List<Object> objetos, String titulo, Color colorDeFondo,
            Color colorDeFondoLista, Font fuenteTitulo, Font fuenteLista, Color colorTitulo, Color colorLista) {
        inicializar(objetos,titulo,colorDeFondo,colorDeFondoLista,fuenteTitulo,fuenteLista, colorTitulo,colorLista);
    }
 
    //este es el metodo que inicializa el panel
    private void inicializar(List<Object> objetos, String titulo, Color colorDeFondo, Color colorDeFondoLista, Font fuenteTitulo, Font fuenteLista, Color colorTitulo, Color colorLista) {
        initComponents();
        
        this.objetos=objetos;
        this.titulo=titulo;
        this.colorDeFondo=colorDeFondo;
        this.colorDeFondoLista=colorDeFondoLista;
        this.fuenteTitulo=fuenteTitulo;
        
        //se pone el titulo
        if(titulo==null)
            this.labelTitulo.setText("");
        else
            this.labelTitulo.setText(titulo);
            
        //se pone el color de fondo
        if(colorDeFondo!=null){
            setBackground(colorDeFondo);
            //si hay fondo y no hay fondo de lista, el fondo de la lista es una version mas clara del fondo normal
            if(colorDeFondoLista==null){
                lista.setBackground(this.colorDeFondo.darker());
                //lista.setForeground(Color.white);
            }
        }
        
        //se pone el color de fondo de la lista
        if(colorDeFondoLista!=null)
            lista.setBackground(colorDeFondoLista);
        
        //se pone la fuente al titulo
        if(fuenteTitulo!=null)
            this.labelTitulo.setFont(fuenteTitulo);
        
        //se pone la fuente de los items de la lista
        if(fuenteLista!=null)
            this.lista.setFont(fuenteLista);
        
        //se pone el color de titulo
        if(colorTitulo!=null)
            this.labelTitulo.setForeground(colorTitulo);
        
        //se pone el color de los elementos de las listas
        if(colorLista!=null)
            this.lista.setForeground(colorLista);
        
        
        llenarLaListaConLosObjetos();
        funcionBotones();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        panelBotones = new javax.swing.JPanel();
        botonVolver = new javax.swing.JButton();
        botonConfirmar = new javax.swing.JButton();
        panelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 20, 10));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        lista.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lista);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelBotones.setOpaque(false);

        botonVolver.setText("Volver");
        panelBotones.add(botonVolver);

        botonConfirmar.setText("Confirmar");
        panelBotones.add(botonConfirmar);

        add(panelBotones, java.awt.BorderLayout.SOUTH);

        panelTitulo.setOpaque(false);

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelTitulo.setText("titulo");
        panelTitulo.add(labelTitulo);

        add(panelTitulo, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JList<String> lista;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables

    private void llenarLaListaConLosObjetos() {
        
        // Inicializar el modelo y el JList
        DefaultListModel modeloLista = new DefaultListModel<>();
        lista.setModel(modeloLista);
        for (Object o : objetos) {
            modeloLista.addElement(o);
        }
        
    }

    
    private void funcionBotones() {
    
        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelElegirObjeto.this.accionConfirmar();
            }
        });
    
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelElegirObjeto.this.accionVolver();
            }
        });
    
    }

    /**
     * Este es el metodo que tiene que implementar la clase que herede de esta
     * para define que hace el boton de confirmar
     */
    public abstract void accionConfirmar();
    
    /**
     * Este es el metodo que tiene que implementar la clase que herede de esta
     * para define que hace el boton de volver
     */
    public abstract void accionVolver();

    /**
     * Este metodo devuelve le objeto que has seleccionado
     * @return El Objeto seleccionado
     */
    public Object getObjetoSeleccionado() throws Exception {
        int index=lista.getSelectedIndex();
        
        if(index==-1)
            throw new Exception("No has seleccionado ningun elemento");
        
        return objetos.get(index);
        
    }
    
    /**
     * Añade un boton al panel de botones de fora mas rapida
     * @param boton Boton que se va a añadir
     */
    public void addBoton(JButton boton){
        panelBotones.add(boton);
    }
    /**
     * Vacia la lista de botones
     */
    public void vaciarPanelBotones(){
        panelBotones.removeAll();
    }
    


    
    public List<Object> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Object> objetos) {
        this.objetos = objetos;
        llenarLaListaConLosObjetos();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        inicializar(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
    }

    public Color getColorDeFondo() {
        return colorDeFondo;
    }

    public void setColorDeFondo(Color colorDeFondo) {
        this.colorDeFondo = colorDeFondo;
        inicializar(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
    }

    public Color getColorDeFondoLista() {
        return colorDeFondoLista;
    }

    public void setColorDeFondoLista(Color colorDeFondoLista) {
        this.colorDeFondoLista = colorDeFondoLista;
        inicializar(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
    }

    public JButton getBotonConfirmar() {
        return botonConfirmar;
    }

    //actualizar esto ha sido una panchitada que flipas
    public void setBotonConfirmar(JButton botonConfirmar) {
        //this.botonConfirmar = botonConfirmar;
        panelBotones.remove(this.botonConfirmar);
        
        this.botonConfirmar = botonConfirmar;
        addBoton(botonConfirmar);
        funcionBotones();
        panelBotones.revalidate();
        panelBotones.repaint();
    }

    public JButton getBotonVolver() {
        return botonVolver;
    }
    
    
    public void setBotonVolver(JButton botonVolver) {
        //this.botonVolver = botonVolver;
        
        panelBotones.remove(this.botonVolver);
         
        this.botonVolver = botonVolver;
        addBoton(botonVolver);
        funcionBotones();
        panelBotones.revalidate();
        panelBotones.repaint();
    }

    public JLabel getLabelTitulo() {
        return labelTitulo;
    }

    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    public JList<String> getLista() {
        return lista;
    }

    public void setLista(JList<String> lista) {
        this.lista = lista;
    }

    public Font getFuenteTitulo() {
        return fuenteTitulo;
    }

    public void setFuenteTitulo(Font fuenteTitulo) {
        this.fuenteTitulo = fuenteTitulo;
        inicializar(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
    }

    public Font getFuenteLista() {
        return fuenteLista;
    }

    public void setFuenteLista(Font fuenteLista) {
        this.fuenteLista = fuenteLista;
        inicializar(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
    }

    public Color getColorTitulo() {
        return colorTitulo;
    }

    public void setColorTitulo(Color colorTitulo) {
        this.colorTitulo = colorTitulo;
        inicializar(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
    }

    public Color getColorLista() {
        return colorLista;
    }

    public void setColorLista(Color colorLista) {
        this.colorLista = colorLista;
        inicializar(objetos, titulo, colorDeFondo, colorDeFondoLista, fuenteTitulo, fuenteLista, colorTitulo, colorLista);
    }


    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JPanel getPanelBotones() {
        return panelBotones;
    }

    public void setPanelBotones(JPanel panelBotones) {
        this.panelBotones = panelBotones;
    }

    public JPanel getPanelTitulo() {
        return panelTitulo;
    }

    public void setPanelTitulo(JPanel panelTitulo) {
        this.panelTitulo = panelTitulo;
    }
    
    

}
