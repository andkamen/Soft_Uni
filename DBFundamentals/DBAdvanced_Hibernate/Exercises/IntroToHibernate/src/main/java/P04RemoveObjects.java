import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class P04RemoveObjects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        Query nativeQuery = em.createNativeQuery("SELECT * FROM towns AS t WHERE LENGTH(t.name) > 5");
//        List<Object[]> towns = nativeQuery.getResultList();
//
//        for (Object[] object : towns) {
//            int pk = (int) object[0];
//            Town town = em.find(Town.class,pk);
//            em.detach(town);
//            System.out.println(town.getName());
//        }

        Query jpqlQuery = em.createQuery("SELECT t FROM Town AS t ");
        List<Town> towns = jpqlQuery.getResultList();
        for (Town town : towns) {
            if (town.getName().length() > 5) {
                em.detach(town);
            } else {
                town.setName(town.getName().toLowerCase());
                em.persist(town);
                System.out.println(town.getName());
            }
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
