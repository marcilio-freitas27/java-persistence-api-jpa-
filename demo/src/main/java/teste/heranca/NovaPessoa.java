package teste.heranca;

import infra.DAO;
import modelo.heranca.Pessoa;
import modelo.heranca.PessoaFisica;
import modelo.heranca.PessoaJuridica;

public class NovaPessoa {
    
    public static void main(String[] args) {
        
        DAO<Pessoa> dao = new DAO<>();

        Pessoa pessoa = new Pessoa(1L, "fulano", "F");
        Pessoa pessoa2 = new Pessoa(2L, "beltrano", "J");
        PessoaFisica pessoaf = new PessoaFisica(1L,  "12345678901");
        PessoaJuridica pessoaj = new PessoaJuridica(2L, "12345678901234");
        
        dao.incluirAtomico(pessoa);
        dao.incluirAtomico(pessoa2);
        dao.incluirAtomico(pessoaf);
        dao.incluirAtomico(pessoaj);

        dao.fechar();
    }
}
