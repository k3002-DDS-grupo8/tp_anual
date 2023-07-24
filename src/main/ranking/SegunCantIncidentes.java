package main.ranking;

import main.entidad.EntidadPrestadora;
import main.incidente.EstadoIncidente;
import main.incidente.TipoRanking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SegunCantIncidentes {
    public ArrayList<TipoRanking> calcular(ArrayList<EntidadPrestadora> entidades){
        AtomicInteger contador = new AtomicInteger();
        ArrayList<TipoRanking> ranking = null;

        entidades.forEach(entidadPrestadora -> {
            contador.set(0);
            entidadPrestadora.listaEstablecimientos.forEach(establecimiento -> {
                establecimiento.servicios.forEach(servicio -> {
                    servicio.incidentes.forEach(incidente -> {
                        if(ChronoUnit.HOURS.between(LocalDateTime.now(), incidente.horarioDeApertura)>24 && incidente.estado == EstadoIncidente.ABIERTO) {
                            contador.getAndIncrement();
                        }
                    });
                });
            });
            final TipoRanking itemRanking = new TipoRanking(entidadPrestadora, (float) contador.get());
            ranking.add(itemRanking);
        });

        ranking.sort((a, b) -> a.numero.compareTo(b.numero));
        return ranking;
    }
}

