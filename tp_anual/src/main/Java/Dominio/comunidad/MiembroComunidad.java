package Dominio.comunidad;

import Dominio.comunidad.MiembroComunidadPK;

import javax.persistence.*;

@Entity
public class MiembroComunidad {
    @EmbeddedId
    private MiembroComunidadPK primaryKey;

    @OneToOne
    private TipoUsuario tipoUsuario;

}