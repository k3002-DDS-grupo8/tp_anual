package main.comunidad;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class HorariosPosibles {
    public static List<LocalDateTime> generateDates() {
        LocalDateTime start = LocalDateTime.now();  // Fecha y hora actuales
        LocalDateTime end = start.plusDays(1);     // Un día después de la fecha y hora actuales

        Duration duration = Duration.ofMinutes(15);  // Duración de 15 minutos

        List<LocalDateTime> dates = new ArrayList<>();

        for (LocalDateTime date = start; !date.isAfter(end); date = date.plus(duration)) {
            dates.add(date);
        }

        return dates;
    }
}

