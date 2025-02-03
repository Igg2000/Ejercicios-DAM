package data;


public enum PiezasAjedrez {
    REY("♔", "♚"),
    REINA("♕", "♛"),
    TORRE("♖", "♜"),
    ALFIL("♗", "♝"),
    CABALLO("♘", "♞"),
    PEON("♙", "♟");

    private final String caracterBlanco;
    private final String caracterNegro;

    PiezasAjedrez(String caracterBlanco, String caracterNegro) {
        this.caracterBlanco = caracterBlanco;
        this.caracterNegro = caracterNegro;
    }

    public static PiezasAjedrez parseFromName(String name) {
        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return PEON; // Valor por defecto si no se reconoce el nombre
        }
    }

    public String getCaracterNegro() {
        return caracterNegro;
    }

    public String getCaracterBlanco() {
        return caracterBlanco;
    }
}