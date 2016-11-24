import entities.Employee;
import entities.Town;
import org.hibernate.annotations.SourceType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class P05ContainsEmployees {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String[] input = reader.readLine().split("\\s+");
        String firstName = input[0];
        String lastName = input[1];

        Query query = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName = ? AND e.lastName = ?");
        query.setParameter(0, firstName);
        query.setParameter(1, lastName);

        try {
            Employee employee = (Employee) query.getSingleResult();
            System.out.println(employee.getFirstName());

        } catch (javax.persistence.NoResultException nre) {
            System.out.println("No");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
