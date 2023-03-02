package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Veiculo;

public class NovoVeiculo {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        Veiculo novoVeiculo = new Veiculo("Rosa Choque", false);
        
        em.getTransaction().begin();
        em.persist(novoVeiculo);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
