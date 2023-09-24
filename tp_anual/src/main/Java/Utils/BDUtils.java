package Utils;

import javax.persistence.*;

public class BDUtils {
    private static final EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("TP-anual-g8");
    }

    public static EntityManager getEntityManager() {
        EntityManager em = factory.createEntityManager();
        return em;
    }

    public static void comenzarTransaccion(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        if(!tx.isActive()) {
            tx.begin();
        }
    }

    public static void commit(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        if(tx.isActive()) {
            tx.commit();
        }
    }

    public static void rollback(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        if(tx.isActive()) {
            tx.rollback();
        }
    }
}
