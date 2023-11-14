package Dominio;

public class Entidad {

    public Entidad(long id, String nombre, String email, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.descripcion = descripcion;
    }

    private long id;
    private String nombre;
    private String email;
    private String descripcion;


}
