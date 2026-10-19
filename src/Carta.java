public class Carta {
    private int numero;    // 1-7, 10 (sota), 11 (caballo), 12 (rey)
    private String palo;

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }


    public double getValor() {
        if (numero >= 10) {
            return 0.5;
        }
        return numero;
    }

    public String toString() {
        return numero + " de " + palo;
    }
}