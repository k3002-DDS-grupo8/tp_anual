package Dominio.Utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeParser {

    public static LocalDateTime parse(String fechaHoraString) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

           return LocalDateTime.parse(fechaHoraString, formatter);
        }
}
