package Protocolo;

public class ProtocoloUtiles {

    /**
     * Construye un mensaje para un nuevo usuario.
     * Formato: "1:nombre:avatar"
     */
    public static String crearMensajeNuevoUsuario(int id,String nombre) {
        return Protocolo.NUEVO_JUGADOR +
                String.valueOf(Protocolo.SEPARADOR) +
                id+
                Protocolo.SEPARADOR +
                nombre;
    }

    public static String crearMensajePreparado(int id, int avatar) {
        return Protocolo.JUGADOR_PREPARADO +
                String.valueOf(Protocolo.SEPARADOR) +
                id+
                Protocolo.SEPARADOR +
                avatar;
    }

    /**
     * Divide un mensaje en tokens usando el separador definido.
     */
    public static String[] parsearMensaje(String mensaje) {
        return mensaje.split(Character.toString(Protocolo.SEPARADOR));
    }

    /**
     * Obtiene el código (entero) del primer token de un mensaje parseado.
     */
    public static int obtenerCodigo(String[] tokens) {
        try {
            return Integer.parseInt(tokens[0]);
        } catch (NumberFormatException e) {
            return Protocolo.ERROR;
        }
    }

    // Aquí podrías añadir más métodos para construir y parsear
    // otros tipos de mensajes (MOVE, FIN_JUEGO, etc.).
}
