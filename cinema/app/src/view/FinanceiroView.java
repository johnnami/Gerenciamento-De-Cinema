package view;

import model.Cinema;
import model.Filme;
import model.Reserva;

import java.util.List;

public class FinanceiroView {

    public static void printLucro(Cinema cinema){
        for (Reserva r: cinema.getReservas()){
            Filme f= cinema.getFilmeById(r.getIdFilme());

            System.out.println("Filme: " + f.getTitulo() + ", Cliente: " + r.getNomeCliente() + ", comprou um ingresso no valor de: " + r.getValor());
        }
    }
}
