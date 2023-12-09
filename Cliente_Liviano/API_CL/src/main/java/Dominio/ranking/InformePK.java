package Dominio.ranking;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class InformePK {

    private Long ranking;

    private LocalDateTime fecha;

    private Integer posicion;

    public InformePK(Long ranking, LocalDateTime fecha, Integer posicion) {
        this.ranking = ranking;
        this.fecha = LocalDateTime.now();
        this.posicion = posicion;
    }

    public long getRankingId() {return ranking;}

 }
