import Dominio.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CalculadorGradoDeConfianza {

    //TODOS LOS LONG DEBEN LLEVAR UNA "L" A SU DERECHA :)

    MainApi APIEndpoint = new MainApi();

    public static ArrayList<Incidente> obtenerIncidentesFromDB() {
        ArrayList<Incidente> incidentes = new ArrayList<>();
        Incidente incidente = new Incidente(1L, 1, 1, LocalDateTime.now(), LocalDateTime.now(), 1, 2);
        incidentes.add(incidente);
        return incidentes;
    }

    public static ArrayList<Usuario> obtenerUsuariosFromDB() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario(1L, 2, GradoConfianza.CON_RESERVAS, true, "Pepito", "pepe@gmail.com");
        Usuario usuario2 = new Usuario(2L, 5, GradoConfianza.CONFIABLE_NIVEL_1, true, "Juancito", "juancito@gmail.com");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        return usuarios;
    }

    public static ArrayList<Comunidad> obtenerComunidadesFromDB() {
        ArrayList<Comunidad> comunidades = new ArrayList<>();
        ArrayList<Long> usuariosIDs = new ArrayList<Long>();
        usuariosIDs.add(1L);
        usuariosIDs.add(2L);
        Comunidad comunidad = new Comunidad(1L, usuariosIDs , GradoConfianza.CONFIABLE_NIVEL_2, true);
        comunidades.add(comunidad);
        return comunidades;
    }

    public void calcularGradosDeConfianzaUsuarios() {
        ArrayList<Usuario> usuarios = APIEndpoint.obtenerUsuarios();
        for(Usuario unUsuario : usuarios){
            if (unUsuario.getPuntosConfianza() < 2) {
                unUsuario.setGradoConfianza(GradoConfianza.NO_CONFIABLE);
                unUsuario.setActivo(false);
            } else if (unUsuario.getPuntosConfianza() >= 2 && unUsuario.getPuntosConfianza() <= 3) {
                unUsuario.setGradoConfianza(GradoConfianza.CON_RESERVAS);
            } else if (unUsuario.getPuntosConfianza() > 3 && unUsuario.getPuntosConfianza() <= 5) {
                unUsuario.setGradoConfianza(GradoConfianza.CONFIABLE_NIVEL_1);
            } else if (unUsuario.getPuntosConfianza() > 5) {
                unUsuario.setGradoConfianza(GradoConfianza.CONFIABLE_NIVEL_2);
            }
        }
    }

    public void calcularGradosDeConfianzaComunidades() {
        ArrayList<Comunidad> comunidades = APIEndpoint.obtenerComunidades();
        for(Comunidad unaComunidad : comunidades) {
            List<Usuario> usuariosDeLaComunidad = new ArrayList<>(getUsuariosComunidad(unaComunidad));

            double promedio = calcularPromedioComunidad(usuariosDeLaComunidad);
            int usuariosConReservas = cantidadDeUsuariosConReservaDeLaComunidad(usuariosDeLaComunidad);
            double puntosDeConfianza = promedio-0.2*usuariosConReservas;

            if (puntosDeConfianza < 2) {
                unaComunidad.setGradoConfianza(GradoConfianza.NO_CONFIABLE);
                unaComunidad.setActivo(false);
            } else if (puntosDeConfianza >= 2 && puntosDeConfianza <= 3) {
                unaComunidad.setGradoConfianza(GradoConfianza.CON_RESERVAS);
            } else if (puntosDeConfianza > 3 && puntosDeConfianza <= 5) {
                unaComunidad.setGradoConfianza(GradoConfianza.CONFIABLE_NIVEL_1);
            } else if (puntosDeConfianza > 5) {
                unaComunidad.setGradoConfianza(GradoConfianza.CONFIABLE_NIVEL_2);
            }
        }
    }

    public double calcularPromedioComunidad(List<Usuario> usuariosComunidad) {
        int contador = 0;
        double acumulador = 0;
        for (Usuario unUsuario : usuariosComunidad) {
            acumulador += unUsuario.getPuntosConfianza();
            contador ++;
        }
        return  acumulador/contador;
    }

    public int cantidadDeUsuariosConReservaDeLaComunidad(List<Usuario> usuariosDeLaComunidad) {
        int contador = 0;
        for (Usuario unUsuario : usuariosDeLaComunidad){
            if(unUsuario.getGradoConfianza() == GradoConfianza.CON_RESERVAS){
                contador++;
            }
        }
        return contador;
    }

    public ArrayList<Usuario> getUsuariosComunidad(Comunidad unaComunidad) {
        ArrayList<Usuario> usuariosComunidad = new ArrayList<>();
        for(long unIdUsuario : unaComunidad.getUsuariosIDs()){
            usuariosComunidad.add(filtrarUsuario(unIdUsuario));
        }
        return usuariosComunidad;
    }

    public void calcularPuntosDeConfianzaUsuarios() {
        List<Long> conDuplicados = new ArrayList<>();
        ArrayList<Incidente> incidentes = APIEndpoint.obtenerIncidentes();
        HashSet<Long> sinDuplicados;
        for(Incidente unIncidente : incidentes){
            if(aperturaFraudulenta(unIncidente)){
                cambiarPuntosDeConfianza(unIncidente.getIdUsuarioApertura(), -0.2f);
                conDuplicados.add(unIncidente.getIdUsuarioCierre());
            } else if (cierreFraudulento(unIncidente)) {
                cambiarPuntosDeConfianza(unIncidente.getIdUsuarioApertura(), -0.2f);
                conDuplicados.add(unIncidente.getIdUsuarioApertura());
            }else{
                conDuplicados.add(unIncidente.getIdUsuarioApertura());
                conDuplicados.add(unIncidente.getIdUsuarioCierre());
            }
        }
        sinDuplicados = new HashSet<>(conDuplicados);
        for (Long unId : sinDuplicados){
            cambiarPuntosDeConfianza(unId, 0.5f);
        }
    }

    public boolean aperturaFraudulenta(Incidente unIncidente) {
        return ChronoUnit.MINUTES.between(unIncidente.getHorarioDeApertura(), unIncidente.getHorarioDeCierre()) < 3;
    }

    public boolean sonSimilares(Incidente incidente1, Incidente incidente2) {
        return incidente1.getIdComunidad() == incidente2.getIdComunidad() && incidente1.getIdServicio() == incidente2.getIdServicio();
    }

    public boolean cierreFraudulento(Incidente unIncidente) {
        List<Incidente> incidentesPosteriores;
        incidentesPosteriores = new ArrayList<>(filtarIncidenteSegunApertura(unIncidente.getHorarioDeCierre()));

        for(Incidente unIncidentePost : incidentesPosteriores){
            if (sonSimilares(unIncidente, unIncidentePost)){
                return true;
            }
        }
        return false;
    }

    public void cambiarPuntosDeConfianza(long idUsuario, float ptos) {
        Usuario usuarioACambiar;
        usuarioACambiar = filtrarUsuario(idUsuario);
        usuarioACambiar.setPuntosConfianza(ptos);
    }

    public Usuario filtrarUsuario(long id){
        ArrayList<Usuario> usuarios = APIEndpoint.obtenerUsuarios();
        for(Usuario unUsuario : usuarios){
            if(unUsuario.getId() == id){
                return unUsuario;
            }
        }

        return null;
    }

    public List<Incidente> filtarIncidenteSegunApertura(LocalDateTime horarioCierre){
        List<Incidente> incidentesPosteriores = new ArrayList<>();
        ArrayList<Incidente> incidentes = APIEndpoint.obtenerIncidentes();
        for(Incidente unIncidente : incidentes){
            if(ChronoUnit.MINUTES.between(unIncidente.getHorarioDeApertura(), horarioCierre) < 3 && unIncidente.getHorarioDeApertura().isAfter(horarioCierre)){
                incidentesPosteriores.add(unIncidente);
            }
        }
        return incidentesPosteriores;
    }
    public void execute() {
        /* incidentes = obtenerIncidentesFromDB();
        ArrayList<Usuario> usuarios = obtenerUsuariosFromDB();
        comunidades = obtenerComunidadesFromDB();

        calcularPuntosDeConfianzaUsuarios();

        calcularGradosDeConfianzaUsuarios();
        calcularGradosDeConfianzaComunidades();

        //guardarUsuariosIntoDB();
        //guardarComunidadesIntoDB();
        MainApi.guardarUsuariosIntoDB(usuarios);

        //PRUEBAS
        System.out.println(usuarios.get(0).getPuntosConfianza());
        System.out.println(usuarios.get(0).getGradoConfianza());
        System.out.println(usuarios.get(0).isActivo());
        System.out.println(usuarios.get(1).getPuntosConfianza());
        System.out.println(usuarios.get(1).getGradoConfianza());
        System.out.println(usuarios.get(1).isActivo());
        System.out.println(comunidades.get(0).getGradoConfianza()); */
    }

    public static void main(String[] args) {
        List<Incidente> incidentes = obtenerIncidentesFromDB();
        ArrayList<Usuario> usuarios = obtenerUsuariosFromDB();
        ArrayList<Comunidad> comunidades = obtenerComunidadesFromDB();

        Usuario usuario1 = new Usuario(1, 4, GradoConfianza.CON_RESERVAS, true, "Pepito", "pepito@gmail.com");
        Usuario usuario2 = new Usuario(1, 4, GradoConfianza.CONFIABLE_NIVEL_2, true, "Juancito", "juan@gmail.com");
        ArrayList<Usuario> usuariosParaCargar = new ArrayList<>();
        usuariosParaCargar.add(usuario1);
        usuariosParaCargar.add(usuario2);
        //calcularPuntosDeConfianzaUsuarios();

        //calcularGradosDeConfianzaUsuarios();
        //calcularGradosDeConfianzaComunidades();

        MainApi.guardarUsuariosIntoDB(usuariosParaCargar);
        //guardarComunidadesIntoDB();
        //guardarUsuariosIntoDB(usuarios);

    }

}
