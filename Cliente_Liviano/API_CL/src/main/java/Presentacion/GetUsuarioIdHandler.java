package Presentacion;

import Dominio.Usuario;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public class GetUsuarioIdHandler implements Handler  {

    private final Usuario repoUsuario;

    @Override
    public void handle(@NotNull Context context) throws Exception {

    }

    public GetUsuarioIdHandler(long id) {
        Session session = Utils.BDUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT id, puntosConfianza, activo, nombre, email, contrasenia FROM usuario WHERE id = :id");
            query.setParameter("id", id);
            Object[] row = (Object[]) query.getSingleResult();

            Usuario usuario = new Usuario(
                    Long.parseLong(row[0].toString()),
                    Float.parseFloat(row[1].toString()),
                    Boolean.parseBoolean(row[2].toString()),
                    row[3].toString(),
                    row[4].toString(),
                    row[5].toString()
            );
            tx.commit();
            this.repoUsuario =  usuario;
        } catch (NoResultException e) {
            tx.rollback();
            throw new RuntimeException("No se encontró ningun usuario con el ID especificado: " + id);
        } finally {
            session.close();
        }
    }
}


