import Utils.BDUtils;
import javax.persistence.EntityManager;
public class Main {
    public static void main(String[] args) {
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);
        // Transacciones
        BDUtils.commit(em);
    }
}
