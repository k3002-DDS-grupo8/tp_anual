package Dominio.localizacion;

import javax.persistence.*;

public class Localizacion {
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

    Lugar provincia;
    Lugar departamento;
    Lugar municipio;

    public Localizacion(Lugar provincia, Lugar departamento, Lugar municipio) {
        this.provincia = provincia;
        this.departamento = departamento;
        this.municipio = municipio;
    }

    public boolean estaEnCercania(Localizacion localizacionConsultada) { return true; }
}