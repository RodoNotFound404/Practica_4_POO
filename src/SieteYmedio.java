import java.util.ArrayList;
import java.util.Scanner;

public class SieteYmedio {
    private Baraja baraja = new Baraja();
    private ArrayList<Carta> manoJugador = new ArrayList<>();
    private ArrayList<Carta> manoBanca = new ArrayList<>();
    private Scanner teclado = new Scanner(System.in);

    // Lambda: suma el valor de todas las cartas de la mano
    private double total(ArrayList<Carta> mano) {
        return mano.stream().mapToDouble(c -> c.getValor()).sum();
    }

    // Lambda: imprime cada carta de la mano
    private void mostrar(String nombre, ArrayList<Carta> mano) {
        System.out.println("\nCartas de " + nombre + ":");
        mano.forEach(c -> System.out.println("  " + c));
        System.out.println("Total: " + total(mano));
    }

    public void jugar() {
        System.out.println("=== SIETE Y MEDIO ===");
        System.out.println("Llega a 7.5 sin pasarte. Las figuras valen 0.5.");


        manoJugador.add(baraja.sacar());
        boolean pidiendo = true;
        while (pidiendo) {
            mostrar("Jugador", manoJugador);
            if (total(manoJugador) > 7.5) {
                System.out.println("Te pasaste. Gana la banca.");
                return;
            }
            System.out.print("Pedir carta? (s/n): ");
            if (teclado.nextLine().equals("s")) {
                manoJugador.add(baraja.sacar());
            } else {
                pidiendo = false;
            }
        }


        manoBanca.add(baraja.sacar());
        while (total(manoBanca) < total(manoJugador)) {
            manoBanca.add(baraja.sacar());
        }
        mostrar("Banca", manoBanca);

        if (total(manoBanca) > 7.5) {
            System.out.println("La banca se paso. Ganaste!");
        } else {
            System.out.println("Gana la banca.");
        }
    }
}