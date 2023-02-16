package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
    

    public static void main(String[] args) {
        

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        //modo gerenciável

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 1L);
        usuario.setNome("Leonardo Dois");

        em.getTransaction().commit();

        emf.close();
        em.close();
    }
}
