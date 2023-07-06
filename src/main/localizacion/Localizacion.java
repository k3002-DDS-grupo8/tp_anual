package main.localizacion;

public class Localizacion {
    final Lugar provincia;
    final Lugar departamento;
    final Lugar municipio;

    public Localizacion(Lugar provincia, Lugar departamento, Lugar municipio) {
        this.provincia = provincia;
        this.departamento = departamento;
        this.municipio = municipio;
    }
}