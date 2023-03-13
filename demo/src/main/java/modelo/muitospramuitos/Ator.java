package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atores")
public class Ator {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "ator")
    private List<Filme> filmes = new ArrayList<>();

    
    public Ator() {
    }
    public Ator(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Filme> getFilme() {
        return filmes;
    }
    public void setFilme(List<Filme> filme) {
        this.filmes = filme;
    }

    // public void adicionarAtor(Ator ator){
    //     if (ator != null && !getAtor().contains(ator)) {
    //         getAtor().add(ator);
    //         if (!ator.getFilme().contains(this)) {
    //             ator.getFilme().add(this);
    //         }
    //     }
    // }
}
