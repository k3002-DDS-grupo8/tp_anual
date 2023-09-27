import Dominio.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalculadorGradoDeConfianza {
    List<Incidente> incidentes = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    List<ComunidadParaCalculo> comunidades = new ArrayList<>();

    public List<Incidente> obtenerIncidentesFromDB() {
        List<Incidente> incidentes = new ArrayList<>();
        return incidentes;
    }

    public List<Usuario> obtenerUsuariosFromDB() {
        List<Usuario> usuarios = new ArrayList<>();
        return usuarios;
    }

    public List<ComunidadParaCalculo> obtenerComunidadesFromDB() {
        List<ComunidadParaCalculo> comunidades = new ArrayList<>();
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
