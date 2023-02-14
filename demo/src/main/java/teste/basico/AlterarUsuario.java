package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario {
    
    public static void main(String[] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        //iniciar uma transação
        em.getTransaction().begin();

        //consultar o usuário na tabela
        Usuario usuario = em.find(Usuario.class, 1L);

        // alterar os campos
        usuario.setNome("Leo");
        usuario.setEmail("leo@email.com");

        //fazer a persistencia alterando o que foi encontrado na tabela
        em.merge(usuario);

        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
     
}
