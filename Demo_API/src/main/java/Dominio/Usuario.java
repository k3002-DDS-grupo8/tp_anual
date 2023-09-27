package Dominio;

public class Usuario {
    private long id;
    private int puntosConfianza;
    private String gradoConfianza;
    private boolean activo;

    public void setId(long id) {
        this.id = id;
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

    public Usuario() {
        this.id = 0;
        this.puntosConfianza = 5;
        this.gradoConfianza = "";
        this.activo = false;
    }
}
