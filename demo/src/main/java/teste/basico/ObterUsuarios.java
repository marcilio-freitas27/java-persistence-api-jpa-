package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {

    public static void main(String[] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        // linguagem sql do jpa
        String jpql = "SELECT u FROM Usuario u";
        // refletion - verificar a sintaxe dos dados
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        // limitar a consulta da query a 5 
        query.setMaxResults(5);
        // query.setFirstResult(0)
        //Lista de dados
        List<Usuario> usuarios = query.getResultList();

        for(Usuario usuario : usuarios){
            System.out.println("ID: " + usuario.getId()
                + "E-mail: " + usuario.getEmail());
        }

        em.close();
        emf.close();
    }
}

