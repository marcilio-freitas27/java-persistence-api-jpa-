package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
    public static void main(String[] args) {

        // cria o entity manager
        // recebe informações para conexão com o banco
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        
        // gerencia a persitência no banco de dados
        EntityManager em = emf.createEntityManager();

        Usuario novoUsuario = new Usuario("Djama", "djlam@lanche.com");
        // novoUsuario.setId(1L);
        // persistir a informação
        em.getTransaction().begin();
        em.persist(novoUsuario);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
