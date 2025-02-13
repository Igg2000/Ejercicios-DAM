package Protocolo;


public interface Protocolo {

    // Separador de campos en los mensajes
    char SEPARADOR = ':';

    // Códigos de mensaje
    int NUEVO_JUGADOR = 1;           // "1:id:nombre"
    int USUARIO_DESCONECTADO = 2;    // "2:id"
    int JUGADOR_PREPARADO = 3;  // "3:id:avatar"
    int JUGADOR_NOPREPARADO = 4; // "4:id"


    int INICIO_JUEGO = 4;            // "4:cuentaRegresiva"
    int MOVER = 5;                   // "5:id:destinoX:destinoY"
    int ACTUALIZAR = 6;              // "6:estadoJuego"
    int COMIDA_CONSUMIDA = 7;        // "7:idComida:idJugador:puntos"
    int FIN_JUEGO = 8;               // "8:idGanador:resumenResultados"

    // Código de error
    int ERROR = 100;
}
