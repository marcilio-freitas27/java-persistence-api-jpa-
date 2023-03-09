package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {
    
    public static void main(String[] args) {
         
        Tio tia1 = new Tio("Maria");
        Tio tia2 = new Tio("Josefa");

        Sobrinho sobrinho1 = new Sobrinho("Ana");
        Sobrinho sobrinho2 = new Sobrinho("Junior");

        tia1.getSobrinho().add(sobrinho1);
        tia1.getSobrinho().add(sobrinho2);
        tia2.getSobrinho().add(sobrinho1);
        tia2.getSobrinho().add(sobrinho2);

        sobrinho1.getTio().add(tia1);
        sobrinho1.getTio().add(tia2);
        sobrinho2.getTio().add(tia1);
        sobrinho2.getTio().add(tia2);

        DAO<Object> dao = new DAO<>();
        dao.abrirTransacao()
            .incluirTransacao(tia1)
            .incluirTransacao(tia2)
            .incluirTransacao(sobrinho1)
            .incluirTransacao(sobrinho2)
            .fecharTransacao()
            .fechar();
    }
}
