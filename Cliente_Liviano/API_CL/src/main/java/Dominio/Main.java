package Dominio;

import Dominio.Utils.BDUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        //JPQL Query
        List<Comunidad> comunidades = em
                // equivalente a: select * from persona where persona.nombre = 'Julian'
                .createQuery("select c.nombre FROM Comunidad c") //ojo, query no tipada
                .getResultList();

        System.out.println(comunidades);

        BDUtils.commit(em);
    }
}
