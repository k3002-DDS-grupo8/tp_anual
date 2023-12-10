package Dominio.ranking;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class InformePK implements Serializable {

    private Long ranking;


    private LocalDateTime fecha;

    private Integer posicion;
}