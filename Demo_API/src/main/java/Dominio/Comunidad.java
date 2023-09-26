package Dominio;
import java.util.List;

public class Comunidad {
    private long id;
    private long[] usuariosIDs;
    private int puntosConfianza;
    private String gradoConfianza;
    private boolean activo;

    public Comunidad(long id, long[] usuariosIDs, int puntosConfianza, String gradoConfianza, boolean activo) {
        this.id = id;
        this.usuariosIDs = usuariosIDs;
        this.puntosConfianza = puntosConfianza;
        this.gradoConfianza = gradoConfianza;
        this.activo = activo;
    }
}
