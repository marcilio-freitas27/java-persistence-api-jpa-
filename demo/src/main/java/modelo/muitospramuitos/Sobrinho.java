package modelo.muitospramuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Sobrinho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "sobrinho")
    private List<Tio> tio = new ArrayList<Tio>();


    public Sobrinho(String nome) {
        this.nome = nome;
    }

    public Sobrinho() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tio> getTio() {
        return tio;
    }

    public void setTio(List<Tio> tio) {
        this.tio = tio;
    }

}
