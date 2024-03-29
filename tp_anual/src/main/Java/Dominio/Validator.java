package Dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static List<String> commonPasswords = getCommonPasswords();

    public static boolean masDeOchoCaracteres(String string) {
        return string.length() >= 8;
    }

    public static boolean tieneMayuscula(String string) {
        Pattern pattern = Pattern.compile(".*[A-Z].*");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean tieneMinuscula(String string) {
        Pattern pattern = Pattern.compile(".*[a-z].*");
        Matcher matcher = pattern.matcher(string);
        return  matcher.matches();
    }

    public static boolean tieneNumeros(String string) {
        Pattern pattern = Pattern.compile(".*[0-9].*");
        Matcher matcher = pattern.matcher(string);
        return  matcher.matches();
    }

    public static boolean tieneCaracteresEspeciales(String string) {
        Pattern pattern = Pattern.compile(".*[^a-zA-Z0-9 ].*");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static String parsePassword(String password) {
        return password.replaceAll("\\s+", " ");
    }

    public static List<String> getCommonPasswords() {
        String archivo = "./src/main/10-million-password-list-top-10000.txt";

        List<String> listaPasswords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                listaPasswords.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPasswords;
    }
    public static boolean validarPassword(String password) {
        String parsedPassword = parsePassword(password);
        return masDeOchoCaracteres(parsedPassword)
                && !commonPasswords.contains(password);
    }

    public static int potenciaPassword(String password) {
        int potencia = 0;

        if (masDeOchoCaracteres(parsePassword(password))) {
            potencia++;
        }

        if (tieneMayuscula(password)) {
            potencia++;
        }

        if (tieneMinuscula(password)) {
            potencia++;
        }

        if (tieneCaracteresEspeciales(password)) {
            potencia ++;
        }

        if (tieneNumeros(password)) {
            potencia ++;
        }

        return potencia;
    }
}