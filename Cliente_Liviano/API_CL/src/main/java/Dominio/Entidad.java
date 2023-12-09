package Dominio;

public class Entidad {
/*
    public Entidad(/*long id, String nombre, String email, String descripcion) {
        this.id = 1;
        this.nombre = "hola";
        this.email = "hola@.com";
        this.descripcion = "hola + hola";
    }
*/
    public Entidad(long id, String nombre, String email, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private long id;
    private String nombre;
    private String email;
    private String descripcion;



}
