package data;

// Clase para almacenar la información de las partidas
public class Partida {
    private final int idPartida;
    private final String jugadorBlancas;
    private final String jugadorNegras;
    private final String ganador;
    private final String fechaInicio;
    private final String fechaFin;
    private final String duracion;
    private final String ronda;

    public Partida(int idPartida, String jugadorBlancas, String jugadorNegras,
                   String ganador, String fechaInicio, String fechaFin,
                   String duracion, String ronda) {
        this.idPartida = idPartida;
        this.jugadorBlancas = jugadorBlancas;
        this.jugadorNegras = jugadorNegras;
        this.ganador = ganador;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.duracion = duracion;
        this.ronda = ronda;
    }

    // Getters
    public int getIdPartida() { return idPartida; }
    public String getJugadorBlancas() { return jugadorBlancas; }
    public String getJugadorNegras() { return jugadorNegras; }
    public String getGanador() { return ganador; }
    public String getFechaInicio() { return fechaInicio; }
    public String getFechaFin() { return fechaFin; }
    public String getDuracion() { return duracion; }
    public String getRonda() { return ronda; }
}