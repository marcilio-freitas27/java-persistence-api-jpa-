package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {

    public static void main(String[] args) {

        Filme filme1 = new Filme("Velozes e furiosos - O filme", 10.0);
        Filme filme2 = new Filme("Os Eternos", 9.2);

        Ator ator1 = new Ator("The Rock");
        Ator ator2 = new Ator("Vin Diesel");

        filme1.adicionarAtor(ator1);
        filme1.adicionarAtor(ator2);

        filme2.adicionarAtor(ator1);

        DAO<Filme> dao = new DAO<Filme>();
        dao.incluirAtomico(filme1);
    }
}
