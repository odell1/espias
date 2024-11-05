import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class ModeloJuego {
    private SecretKey claveSecreta;

    public ModeloJuego() throws Exception {
        KeyGenerator generadorClaves = KeyGenerator.getInstance("AES");
        generadorClaves.init(128);
        this.claveSecreta = generadorClaves.generateKey();
    } // Fin del método ModeloJuego

    public String cifrarEleccion(String eleccion) throws Exception {
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.ENCRYPT_MODE, claveSecreta);
        byte[] cifrado = cifrador.doFinal(eleccion.getBytes());
        return Base64.getEncoder().encodeToString(cifrado);
    } // Fin del método cifrarEleccion

    public String descifrarEleccion(String eleccionCifrada) throws Exception {
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.DECRYPT_MODE, claveSecreta);
        byte[] decodificado = Base64.getDecoder().decode(eleccionCifrada);
        byte[] descifrado = cifrador.doFinal(decodificado);
        return new String(descifrado);
    } // Fin del método descifrarEleccion

    public String determinarGanador(String eleccion1, String eleccion2) {
        if (eleccion1.equals(eleccion2)) return "Empate";
        switch (eleccion1) {
            case "Piedra":
                return (eleccion2.equals("Tijera")) ? "Agente Piedra gana" : "Agente Tijera gana";
            case "Papel":
                return (eleccion2.equals("Piedra")) ? "Agente Papel gana" : "Agente Tijera gana";
            case "Tijera":
                return (eleccion2.equals("Papel")) ? "Agente Tijera gana" : "Agente Piedra gana";
            default:
                return "Elección inválida";
        }
    } // Fin del método determinarGanador
}
