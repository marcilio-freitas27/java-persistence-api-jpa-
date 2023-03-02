package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {

    public static void main(String[] args) {
        //INSERT INTO `clientes`(`nome`, `assento_id`) VALUES ('Daniel', 1);
        // Assento já atribuido a cliente: entrada duplicada, restrição funcionando
        Assento assento = new Assento("C4");
        Cliente cliente = new Cliente("Daniel", assento);
        DAO<Object> dao = new DAO<>();

        dao.abrirTransacao()
            .incluirTransacao(assento)
            .incluirTransacao(cliente)
            .fecharTransacao()
            .fechar();   
    }

}
