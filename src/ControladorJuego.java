public class ControladorJuego {
    private ModeloJuego modelo;
    private VistaJuego vista;

    public ControladorJuego(ModeloJuego modelo, VistaJuego vista) {
        this.modelo = modelo;
        this.vista = vista;
    } // Fin del método ControladorJuego

    public void jugar() throws Exception {
        String eleccion1 = vista.obtenerEleccionJugador("Agente Piedra");
        String eleccion2 = vista.obtenerEleccionJugador("Agente Tijera");

        String eleccionCifrada1 = modelo.cifrarEleccion(eleccion1);
        String eleccionCifrada2 = modelo.cifrarEleccion(eleccion2);

        String eleccionDescifrada1 = modelo.descifrarEleccion(eleccionCifrada1);
        String eleccionDescifrada2 = modelo.descifrarEleccion(eleccionCifrada2);

        String resultado = modelo.determinarGanador(eleccionDescifrada1, eleccionDescifrada2);
        vista.mostrarResultado(resultado);
    } // Fin del método jugar
}
