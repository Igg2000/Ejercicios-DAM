package data.Modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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
    
    public String generarHTMLCircuitos() {
        // Ordenar los circuitos alfabéticamente por nombre
        List<Circuito> circuitosOrdenados = circuitos.stream()
            .sorted((c1, c2) -> c1.getNombre().compareToIgnoreCase(c2.getNombre()))
            .collect(Collectors.toList());

        // Construir la cadena HTML con CSS embebido
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("<html lang='es'>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("<meta charset='UTF-8'>");
        htmlBuilder.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        htmlBuilder.append("<title>Lista de Circuitos</title>");

        // Estilo CSS
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { background-color: rgb(13, 16, 35); color: white; font-family: 'Segoe UI', sans-serif; }");
        htmlBuilder.append("ul { list-style-type: none; padding: 0; }");
        htmlBuilder.append("li { background-color: rgb(49, 19, 20); margin: 10px; padding: 10px; border-radius: 5px; font-size: 18px; }");
        htmlBuilder.append("</style>");

        htmlBuilder.append("</head>");
        htmlBuilder.append("<body>");
        htmlBuilder.append("<ul>");

        for (Circuito circuito : circuitosOrdenados) {
            htmlBuilder.append("<li>")
                .append(circuito.getNombre())
                .append(" - ")
                .append(circuito.getPais())
                .append("</li>");
        }

        htmlBuilder.append("</ul>");
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }

    public String generarHTMLEscuderiasConPilotos() {
        // Mapa para agrupar pilotos por escudería
        Map<String, List<Piloto>> escuderiasConPilotos = pilotos.stream()
            .collect(Collectors.groupingBy(Piloto::getEscuderia));

        // Construir la cadena HTML
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("<html lang='es'>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("<meta charset='UTF-8'>");
        htmlBuilder.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        htmlBuilder.append("<title>Escuderías y Pilotos</title>");

        // Estilo CSS
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { background-color: rgb(13, 16, 35); color: white; font-family: 'Segoe UI', sans-serif; }");
        htmlBuilder.append("h2 { background-color: rgb(49, 19, 20); color: white; font-size: 28px; margin: 10px 0; padding: 10px; border-radius: 5px; }");
        htmlBuilder.append("ul { list-style-type: none; padding: 0; margin: 0 0 20px 0; }");
        htmlBuilder.append("li { background-color: rgb(156, 156, 156); margin: 5px; padding: 10px; border-radius: 5px; font-size: 18px; color: black; }");
        htmlBuilder.append("</style>");

        htmlBuilder.append("</head>");
        htmlBuilder.append("<body>");

        for (Map.Entry<String, List<Piloto>> entry : escuderiasConPilotos.entrySet()) {
            String escuderia = entry.getKey();
            List<Piloto> pilotosDeEscuderia = entry.getValue();

            htmlBuilder.append("<h2>").append(escuderia).append("</h2>");
            htmlBuilder.append("<ul>");
            for (Piloto piloto : pilotosDeEscuderia) {
                htmlBuilder.append("<li>")
                    .append(piloto.getNombre()) // Nombre del piloto
                    .append(" (")
                    .append(piloto.getPais()) // Nacionalidad del piloto
                    .append(")")
                    .append("</li>");
            }
            htmlBuilder.append("</ul>");
        }

        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }

    public String generarHTMLPilotosConMotos() {
        // Crear una lista de pilotos a partir del mapa y ordenarla por nombre
        List<Piloto> pilotosOrdenados = new ArrayList<>(pilotosYMotos.keySet());
        pilotosOrdenados.sort(Comparator.comparing(Piloto::getNombre));

        // Construir el HTML
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("<html lang='es'>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("<meta charset='UTF-8'>");
        htmlBuilder.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        htmlBuilder.append("<title>Pilotos y Motos</title>");

        // Estilo CSS
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { background-color: rgb(13, 16, 35); color: white; font-family: 'Segoe UI', sans-serif; }"); 
        htmlBuilder.append(".piloto { background-color: rgb(49, 19, 20); color: white; font-size: 16px; padding: 10px; margin: 10px; border-radius: 5px; }");
        htmlBuilder.append(".moto { font-size: 16px; color: rgb(200, 200, 200); }");
        htmlBuilder.append("</style>");

        htmlBuilder.append("</head>");
        htmlBuilder.append("<body>");

        for (Piloto piloto : pilotosOrdenados) {
            Moto moto = pilotosYMotos.get(piloto); // Obtener la moto del piloto
            htmlBuilder.append("<div class='piloto'>");
            htmlBuilder.append("<strong>").append(piloto.getNombre()).append("</strong>");
            htmlBuilder.append("<strong> (").append(piloto.getPais()).append(")</strong><br>");
            htmlBuilder.append("<span class='moto'>Moto: ")
                .append(moto != null ? moto.getMarca() + " " + moto.getModelo() : "Sin moto asignada")
                .append("</span>");
            htmlBuilder.append("</div>");
        }

        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }
    
    public void generarPuntos() {
        Random random = new Random();

        // Iteramos sobre todos los pilotos y asignamos puntos aleatorios
        for (Piloto piloto : pilotos) {
            // Generamos un número aleatorio entre 40 y 150
            int puntos = random.nextInt(111) + 40;  // nextInt(111) genera un número entre 0 y 110, sumamos 40 para que esté entre 40 y 150
            piloto.setPuntos(puntos);  // Asignamos los puntos al piloto usando el setter
        }
    }

   public String generarHTMLClasificacionPilotos() {
        StringBuilder html = new StringBuilder();
        html.append("<html><head>");
        html.append("<style>");
        html.append("body { font-family: 'Segoe UI', sans-serif; background-color: #0D1023; color: white; text-align: center; margin: 0; height: 100%; }");
        html.append("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
        html.append("th, td { padding: 10px; text-align: left; border: 1px solid #555; }");
        html.append("th { background-color: #312314; color: white; }");
        html.append("tr:nth-child(even) { background-color: #1e2234; }");
        html.append("tr:nth-child(odd) { background-color: #232c44; }");
        html.append("</style>");
        html.append("</head><body>");
        html.append("<table><tr><th>Nombre</th><th>Puntos</th></tr>");

        // Ordenar la lista de pilotos por puntos de mayor a menor
        pilotos.sort(Comparator.comparingInt(Piloto::getPuntos).reversed());

        // Generar las filas del HTML con los datos de los pilotos
        for (Piloto piloto : pilotos) {
            html.append("<tr><td>").append(piloto.getNombre()).append("</td>")
                .append("<td>").append(piloto.getPuntos()).append("</td></tr>");
        }

        html.append("</table>");
        html.append("</body></html>");

        return html.toString();
    }

    public String generarHTMLClasificacionEscuderias() {
        StringBuilder html = new StringBuilder();
        html.append("<html><head>");
        html.append("<style>");
        html.append("body { font-family: 'Segoe UI', sans-serif; background-color: #0D1023; color: white; text-align: center; margin: 0; height: 100%; }");
        html.append("h3 { color: #D5D5D5; font-size: 20px; }");
        html.append("p { font-size: 18px; color: #D5D5D5; }");
        html.append("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
        html.append("th, td { padding: 10px; text-align: left; border: 1px solid #555; }");
        html.append("th { background-color: #312314; color: white; }");
        html.append("tr:nth-child(even) { background-color: #1e2234; }");
        html.append("tr:nth-child(odd) { background-color: #232c44; }");
        html.append("</style>");
        html.append("</head><body>");

        // Crear un mapa para almacenar los puntos totales por escudería
        Map<String, Integer> escuderiasPuntos = new HashMap<>();
        for (Piloto piloto : pilotos) {
            escuderiasPuntos.put(piloto.getEscuderia(), escuderiasPuntos.getOrDefault(piloto.getEscuderia(), 0) + piloto.getPuntos());
        }

        // Ordenar las escuderías por puntos totales en orden descendente
        List<Map.Entry<String, Integer>> sortedEscuderias = new ArrayList<>(escuderiasPuntos.entrySet());
        sortedEscuderias.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Para cada escudería (ordenada por puntos), mostrar los pilotos y los puntos totales
        for (Map.Entry<String, Integer> entry : sortedEscuderias) {
            String escuderia = entry.getKey();
            int puntosTotales = entry.getValue();

            html.append("<h3>Escudería: ").append(escuderia).append("</h3>");
            html.append("<p>Puntos Totales: ").append(puntosTotales).append("</p>");

            // Filtrar y listar los pilotos de esa escudería
            html.append("<table><tr><th>Nombre del Piloto</th><th>Puntos</th></tr>");
            for (Piloto piloto : pilotos) {
                if (piloto.getEscuderia().equals(escuderia)) {
                    html.append("<tr><td>").append(piloto.getNombre()).append("</td>")
                        .append("<td>").append(piloto.getPuntos()).append("</td></tr>");
                }
            }
            html.append("</table>");
        }

        html.append("</body></html>");

        return html.toString();
    }




}
