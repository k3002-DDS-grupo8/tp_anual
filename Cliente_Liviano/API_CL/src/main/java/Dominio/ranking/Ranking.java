package Dominio.ranking;

public abstract class Ranking {

    private long id;
    private String detalle;

    public Ranking(long id, String detalle) {
        this.id = id;
        this.detalle = detalle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
