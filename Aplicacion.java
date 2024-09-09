import java.io.File;

public class Aplicacion {
    private GestorInterfaz gestorInterfaz;
    private ManejadorArchivo manejadorArchivo;
    private EvaluadorPalabras evaluadorPalabras;

    public Aplicacion() {
        gestorInterfaz = new GestorInterfaz(this);  // Inicializa la interfaz gráfica
        manejadorArchivo = new ManejadorArchivo();  // Inicializa el manejador de archivos
        evaluadorPalabras = new EvaluadorPalabras();  // Inicializa el evaluador de palabras
    }

    public void iniciar() {
        gestorInterfaz.crearInterfaz();  // Lanza la interfaz gráfica
    }

    public void manejarArchivo(File archivo) {
        String contenido = manejadorArchivo.leerContenido(archivo);  // Lee el archivo
        String[] palabras = evaluadorPalabras.evaluarPalabras(contenido);  // Evalúa las palabras de 4 sílabas
        gestorInterfaz.mostrarPalabras(palabras);  // Muestra las palabras encontradas
    }

    public static void main(String[] args) {
        Aplicacion app = new Aplicacion();
        app.iniciar();
    }
}