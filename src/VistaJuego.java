import java.util.Scanner;

public class VistaJuego {
    private Scanner escaner;

    public VistaJuego() {
        escaner = new Scanner(System.in);
    } // Fin del método VistaJuego

    public String obtenerEleccionJugador(String jugador) {
        System.out.println(jugador + ", ingresa tu elección (Piedra, Papel o Tijera): ");
        return escaner.nextLine();
    } // Fin del método obtenerEleccionJugador

    public void mostrarResultado(String resultado) {
        System.out.println(resultado);
    } // Fin del método mostrarResultado
}
