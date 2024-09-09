import java.util.ArrayList;
import java.util.List;

public class EvaluadorPalabras {
    // Método para evaluar las palabras en el texto
    public String[] evaluarPalabras(String texto) {
        // Separamos el texto en palabras usando espacios y signos de puntuación
        String[] palabras = texto.split("\\W+");
        List<String> palabrasDeCuatroSilabas = new ArrayList<>();
        
        for (String palabra : palabras) {
            if (palabra.length() >= 8) { // Aprox. 4 sílabas en español tienen mínimo 8 caracteres
                palabrasDeCuatroSilabas.add(palabra);
            }
        }
        
        return palabrasDeCuatroSilabas.toArray(new String[0]);
    }
}
