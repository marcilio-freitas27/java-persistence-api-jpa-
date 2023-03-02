package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chassi;
    private String cor;
    private boolean temPortas;
    
    public Veiculo(Long chassi) {
        this.chassi = chassi;
    }

    public Veiculo() {
    }

    public Veiculo(String cor, boolean temPortas) {
        this.cor = cor;
        this.temPortas = temPortas;
    }

    public Long getChassi() {
        return chassi;
    }

    public void setChassi(Long chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isTemPortas() {
        return temPortas;
    }

    public void setTemPortas(boolean temPortas) {
        this.temPortas = temPortas;
    }

}
