package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
    
    // Criar este para apenas um banco de dados
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    // será carregado quando a classe for iniciada
    static {
        //tratamento de erro
        try {
            emf = Persistence.createEntityManagerFactory("demo");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public DAO(){
        this(null);
    }

    public DAO(Class<E> classe){
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirTransacao(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransacao(){
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluirTransacao(E entidade){
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade){
        return this.abrirTransacao().incluirTransacao(entidade).fecharTransacao();
    }

    public E obterPorId(Object id){
        return em.find(classe, id);
    }

    public List<E> obterTodos(){
        return this.obterTodos(10, 0);
    }

    // limit e offset
    public List<E> obterTodos(int qtde, int deslocamento){
        if(classe == null){
            //exceção
            throw new UnsupportedOperationException("Classe nula.");
        };

        //consulta
        String jpql = "SELECT e FROM " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();

    }

    public List<E> consultar(String nomeConsulta, Object... params){
        TypedQuery<E> query = em.createQuery(nomeConsulta, classe);

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(),  params[i + 1]);
        }
        return query.getResultList();
    }

    public void fechar(){
        // fechar conexão
        em.close();
    }
}
