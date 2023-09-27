package Dominio;

import java.util.ArrayList;
import java.util.List;

public class ComunidadParaCalculo {
    private long id;
    private List<Long> usuariosIDs;
    private GradoConfianza gradoConfianza;
    private boolean activo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Long> getUsuariosIDs() {
        return usuariosIDs;
    }

    public void setUsuariosIDs(List<Long> usuariosIDs) {
        this.usuariosIDs = usuariosIDs;
    }

    public GradoConfianza getGradoConfianza() {
        return gradoConfianza;
    }

    public void setGradoConfianza(GradoConfianza gradoConfianza) {
        this.gradoConfianza = gradoConfianza;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ComunidadParaCalculo() {
        this.id = 0;
        this.usuariosIDs = new ArrayList<Long>();
        this.gradoConfianza = GradoConfianza.CONFIABLE_NIVEL_2;
        this.activo = false;
    }

    public ComunidadParaCalculo(long id, List<Long> usuariosIDs, GradoConfianza gradoConfianza, boolean activo) {
        this.id = id;
        this.usuariosIDs = usuariosIDs;
        this.gradoConfianza = gradoConfianza;
        this.activo = activo;
    }
}
