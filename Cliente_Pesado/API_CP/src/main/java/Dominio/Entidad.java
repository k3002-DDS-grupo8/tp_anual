package Dominio;

public class Entidad {
    private long id;
    private String nombre;
    private String email;
    private String descripcion;

    public Entidad() {
        this.id = 1;
        this.nombre = "hola";
        this.email = "hola@.com";
        this.descripcion = "hola + hola";
    }
    public Entidad(long id, String nombre, String email, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.descripcion = descripcion;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
