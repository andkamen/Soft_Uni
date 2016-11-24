import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class P06DataRefresh {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = em.find(Employee.class,4);
        employee.setFirstName(employee.getFirstName().toUpperCase());

        //em.refresh(employee);
        em.persist(employee);

        System.out.println(em.find(Employee.class,4).getFirstName());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
