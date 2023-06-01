import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        String archivoCSV = "src/empresas.csv";
        String linea;
        String separador = ",";
        Vector<Empresa> empresas = new Vector<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                String nombre = datos[0];
                String direccion = datos[1];
                String ciudad = datos[2];
                String pais = datos[3];
                Empresa empresa = new Empresa(nombre, direccion, ciudad, pais);
                empresas.add(empresa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir los datos de las empresas
        for (Empresa empresa : empresas) {
            System.out.println("Nombre: " + empresa.getNombre());
            System.out.println("Dirección: " + empresa.getDireccion());
            System.out.println("Ciudad: " + empresa.getCiudad());
            System.out.println("País: " + empresa.getPais());
            System.out.println();
        }
    }
}