package data;






public class Aula {
    
    private String Nombre;
    private Curso CursoAula;
    private int planta;
    private int capacidad;
    
    static private int contP1=0;
    static private int contP2=0;
    static private int contP3=0;
    
    //getters y setters

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Curso getCursoAula() {
        return CursoAula;
    }

    public void setCursoAula(Curso CursoAula) {
        this.CursoAula = CursoAula;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public static int getContP1() {
        return contP1;
    }

    public static void setContP1(int contP1) {
        Aula.contP1 = contP1;
    }

    public static int getContP2() {
        return contP2;
    }

    public static void setContP2(int contP2) {
        Aula.contP2 = contP2;
    }

    public static int getContP3() {
        return contP3;
    }

    public static void setContP3(int contP3) {
        Aula.contP3 = contP3;
    }

    //constructor
    public Aula(int planta) {
        this.planta =  planta;
        switch (planta){
            case 1: this.capacidad=30; contP1++; this.Nombre=(planta+"."+contP1); break;
            case 2: this.capacidad=20; contP2++; this.Nombre=(planta+"."+contP2);break;
            case 3: this.capacidad=15; contP3++; this.Nombre=(planta+"."+contP3);break;
        }
    }

    @Override
    public String toString() {
        return "Aula{" + "Nombre=" + Nombre + ", CursoAula=" + CursoAula + ", planta=" + planta + ", capacidad=" + capacidad + "}\n";
    }
    
}
