package main;

import java.util.Vector;

public class Main {
    public static void main(String[] args)
    {
        AdaptadorCSV adaptadorCSV = new AdaptadorCSV();
        Vector<Empresa> empresas = adaptadorCSV.ejectutar();

        for (Empresa empresa : empresas) {
            System.out.println("Nombre: " + empresa.getNombre());
            System.out.println("Dirección: " + empresa.getDireccion());
            System.out.println("Ciudad: " + empresa.getCiudad());
            System.out.println("País: " + empresa.getPais());
            System.out.println();
        }
    }
}