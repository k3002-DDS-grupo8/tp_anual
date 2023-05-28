
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class APIRESTcsv {
    public static void main(String[] args) {
        String archivoCSV = "prueba.csv";
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);

                // Accede a los datos individuales de cada fila
                String columna1 = datos[0];
                String columna2 = datos[1];
                String columna3 = datos[2];
                String columna4 = datos[3];
                String columna5 = datos[4];


                // Hacer algo con los datos leídos
                System.out.println("Columna 1: " + columna1);
                System.out.println("Columna 2: " + columna2);
                System.out.println("Columna 3: " + columna3);
                System.out.println("Columna 4: " + columna4);
                System.out.println("Columna 5: " + columna5);
                // ... continua con las columnas restantes
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
