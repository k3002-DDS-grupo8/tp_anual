package Dominio.localizacion;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

public class Localizacion {
    @JsonProperty("provincia")
    Lugar provincia;
    @JsonProperty("departamento")
    Lugar departamento;
    @JsonProperty("municipio")
    Lugar municipio;
    
    public Lugar getProvincia() {
        return provincia;
    }

    public void setProvincia(Lugar provincia) {
        this.provincia = provincia;
    }

    public Lugar getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Lugar departamento) {
        this.departamento = departamento;
    }

    public Lugar getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Lugar municipio) {
        this.municipio = municipio;
    }


    @JsonCreator
    public Localizacion(Lugar provincia, Lugar departamento, Lugar municipio) {
        this.provincia = provincia;
        this.departamento = departamento;
        this.municipio = municipio;
    }

    public boolean estaEnCercania(Localizacion localizacionConsultada) { return true; }
}
