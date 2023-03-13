package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany
    // padronizar nome da tabela de relacionamento - mapeamento
    @JoinTable(
        name = "atores_filmes",
        joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id")
    )
    private List<Ator> atores = new ArrayList<>();

    public Filme() {

    }
    
    public Filme(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Ator> getAtor() {
        if (atores == null) {
            atores = new ArrayList<>();
        }
        return atores;
    }
    public void setAtor(List<Ator> ator) {
        this.atores = ator;
    }

    public void adicionarAtor(Ator ator){
        //verifica se não está nulo e se contem o autor
        if (ator != null && !getAtor().contains(ator)) {
            getAtor().add(ator);
            if (!ator.getFilme().contains(this)) {
                ator.getFilme().add(this);
            }
        }
    }
}
