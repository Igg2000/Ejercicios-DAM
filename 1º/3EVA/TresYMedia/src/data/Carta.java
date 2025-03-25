package data;

public class Carta {
	private valor valor;
	private palo palo;

    public void setValor(valor valor) {
        this.valor = valor;
    }

    public void setPalo(palo palo) {
        this.palo = palo;
    }

    public Carta(valor valor, palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public valor getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }

    public palo getPalo() {
        return palo;
    }
}
