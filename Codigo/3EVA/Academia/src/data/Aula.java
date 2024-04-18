package data;






public class Aula {
    
    String Nombre;
    Curso CursoAula= new Curso();
    int planta;
    int capacidad;
    
    static private int contP1=0;
    static private int contP2=0;
    static private int contP3=0;

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
