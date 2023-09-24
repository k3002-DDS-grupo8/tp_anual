package Dominio;
import java.util.List;

public class Comunidad {
    private long id;
    private int confianza;
    private long[] usuariosIDs;

    public Comunidad(long id, int confianza, long[] usuariosIDs) {
        this.id = id;
        this.confianza = confianza;
        this.usuariosIDs = usuariosIDs;
    }
}
