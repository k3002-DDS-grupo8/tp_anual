package Dominio.ranking;
import javax.persistence.*;
@Entity
public  class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String detalle;



}
