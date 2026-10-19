import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> cartas = new ArrayList<>();

    public Baraja() {
        String[] palos = {"oros", "copas", "espadas", "bastos"};
        for (String palo : palos) {
            for (int n = 1; n <= 12; n++) {
                if (n != 8 && n != 9) {   // la baraja española no tiene 8 ni 9
                    cartas.add(new Carta(n, palo));
                }
            }
        }
        Collections.shuffle(cartas);
    }

    public Carta sacar() {
        return cartas.remove(0);
    }
}