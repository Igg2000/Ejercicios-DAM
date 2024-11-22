package data.Modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Mundial {
    private Set<Circuito> circuitos;  // Uso Set porque no puede haber circuitos iguales
    private List<Piloto> pilotos;    // Uso List porque puede haber pilotos con el mismo nombre y del mismo pais
    private Set<Moto> motos;         // Uso Set porque no puede haber motos iguales, ya que tienen numero de moto
    private Map<Piloto, Moto> pilotosYMotos; // Relación piloto-moto
    private Set<String> escuderias;  // Uso Set ya que no puede haber 2 escuderias iguales

    public Mundial() {
        this.circuitos = new HashSet<>();
        this.pilotos = new ArrayList<>();
        this.motos = new HashSet<>();
        this.pilotosYMotos = new HashMap<>();
        this.escuderias = new HashSet<>();
    }

    // Métodos para gestionar circuitos
    public void agregarCircuito(Circuito circuito) {
        circuitos.add(circuito);
    }

    public Set<Circuito> getCircuitos() {
        return circuitos;
    }

    // Métodos para gestionar pilotos
    public void agregarPiloto(Piloto piloto) {
        if (escuderias.contains(piloto.getEscuderia())) {
            pilotos.add(piloto);
        } else {
            throw new IllegalArgumentException("La escudería " + piloto.getEscuderia() + " no está registrada.");
        }
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    // Métodos para gestionar motos
    public void agregarMoto(Moto moto) {
        motos.add(moto);
    }

    public Set<Moto> getMotos() {
        return motos;
    }

    // Métodos para asignar motos a pilotos
    public void asignarMotoAPiloto(Piloto piloto, Moto moto) {
        if (pilotos.contains(piloto) && motos.contains(moto)) {
            pilotosYMotos.put(piloto, moto);
        } else {
            throw new IllegalArgumentException("El piloto o la moto no existen en el Mundial");
        }
    }

    public Moto obtenerMotoDePiloto(Piloto piloto) {
        return pilotosYMotos.get(piloto);
    }

    public Map<Piloto, Moto> getPilotosYMotos() {
        return pilotosYMotos;
    }

    // Métodos para gestionar escuderías
    public void agregarEscuderia(String escuderia) {
        escuderias.add(escuderia);
    }

    public void eliminarEscuderia(String escuderia) {
        if (escuderias.contains(escuderia)) {
            escuderias.remove(escuderia);
        } else {
            throw new IllegalArgumentException("La escudería " + escuderia + " no está registrada.");
        }
    }

    public boolean existeEscuderia(String escuderia) {
        return escuderias.contains(escuderia);
    }

    public Set<String> getEscuderias() {
        return escuderias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mundial:\nCircuitos:\n");
        for (Circuito c : circuitos) {
            sb.append(c).append("\n");
        }

        sb.append("\nPilotos:\n");
        for (Piloto p : pilotos) {
            sb.append(p).append("\n");
        }

        sb.append("\nMotos:\n");
        for (Moto m : motos) {
            sb.append(m).append("\n");
        }

        sb.append("\nPilotos y sus Motos:\n");
        for (Map.Entry<Piloto, Moto> entry : pilotosYMotos.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }

        sb.append("\nEscuderías Disponibles:\n");
        for (String escuderia : escuderias) {
            sb.append(escuderia).append("\n");
        }

        return sb.toString();
    }
}
