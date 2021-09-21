package view;

import model.Reserva;
import model.SalaFilme;

import java.util.List;

public class AssentosView {

    public static void printAssentos(SalaFilme salaFilme, List<Reserva> reservas) {
        for (int fileira = 1; fileira <= salaFilme.getSala().getQuantidadeFileiras(); fileira++) {
            System.out.print("Fileira: " + fileira + " Assentos: [");
            for (int numero = 1; numero <= salaFilme.getSala().getQuantidadeAssentos(); numero++) {
                if (reservas.contains(new Reserva(salaFilme, fileira, numero))) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" " + numero + " ");
                }
            }
            System.out.print("]");
            System.out.println("");
        }
    }
}