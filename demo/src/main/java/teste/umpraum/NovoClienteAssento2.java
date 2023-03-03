package teste.umpraum;
import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {
    public static void main(String[] args) {
        Assento assento = new Assento("C4");
        // não aceita porque não está e modo transiente
        Cliente cliente = new Cliente("Junior", assento);
        DAO<Cliente> dao = new DAO<>(Cliente.class);

        dao.incluirAtomico(cliente);
    }

}

