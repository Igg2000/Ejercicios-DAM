package Apoyo;

public class Opcion {
    private char id;
    private String txt;

    public Opcion(char id, String txt) {
        this.id = id;
        this.txt = txt;
    }
	

    @Override
    public String toString() {
        return id + ". "+txt;
    }
        
        
        
        
	
}
