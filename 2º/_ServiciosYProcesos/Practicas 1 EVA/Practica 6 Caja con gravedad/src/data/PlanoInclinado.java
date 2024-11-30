package data;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanoInclinado extends JFrame {
    private JComboBox<String> materialComboBox;
    private JTextField pesoTextField;
    private JSlider anguloSlider;
    private JButton iniciarSimulacionButton;
    private JPanel simulacionPanel;

    private final double g = 9.8; // Gravedad en m/s^2

    // Coeficientes de rozamiento
    private final String[] materiales = {
            "Acero sobre acero (0.18)",
            "Acero sobre hielo (0.02)",
            "Acero sobre hierro (0.19)",
            "Hielo sobre hielo (0.028)",
            "Patines de madera sobre hielo y nieve (0.035)",
            "Goma sobre terreno firme (0.4)",
            "Cuero seco sobre metal (0.56)"
    };
    private final double[] coeficientes = {0.18, 0.02, 0.19, 0.028, 0.035, 0.4, 0.56};

    // Variables de simulación
    private double posicionX;
    private double posicionY;
    private boolean simulando;

    public PlanoInclinado() {
        setTitle("Simulación de Plano Inclinado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Panel de configuración
        JPanel configuracionPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        configuracionPanel.add(new JLabel("Material:"));
        materialComboBox = new JComboBox<>(materiales);
        configuracionPanel.add(materialComboBox);

        configuracionPanel.add(new JLabel("Peso de la maleta (gramos):"));
        pesoTextField = new JTextField();
        configuracionPanel.add(pesoTextField);

        configuracionPanel.add(new JLabel("Ángulo del plano:"));
        anguloSlider = new JSlider(0, 90, 30); // Ángulo inicial de 30 grados
        anguloSlider.setMajorTickSpacing(10);
        anguloSlider.setPaintTicks(true);
        anguloSlider.setPaintLabels(true);
        anguloSlider.addChangeListener(e -> simulacionPanel.repaint());

        configuracionPanel.add(anguloSlider);

        add(configuracionPanel, BorderLayout.NORTH);

        // Botón para iniciar simulación
        iniciarSimulacionButton = new JButton("Iniciar Simulación");
        add(iniciarSimulacionButton, BorderLayout.SOUTH);

        // Panel para animación
        simulacionPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int startX = 50;
                int baseY = 500; // Altura base del plano inclinado
                int longitudPlano = 700; // Longitud del plano inclinado

                // Obtener el ángulo del slider
                int angulo = anguloSlider.getValue();
                double theta = Math.toRadians(angulo);

                // Calcular la posición del vértice superior derecho
                int endX = (int) (startX + longitudPlano * Math.cos(theta));
                int endY = (int) (baseY - longitudPlano * Math.sin(theta));

                // Dibujar el plano inclinado
                g.setColor(Color.LIGHT_GRAY);
                g.fillPolygon(new int[]{startX, startX, endX}, new int[]{baseY, endY, baseY}, 3);

                // Dibujar la maleta
                g.setColor(Color.BLUE);
                g.fillRect((int) posicionX, (int) posicionY, 50, 50);
            }

        };
        simulacionPanel.setBackground(Color.WHITE);
        add(simulacionPanel, BorderLayout.CENTER);

        // Acción del botón
        iniciarSimulacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!simulando) {
                    iniciarSimulacion();
                }
            }
        });
    }

    private void iniciarSimulacion() {
        try {
            int peso = Integer.parseInt(pesoTextField.getText());
            if (peso <= 0) throw new NumberFormatException();

            int angulo = anguloSlider.getValue();
            int materialIndex = materialComboBox.getSelectedIndex();
            double coefRozamiento = coeficientes[materialIndex];

            // Cálculos iniciales
            double masa = peso / 1000.0; // Convertir gramos a kilogramos
            double theta = Math.toRadians(angulo);

            double fuerzaGravitacional = masa * g * Math.sin(theta);
            double fuerzaRozamiento = coefRozamiento * masa * g * Math.cos(theta);
            double aceleracion = (fuerzaGravitacional - fuerzaRozamiento) / masa;

            if (aceleracion <= 0) {
                JOptionPane.showMessageDialog(this, "La maleta no se moverá debido al alto rozamiento.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Configuración inicial de la animación
            posicionX = 50; // Vértice superior izquierdo en X
            posicionY = 500 - (700 * Math.sin(theta)) - 50; // Ajustar en función del ángulo
            simulando = true;

            // Animar el movimiento
            new Thread(() -> animarMovimiento(aceleracion, theta)).start();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un peso válido (número mayor a 0).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void animarMovimiento(double aceleracion, double theta) {
    double velocidad = 0;
    double intervalo = 0.05; // Intervalo de tiempo (segundos)

    while (posicionX < 750 && posicionY < 500) { // Límite del plano inclinado
        velocidad += aceleracion * intervalo;
        double desplazamiento = velocidad * intervalo;

        // Movimiento a lo largo del plano inclinado
        posicionX += desplazamiento * Math.cos(theta);
        posicionY += desplazamiento * Math.sin(theta);

        // Redibujar el panel
        simulacionPanel.repaint();

        try {
            Thread.sleep((int) (intervalo * 1000)); // Pausa para animación suave
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificar si la maleta llegó al final del plano
        if (posicionX >= 750 || posicionY >= 500) {
            break;
        }
    }

    simulando = false;
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlanoInclinado frame = new PlanoInclinado();
            frame.setVisible(true);
        });
    }
}
