package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class AdaptadorCSV {
    public Vector<Empresa> ejectutar() {
        String archivoCSV = "src/main/empresas.csv";
        String linea;
        String separador = ",";
        Vector<Empresa> empresas = new Vector<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String encabezado = br.readLine();
            validarEncabezado(encabezado, separador);

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                validarDatos(datos);

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

        return empresas;
    }

    private void validarEncabezado(String encabezado, String separador) {
        String[] columnas = encabezado.split(separador);
        if (columnas.length < 4) {
            throw new IllegalArgumentException("El encabezado no contiene todas las columnas requeridas.");
        }
        if (!columnas[0].equals("Nombre") || !columnas[1].equals("Direccion") || !columnas[2].equals("Ciudad") || !columnas[3].equals("Pais")) {
            throw new IllegalArgumentException("Los nombres de las columnas no coinciden con el diseño esperado.");
        }
    }

    private void validarDatos(String[] datos) {
        if (datos.length < 4) {
            throw new IllegalArgumentException("Falta información en una o más columnas de los datos.");
        }
        for (String dato : datos) {
            if (dato == null || dato.isEmpty()) {
                throw new IllegalArgumentException("Los valores de las columnas no pueden ser cadenas vacías ni nulas.");
            }
        }
    }
}
