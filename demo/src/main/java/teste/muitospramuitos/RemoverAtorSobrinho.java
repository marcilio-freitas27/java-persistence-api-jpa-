package teste.muitospramuitos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class RemoverAtorSobrinho {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        Ator ator1 = em.find(Ator.class, 3L);
        Ator ator2 = em.find(Ator.class, 4L);

        Filme filme1 = em.find(Filme.class, 3L);
        Filme filme2 = em.find(Filme.class, 4L);

        Object[] filmeAtor = {ator1, ator2, filme1, filme2};

        for (Object object : filmeAtor) {
            if (object != null) {
                em.getTransaction().begin();
                em.remove(object);
                em.getTransaction().commit();
            }
        }

        emf.close();
        em.close();
    }
}
