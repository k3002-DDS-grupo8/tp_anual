package Dominio;

public class TipoUsuario {
    private long id;
    private String nombre;

    public TipoUsuario(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public TipoUsuario() {
        this.id = 0;
        this.nombre = "";
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
