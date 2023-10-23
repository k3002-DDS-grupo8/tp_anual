import Utils.BDUtils;
import Dominio.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.*;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class MainApi {

    public ArrayList<Usuario> obtenerUsuarios() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, puntosConfianza, gradoConfianza, activo FROM usuario");
            List<Object[]> rows = query.getResultList();
            ArrayList<Usuario> usuarios = new ArrayList<>();
            for (Object[] row : rows) {
                Usuario usuario = new Usuario();
                usuario.setId(Long.parseLong(row[0].toString()));
                usuario.setPuntosConfianza(Float.parseFloat(row[1].toString()));
                GradoConfianza gradoConfianzaEnum = GradoConfianza.valueOf(row[2].toString());
                usuario.setGradoConfianza(gradoConfianzaEnum);
                usuario.setActivo(Boolean.parseBoolean(row[3].toString()));
                usuarios.add(usuario);
            }
            tx.commit();
            return usuarios;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public ArrayList<Incidente> obtenerIncidentes() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT comunidad, servicio, horarioDeApertura, horarioDeCierre, id FROM incidente");
            List<Object[]> rows = query.getResultList();
            ArrayList<Incidente> incidentes = new ArrayList<>();
            for (Object[] row : rows) {
                Incidente incidente = new Incidente();
                incidente.setIdComunidad(Long.parseLong(row[0].toString()));
                incidente.setIdServicio(Long.parseLong(row[1].toString()));
                incidente.setHorarioDeApertura(LocalDateTime.parse(row[2].toString()));
                incidente.setHorarioDeCierre(LocalDateTime.parse(row[3].toString()));
                incidente.setId(Long.parseLong(row[4].toString()));
                incidentes.add(incidente);
            }
            tx.commit();
            return incidentes;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Usuario obtenerUsuario(long id) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, puntosConfianza, gradoConfianza, activo FROM usuario WHERE id = :id");
            query.setParameter("id", id);
            Object[] row = (Object[]) query.getSingleResult();
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setPuntosConfianza(Float.parseFloat(row[1].toString()));
            GradoConfianza gradoConfianzaEnum = GradoConfianza.valueOf(row[2].toString());
            usuario.setGradoConfianza(gradoConfianzaEnum);
            usuario.setActivo(Boolean.parseBoolean(row[3].toString()));
            tx.commit();
            return usuario;
        } catch (NoResultException e) {
            tx.rollback();
            throw new RuntimeException("No se encontró ningun usuario con el ID especificado: " + id);
        } finally {
            session.close();
        }
    }

    public ArrayList<Comunidad> obtenerComunidades() {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, gradoConfianza, activo FROM comunidad");
            List<Object[]> rows = query.getResultList();
            ArrayList<Comunidad> comunidades = new ArrayList<>();
            for (Object[] row : rows) {
                Comunidad comunidad = new Comunidad();
                comunidad.setId(Long.parseLong(row[0].toString()));
                GradoConfianza gradoConfianzaEnum = GradoConfianza.valueOf(row[1].toString());
                comunidad.setGradoConfianza(gradoConfianzaEnum);
                comunidad.setActivo(Boolean.parseBoolean(row[2].toString()));
                comunidades.add(comunidad);
            }
            tx.commit();
            return comunidades;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Comunidad obtenerComunidad(long id) {
        Session session = BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, gradoConfianza, activo FROM comunidad WHERE id = :id");
            query.setParameter("id", id);
            Object[] row = (Object[]) query.getSingleResult();
            Comunidad comunidad = new Comunidad();
            comunidad.setId(id);
            GradoConfianza gradoConfianzaEnum = GradoConfianza.valueOf(row[1].toString());
            comunidad.setGradoConfianza(gradoConfianzaEnum);
            comunidad.setActivo(Boolean.parseBoolean(row[2].toString()));
            tx.commit();
            return comunidad;
        } catch (NoResultException e) {
            tx.rollback();
            throw new RuntimeException("No se encontró ninguna comunidad con el ID especificado: " + id);
        } finally {
            session.close();
        }
    }

    public static void guardarUsuariosIntoDB(ArrayList<Usuario> usuariosParaGuardar) {
        Session session = Utils.BDUtils.getSessionFactory().openSession();
        Transaction txPersona = session.beginTransaction();
        try {
            for(Usuario usuarioParaGuardar : usuariosParaGuardar) {
                org.hibernate.query.Query sqlQuery = session.createSQLQuery(String.format("INSERT INTO usuario VALUES ('%s','%s',%s,%s,'%s',%s)",
                                usuarioParaGuardar.getNombre(),
                                usuarioParaGuardar.getEmail(), null,
                                // usuarioParaGuardar.getComunidades(),
                                usuarioParaGuardar.getPuntosConfianza(),
                                usuarioParaGuardar.getGradoConfianza(),
                                usuarioParaGuardar.isActivo()
                        )
                );
                sqlQuery.executeUpdate();
            }
            txPersona.commit();
        } catch (Exception e) {
            txPersona.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    public static void guardarComunidadesIntoDB(ArrayList<Comunidad> comunidadesParaGuardar) {
        Session session = Utils.BDUtils.getSessionFactory().openSession();
        Transaction txPersona = session.beginTransaction();
        try {
            for(Comunidad comunidadParaGuardar : comunidadesParaGuardar) {
                org.hibernate.query.Query sqlQuery = session.createSQLQuery(String.format("INSERT INTO comunidad VALUES ('%s','%s',%s,%s,'%s',%s)",
                                comunidadParaGuardar.getNombre(),
                                comunidadParaGuardar.getGradoConfianza(),
                                comunidadParaGuardar.isActivo()
                        )
                );
                sqlQuery.executeUpdate();
            }
            txPersona.commit();
        } catch (Exception e) {
            txPersona.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}