import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ManejadorArchivo {
    public String leerContenido(File archivo) {
        StringBuilder contenido = new StringBuilder();

        try {
            String extension = getExtension(archivo);
            switch (extension) {
                case "txt":
                    contenido.append(leerTexto(archivo));
                    break;
                case "docx":
                    contenido.append(leerDocx(archivo));
                    break;
                case "pdf":
                    contenido.append(leerPdf(archivo));
                    break;
                default:
                    throw new IllegalArgumentException("Formato de archivo no soportado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenido.toString();
    }

    private String leerTexto(File archivo) throws IOException {
        // Implementación para leer archivos TXT
        return new String(java.nio.file.Files.readAllBytes(archivo.toPath()));
    }

    private String leerDocx(File archivo) throws IOException {
        // Implementación para leer archivos DOCX
        try (FileInputStream fis = new FileInputStream(archivo);
             XWPFDocument doc = new XWPFDocument(fis);
             XWPFWordExtractor extractor = new XWPFWordExtractor(doc)) {
            return extractor.getText();
        }
    }

    private String leerPdf(File archivo) throws IOException {
        // Implementación para leer archivos PDF
        try (PDDocument document = PDDocument.load(archivo);
             PDFTextStripper pdfStripper = new PDFTextStripper()) {
            return pdfStripper.getText(document);
        }
    }

    private String getExtension(File archivo) {
        String nombre = archivo.getName();
        int index = nombre.lastIndexOf('.');
        return (index == -1) ? "" : nombre.substring(index + 1).toLowerCase();
    }
}
