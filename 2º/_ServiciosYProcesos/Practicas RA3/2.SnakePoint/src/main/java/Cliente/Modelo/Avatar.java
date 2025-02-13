package Cliente.Modelo;

public class Avatar {
    private int id;
    private String rutaImagen; // Opcional si quieres asociar una imagen al avatar

    public Avatar(int id, String rutaImagen) {
        this.id = id;
        this.rutaImagen = rutaImagen;
    }

    public int getId() {
        return id;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
}
