package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuario {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 1L);
        // verificar se não está null
        if (usuario != null) {
            //alterações no banco funcionam apenas em contexto transacional
            // sem o transaction ele faz apenas um select
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }

}
