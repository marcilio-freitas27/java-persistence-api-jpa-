package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
    
    public static void main(String[] args) {
        

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager(); 

        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, 1L);

        /*removendo do estado gerenciavel
          fora de uma processo de transação 
          como find que o leva para o estado gerenciavel
        */
        em.detach(usuario);

        usuario.setNome("Teste");
        em.merge(usuario);

        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
