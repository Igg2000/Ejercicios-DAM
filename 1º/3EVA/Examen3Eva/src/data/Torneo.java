package data;


import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * 
 */
public class Torneo {

    
    private Paises pais;
    private int numeroRondas;
    private int nMaxParticipantes;
    private int nParticipantes=0;
    private List<Participante> participantes = new ArrayList();
    private List<Ronda> rondas =new ArrayList();
    
    /**
     * Constructor
     * @param pais Pais donde se celebra el torneo
     * @param numeroRondas Numero de rondas del torneo
     */
    public Torneo(Paises pais, int numeroRondas) {
        this.pais = pais;
        this.numeroRondas = numeroRondas;
        //esto calcula el numero de participantes en funcion del n de rondas
        this.nMaxParticipantes = (int) Math.pow(2, numeroRondas); 
    }
    
    public void Simular() {
        // TODO implement here
                // Verificar si hay al menos una ronda
        if (rondas.isEmpty()) {
            System.out.println("El torneo aún no ha comenzado.");
            return;
        }

        System.out.println("Simulando ronda...");

        // Iterar sobre todas las rondas
        for (Ronda ronda : rondas) {
            System.out.println("---- " + ronda.getRonda() + " ----");

            // Simular todos los partidos en la ronda
            for (Partido partido : ronda.getPartidos()) {
                partido.JugarPartido();// Simular el partido
                System.out.println(partido+" ganador: "+partido.getGanador().getNombre()); // Mostrar el resultado del partido
            }
        }
        generarSiguientesRondas();
        System.out.println("¡Ronda simulada con exito!");
        }

    public void generarSiguientesRondas() {
        // Verificar si hay al menos una ronda
        if (rondas.isEmpty()) {
            System.out.println("El torneo aún no ha comenzado.");
            return;
        }

        // Crear una nueva lista de participantes para la siguiente ronda
        List<Participante> ganadoresSiguientesRondas = new ArrayList<>();

        // Iterar sobre todas las rondas
        for (Ronda ronda : rondas) {
            // Obtener los ganadores de los partidos de esta ronda
            for (Partido partido : ronda.getPartidos()) {
                Participante ganador = partido.getGanador();
                if (ganador != null) {
                    ganadoresSiguientesRondas.add(ganador);
                }
            }
        }

        // Crear una nueva ronda con los ganadores de la ronda anterior
        Ronda siguienteRonda = new Ronda(numeroRondas - 1);
        List<Partido> emparejamientos = new ArrayList<>();

        // Emparejar los ganadores de dos en dos para la siguiente ronda
        for (int i = 0; i < ganadoresSiguientesRondas.size(); i += 2) {
            if (i + 1 < ganadoresSiguientesRondas.size()) {
                Partido partido = new Partido(ganadoresSiguientesRondas.get(i), ganadoresSiguientesRondas.get(i + 1));
                emparejamientos.add(partido);
            } else {
                // En caso de que haya un número impar de ganadores lanzaremos un error
                System.out.println("Ha habido un error");
                return;
            }
        }

        // Agregar los emparejamientos a la nueva ronda
        siguienteRonda.setPartidos(emparejamientos);

        // Agregar la nueva ronda a la lista de rondas del torneo
        rondas.add(siguienteRonda);

        System.out.println("Se han generado los emparejamientos para la siguiente ronda.");
    }
    
    /**
     * Agrega participantes dando un nombre de prueba
     */
    public void AgregarParticipantes() {
        if (nParticipantes >= nMaxParticipantes) {
            JOptionPane.showMessageDialog(null,"Número máximo de participantes alcanzado: " + nMaxParticipantes);
            return;
        }
        nParticipantes++;
        participantes.add(new Participante("Jug n."+nParticipantes, nParticipantes));
    }
    /**
     * Agrega participantes con su nombre
     * @param nombre nombre del participante
     */
    public void AgregarParticipantes(String nombre) {
        nParticipantes++;
        participantes.add(new Participante(nombre, nParticipantes));
    }
    public void EliminarParticipantes(Participante p) {
        // TODO implement here
        
        nParticipantes--;
        participantes.remove(p);
        
    }
    
    public void verEmparejamiento() {
    if (rondas.isEmpty()) {
        System.out.println("El torneo aún no ha comenzado.");
        return;
    }
    
    Ronda primeraRonda = rondas.get(0);
    System.out.println(primeraRonda);
}
    
    public void realizarSorteo() {
        // Mezcla aleatoriamente la lista de participantes
        Collections.shuffle(participantes, new Random());

        List<Partido> emparejamientos = new ArrayList<>();

        // Empareja los participantes de dos en dos
        for (int i = 0; i < participantes.size(); i += 2) {
            Partido partido = new Partido(participantes.get(i), participantes.get(i + 1));
            emparejamientos.add(partido);
        }
        
        Ronda r= new Ronda(numeroRondas);
        r.setPartidos(emparejamientos);
        this.rondas.add(r);
    }

    void visualizarParticipanteModoTexto(){

        String cad="";
        for (Participante p : participantes) {
            cad += p+"\n";
        }
        System.out.println(cad);
    }
    
    void AgregarParticipantesModoTexto() {
        if (nParticipantes >= nMaxParticipantes) {
            System.out.println("Numero maximo de participantes alcanzado: " + nMaxParticipantes);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del participante: ");
        String nombre = scanner.nextLine();
        AgregarParticipantes(nombre);
    }

    void EliminarParticipantesModoTexto() {

        visualizarParticipanteModoTexto();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero del participante que desea eliminar: ");
        int numeroParticipante = scanner.nextInt();

        // Buscar el participante por su número
        Participante participanteAEliminar = null;
        for (Participante participante : participantes) {
            if (participante.getNumParticipante() == numeroParticipante) {
                participanteAEliminar = participante;
                break;
            }
        }

        // esto comprueba si existe
        if (participanteAEliminar != null) {
            participantes.remove(participanteAEliminar);
            nParticipantes--;
            System.out.println("El participante ha sido eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún participante con el número proporcionado.");
        }

    }

    
    
    @Override
    public String toString() {
        return "Torneo{" + "pais=" + pais + ", numeroRondas=" + numeroRondas + ", nParticipantes=" + nParticipantes + ", participantes=" + participantes + '}';
    }

    
    
    //hacia abajo estan los getter y los setters

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public int getNumeroRondas() {
        return numeroRondas;
    }

    public void setNumeroRondas(int numeroRondas) {
        this.numeroRondas = numeroRondas;
    }

    public int getnParticipantes() {
        return nParticipantes;
    }

    public void setnParticipantes(int nParticipantes) {
        this.nParticipantes = nParticipantes;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public int getnMaxParticipantes() {
        return nMaxParticipantes;
    }

    public void setnMaxParticipantes(int nMaxParticipantes) {
        this.nMaxParticipantes = nMaxParticipantes;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }



}