public class App {
    public static void main(String[] args) {
        try {
            ModeloJuego modelo = new ModeloJuego();
            VistaJuego vista = new VistaJuego();
            ControladorJuego controlador = new ControladorJuego(modelo, vista);
            controlador.jugar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Fin del método main

}
