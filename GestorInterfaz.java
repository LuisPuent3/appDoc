import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GestorInterfaz {
    private Aplicacion aplicacion;
    private JFrame ventana;
    private JTextArea areaResultado;

    public GestorInterfaz(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    public void crearInterfaz() {
        ventana = new JFrame("Buscar palabras de 4 sílabas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 400);

        JButton botonAbrir = new JButton("Abrir archivo");
        areaResultado = new JTextArea();
        JScrollPane panelDesplazamiento = new JScrollPane(areaResultado);

        botonAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selectorArchivo = new JFileChooser();
                int opcion = selectorArchivo.showOpenDialog(ventana);
                if (opcion == JFileChooser.APPROVE_OPTION) {
                    File archivo = selectorArchivo.getSelectedFile();
                    aplicacion.manejarArchivo(archivo);  // Llama a la función para manejar el archivo
                }
            }
        });

        ventana.getContentPane().add(botonAbrir, "North");
        ventana.getContentPane().add(panelDesplazamiento, "Center");

        ventana.setVisible(true);
    }

    public void mostrarPalabras(String[] palabras) {
        if (palabras.length == 0) {
            areaResultado.setText("No se encontraron palabras de 4 sílabas.");
        } else {
            areaResultado.setText("Palabras encontradas:\n" + String.join("\n", palabras));
        }
    }
}
