package Dominio.ranking;

import Dominio.entidad.EntidadPrestadora;
import javax.persistence.*;
@Entity
public class Informe {
    @EmbeddedId
    private InformePK primaryKey;
    @OneToOne
    private EntidadPrestadora entidad;
}
