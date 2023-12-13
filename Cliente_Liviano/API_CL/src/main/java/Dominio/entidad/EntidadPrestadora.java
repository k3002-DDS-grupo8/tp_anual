package Dominio.entidad;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EntidadPrestadora {
    @JsonProperty("idEntidad")
    private long idEntidad;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("email")
    private String email;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("eeoId")
    private long eeoId;

    @JsonCreator
    public EntidadPrestadora(@JsonProperty("idEntidad") long idEntidad, @JsonProperty("nombre") String nombre, @JsonProperty("email") String email, @JsonProperty("descripcion") String descripcion, @JsonProperty("eeoId") long eeoId) {
        this.idEntidad = idEntidad;
        this.nombre = nombre;
        this.email = email;
        this.descripcion = descripcion;
        this.eeoId = eeoId;
    }

    public long getIdEntidad() {
        return idEntidad;
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

    public long getEeoId() {
        return eeoId;
    }

    public void setIdEntidad(long idEntidad) {
        this.idEntidad = idEntidad;
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

    public void setEeoId(long eeoId) {
        this.eeoId = eeoId;
    }
}
