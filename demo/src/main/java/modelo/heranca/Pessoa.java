package modelo.heranca;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// herança - tabela simples ou tabela com todos os dados
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// Diz qual o descriminador, seu tamanho e tipo
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
// Diz qual quando o descriminador é identificado, no caso será o P de pessoa
@DiscriminatorValue("P")
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(insertable = false, updatable = false)
    private String tipo;
}
