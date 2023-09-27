package Dominio;

public class ComunidadParaCalculo {
    private long id;
    private long[] usuariosIDs;
    private int puntosConfianza;
    private String gradoConfianza;
    private boolean activo;

    public void setId(long id) {
        this.id = id;
    }

    public void setUsuariosIDs(long[] usuariosIDs) {
        this.usuariosIDs = usuariosIDs;
    }

    public void setPuntosConfianza(int puntosConfianza) {
        this.puntosConfianza = puntosConfianza;
    }

    public void setGradoConfianza(String gradoConfianza) {
        this.gradoConfianza = gradoConfianza;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ComunidadParaCalculo() {
        this.id = 0;
        this.puntosConfianza = 0;
        this.gradoConfianza = "";
        this.activo = false;
    }
}
