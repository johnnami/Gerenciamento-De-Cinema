package mock;

import enums.TipoSala;
import model.Atendente;
import model.Cinema;
import model.Filme;
import model.Sala;

import java.time.LocalDateTime;

public class MockCinema {
    public static Cinema cinema() {
        Cinema cinema = new Cinema("DevHouse Cine");

        Atendente atendente1 = new Atendente(100l, "Maria");

        cinema.addAtendente(atendente1);
        cinema.addAtendente(new Atendente(101l, "Bruna"));

        Sala sala1 = new Sala(1, TipoSala.INDIVIDUAIS, 20, 10);
        Sala sala2 = new Sala(2, TipoSala.DUPLOS, 20, 4);

        Filme filme1 = new Filme();
        filme1.setId(1l);
        filme1.setTitulo("A volta dos que não foram");
        filme1.setSinopse("Foram e não voltaram");
        filme1.setGenero("Acharam que foram mas ficaram");
        filme1.setAnoLancamento(2010);
        filme1.setAtendente(atendente1);

        filme1.addSala(sala1, "17h");
        filme1.addSala(sala1, "19h30");
        filme1.addSala(sala1, "22h");
        filme1.addSala(sala2, "17h");
        filme1.addSala(sala2, "19h30");
        filme1.addSala(sala2, "22h");

        Filme filme2 = new Filme();
        filme2.setId(2l);
        filme2.setTitulo("DevHouse");
        filme2.setSinopse("Só os brabos");
        filme2.setGenero("Comunidade");
        filme2.setAnoLancamento(2021);
        filme2.setAtendente(atendente1);


        filme2.addSala(sala1, "17h");
        filme2.addSala(sala1, "19h30");
        filme2.addSala(sala1, "22h");
        filme2.addSala(sala2, "17h");
        filme2.addSala(sala2, "19h30");
        filme2.addSala(sala2, "22h");

        cinema.addSala(sala1);
        cinema.addSala(sala2);

        cinema.addFilme(filme1);
        cinema.addFilme(filme2);

        return cinema;
    }
}
