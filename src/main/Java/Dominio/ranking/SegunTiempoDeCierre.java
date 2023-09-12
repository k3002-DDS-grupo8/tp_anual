package Dominio.ranking;

import Dominio.entidad.EntidadPrestadora;
import Dominio.incidente.TipoRanking;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

public class SegunTiempoDeCierre {
    public ArrayList<TipoRanking> calcular(ArrayList<EntidadPrestadora> entidades){
        AtomicInteger contador = new AtomicInteger();
        AtomicReference<Float> acumulador = new AtomicReference<>((float) 0);
        ArrayList<TipoRanking> ranking = null;

        entidades.forEach(entidadPrestadora -> {
            contador.set(0);
            acumulador.set((float) 0);
            entidadPrestadora.listaEstablecimientos.forEach(establecimiento -> {
                establecimiento.servicios.forEach(servicio -> {
                    servicio.incidentes.forEach(incidente -> {
                        contador.getAndIncrement();
                        acumulador.getAndAccumulate(incidente.tiempoFueraDeServicio, (previous, x) -> previous + x);
                    });
                });
            });
            final float promedio = acumulador.get() / contador.get();
            final TipoRanking itemRanking = new TipoRanking(entidadPrestadora, promedio);
            ranking.add(itemRanking);
        });

        ranking.sort((a, b) -> a.numero.compareTo(b.numero));
        return ranking;
    }
}

