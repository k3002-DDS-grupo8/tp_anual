import Dominio.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalculadorGradoDeConfianza {
    List<Incidente> incidentes = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    List<Comunidad> comunidades = new ArrayList<>();

    public List<Incidente> obtenerIncidentesFromDB() {
        List<Incidente> incidentes = new ArrayList<>();
        Incidente incidente = new Incidente(1, 1, 1, "CERRADO", LocalDateTime.now(), LocalDateTime.now());
        incidentes.add(incidente);
        return incidentes;
    }

    public List<Usuario> obtenerUsuariosFromDB() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario(1, 5);
        usuarios.add(usuario);
        return usuarios;
    }

    public List<Comunidad> obtenerComunidadesFromDB() {
        List<Comunidad> comunidades = new ArrayList<>();
        long[] usuariosIDs = new long[1];
        Comunidad comunidad = new Comunidad(1, 0, usuariosIDs);
        comunidades.add(comunidad);
        return comunidades;
    }

    public void calcularGradosDeConfianzaUsuarios() {
        //...
    }

    public void calcularGradosDeConfianzaComunidades() {
        //...
    }

    public void guardarUsuariosIntoDB() {
        System.out.println("Usuarios guardados en DB!");
    }
    public void guardarComunidadesIntoDB() {
        System.out.println("Comunidades guardadas en DB!");
    }

    public void execute() {
        incidentes = obtenerIncidentesFromDB();
        usuarios = obtenerUsuariosFromDB();
        comunidades = obtenerComunidadesFromDB();

        calcularGradosDeConfianzaUsuarios();
        calcularGradosDeConfianzaComunidades();

        guardarUsuariosIntoDB();
        guardarComunidadesIntoDB();
    }

}
