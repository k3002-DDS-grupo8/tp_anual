package Dominio;

import Dominio.Utils.BDUtils;
import Dominio.comunidad.Comunidad;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        //JPQL Query
        List<Comunidad> comunidades = em.createQuery("select c.nombre FROM Comunidad c").getResultList(); //ojo, query no tipada
                // equivalente a: select * from persona where persona.nombre = 'Julian'



        System.out.println(comunidades);

        BDUtils.commit(em);
    }
}
