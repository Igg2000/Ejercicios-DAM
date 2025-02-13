package Protocolo;


public interface Protocolo {

    // Separador de campos en los mensajes
    char SEPARADOR = ':';

    // Códigos de mensaje
    int USUARIOS_CONECTADOS = 0;            // "0:usuariosConectados" servidor -> cliente
    int NUEVO_JUGADOR = 1;                  // "1:nombre" cliente -> servidor
    int JUGADOR_DESCONECTADO = 2;           // "2" cliente -> servidor
    int DAME_LISTA_DE_JUGADORES = 3;        // "3" cliente -> servidor
    int AGREGA_JUGADORES_A_LA_LISTA = 4;      // "4:nombre:nombre:nombre..." servidor -> cliente
    int JUGADOR_PREPARADO = 5;              // "5:avatar" cliente -> servidor
    int DAME_JUGADORES_PREPARADOS = 6;      // "6" cliente -> servidor
    int TOMA_JUGADORES_PREPARADOS = 7;      // "7" servidor -> cliente

    int CANCELAR_PREPARADO = 7;             // "4" cliente -> servidor


    int INICIO_JUEGO = 8;                   // "4:cuentaRegresiva"
    int MOVER = 7;                          // "5:id:destinoX:destinoY"
    int ACTUALIZAR = 8;                     // "6:estadoJuego"
    int COMIDA_CONSUMIDA = 9;                // "7:idComida:idJugador:puntos"
    int FIN_JUEGO = 10;                       // "8:idGanador:resumenResultados"

    // Código de error
    int ERROR = 100;
}
