package Dominio.comunidad;

import Dominio.incidente.Incidente;

import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MiembroComunidad {
    @JsonProperty("usuarioId")
    private long usuarioId;
    @JsonProperty("comunidadId")
    private long comunidadId;

    @JsonCreator
    public MiembroComunidad(@JsonProperty("usuarioId") long usuarioId, @JsonProperty("comunidadId") long comunidadId) {
        this.usuarioId = usuarioId;
        this.comunidadId = comunidadId;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getComunidadId() {
        return comunidadId;
    }

    public void setComunidadId(long comunidadId) {
        this.comunidadId = comunidadId;
    }
}