package conexionBD;

import data.Partida;
import data.Pieza;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static data.App.*;
import static data.App.password;

public class LectorDePartida {


    /**
     * Te devuelve una lista con las rondas disponibles
     * @return
     * @throws SQLException
     */
    public static List<String> obtenerRondasDisponibles() throws SQLException {
        List<String> rondas = new ArrayList<>();
        String sql = "SELECT DISTINCT ronda FROM partidas";

        try (Connection conn = GestorBD.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                rondas.add(rs.getString("ronda"));
            }
        }
        return rondas;
    }

    /**
     * Te devuelve una lista con la informacion de las partidas de la ronda elegida
     * @param ronda
     * @return
     * @throws SQLException
     */
    public static List<Partida> obtenerPartidasPorRonda(String ronda) throws SQLException {
        List<Partida> partidas = new ArrayList<>();

        String sql = """
        SELECT 
            p.id_partida,
            jb.nombre AS jugador_blancas,
            jn.nombre AS jugador_negras,
            COALESCE(jg.nombre, 'No determinado') AS ganador,
            p.fecha_inicio,
            p.fecha_fin,
            p.ronda
        FROM partidas p
        LEFT JOIN jugadores jb ON p.id_jugador_blancas = jb.id_jugador
        LEFT JOIN jugadores jn ON p.id_jugador_negras = jn.id_jugador
        LEFT JOIN jugadores jg ON p.id_ganador = jg.id_jugador
        WHERE p.ronda = \" """ + ronda +" \" " + """ 
        ORDER BY p.id_partida DESC;
        """;
        //media hora hasta que descubrí que el fallo era que la ronda iba entre comillas

        Connection conn = volverACargarConexion(url, user, password);
        ResultSet rs = GestorBD.hacerConsulta(conn, sql);
        while (rs.next()) {
            Timestamp inicio = rs.getTimestamp("fecha_inicio");
            Timestamp fin = rs.getTimestamp("fecha_fin");

            String duracion = calcularDuracion(inicio, fin);
            String estadoFin = fin != null ? fin.toString() : "En progreso";

            Partida info = new Partida(
                    rs.getInt("id_partida"),
                    rs.getString("jugador_blancas"),
                    rs.getString("jugador_negras"),
                    rs.getString("ganador"),
                    inicio.toString(),
                    estadoFin,
                    duracion,
                    rs.getString("ronda")
            );

            partidas.add(info);
        }
        return partidas;
    }

    //estuve 1 hora que me daba un error al hacer el GestorDB.getConexion()
    //mi solucion ha tenido que ser volver a cargar la conexion, sigo sin entender por que
    private static Connection volverACargarConexion(String url, String user, String password) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Cargar el driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection conn = GestorBD.establecerConexionMYSQL(url, user, password);
        GestorBD.setConexion(conn);
        return conn;
    }

    /**
     * Calcula la duracion de la partida
     * @param inicio fecha inicio de partida
     * @param fin fecha de fin de la partida
     * @return duracion formato HH:MM
     */
    private static String calcularDuracion(Timestamp inicio, Timestamp fin) {
        if (fin == null) return "Partida en curso";

        long milisegundos = fin.getTime() - inicio.getTime();
        Duration duration = Duration.ofMillis(milisegundos);

        long horas = duration.toHours();
        long minutos = duration.toMinutesPart();

        return String.format("%02d:%02d", horas, minutos);
    }

    /**
     * Carga una lista de piezas para ser usadas en el tablero
     * @param idPartida
     * @return
     * @throws SQLException
     */
    public static List<Pieza> cargarPartida(int idPartida) throws SQLException {
        List<Pieza> piezas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = GestorBD.getConexion();
            String sql = "SELECT coordenada, pieza, color FROM posiciones WHERE id_partida = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPartida);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String coordenada = rs.getString("coordenada");
                String tipoAbreviado = rs.getString("pieza");
                String colorChar = rs.getString("color");

                int[] coordenadas = convertirCoordenada(coordenada);
                String tipoCompleto = convertirTipoPieza(tipoAbreviado);
                String color = colorChar.equalsIgnoreCase("B") ? "blanco" : "negro";

                piezas.add(new Pieza(coordenadas[0], coordenadas[1], color, tipoCompleto));
            }

        } finally {
            GestorBD.cerrarRecursos(rs, stmt, null);
        }
        return piezas;
    }

    /**
     * Convierte las cordenadas de la base de datos a las coordenadas del tablero
     * @param coordenada
     * @return
     */
    private static int[] convertirCoordenada(String coordenada) {
        if (coordenada.length() != 2) {
            throw new IllegalArgumentException("Formato de coordenada inválido");
        }

        char letra = Character.toUpperCase(coordenada.charAt(0));
        char numero = coordenada.charAt(1);

        // Convertir letra (A-H) a x (0-7)
        int x = letra - 'A';

        // Convertir número (1-8) a y (0-7)
        int y = 8 - Character.getNumericValue(numero);

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalArgumentException("Coordenada fuera del tablero");
        }

        return new int[]{x, y};
    }

    /**
     * Convierte la abreviatura de las letras de la base de datos a las piezas completas
     * @param abreviado
     * @return
     */
    private static String convertirTipoPieza(String abreviado) {
        return switch (abreviado.toUpperCase()) {
            case "R" -> "REY";
            case "D" -> "REINA"; //D de Dama, para no confundir con R de Rey
            case "T" -> "TORRE";
            case "A" -> "ALFIL";
            case "C" -> "CABALLO";
            case "P" -> "PEON";
            default -> throw new IllegalArgumentException("Tipo de pieza desconocido: " + abreviado);
        };
    }
}