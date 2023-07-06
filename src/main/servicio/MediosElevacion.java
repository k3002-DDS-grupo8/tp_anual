package main.servicio;

public class MediosElevacion extends Servicio {
    final String inicio;
    final String fin;

    public MediosElevacion(String nombre, String inicio, String fin) {
        super(nombre);
        this.inicio = inicio;
        this.fin = fin;
    }
}