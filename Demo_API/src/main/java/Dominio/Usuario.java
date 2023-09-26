package Dominio;

public class Usuario {
    private long id;
    private int puntosConfianza;
    private String gradoConfianza;
    private boolean activo;

    public Usuario(long id, int puntosConfianza, String gradoConfianza, boolean activo) {
        this.id = id;
        this.puntosConfianza = puntosConfianza;
        this.gradoConfianza = gradoConfianza;
        this.activo = activo;
    }
}
