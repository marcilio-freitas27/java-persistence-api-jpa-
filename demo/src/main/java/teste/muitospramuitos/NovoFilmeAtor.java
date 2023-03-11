package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {

    public static void main(String[] args) {

        Filme filme1 = new Filme("Velozes e furiosos");
        Filme filme2 = new Filme("Os Eternos");

        Ator ator1 = new Ator("John Travolta");
        Ator ator2 = new Ator("Vin Diesel");

        ator1.getFilme().add(filme1);
        ator1.getFilme().add(filme2);
        ator2.getFilme().add(filme1);
        ator2.getFilme().add(filme2);

        ator1.getFilme().add(filme1);
        ator1.getFilme().add(filme2);
        ator2.getFilme().add(filme1);
        ator2.getFilme().add(filme2);

        DAO<Object> dao = new DAO<>();
        dao.abrirTransacao()
            .incluirTransacao(ator1)
            .incluirTransacao(ator2)
            .incluirTransacao(filme1)
            .incluirTransacao(filme2)
            .fecharTransacao()
            .fechar();
    }
}
