/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eroshetta;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Mouaz
 */
public class NewClass {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EroshettaPU");
static EntityManager em = emf.createEntityManager();
    public static void main(String[] a) throws Exception {
        
//    EntityManager em = null;
          Doctor docs = new Doctor();
System.out.println("astagforollah");
      em.getTransaction().begin();
//    student.setId(1);
//    docs.setName("Kareema Al3atefya");
//    student.setDateOfBirth(new Date());
//    student.setGender(Gender.FEMALE);
    Query q = em.createNamedQuery("Doctor.findAll");
    List l = q.getResultList();
    System.out.println(l.toString());
    em.merge(docs);
    em.flush();
    
    Doctor st = em.find(Doctor.class, 1);    
    System.out.println(st.getName());
    
    em.getTransaction().commit();

    em.close();
    emf.close();
    }
}
