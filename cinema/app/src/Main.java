import mock.MockCinema;
import model.*;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Cinema cinema = MockCinema.cinema();

        int opcao = 0;
        while (opcao != 6) {
            opcao = menu.showMenu();
            switch (opcao) {
                case 1:
                    try {
                        menu.showVendasIngresso(cinema);
                    } catch (Exception e) {
                        System.out.println("ESSE LUGAR JÁ ESTÁ OCUPADO. REPETIR OPERAÇÃO.");
                    }
                    break;
                case 2:
                   menu.showGerenciamentoFilme(cinema);
                    break;
                case 3:
                    menu.showSala(cinema);
                    break;
                case 4:
                    menu.showAtendente(cinema);
                    break;
                case 5:
                    menu.showFinanceiro(cinema);
                    break;
                case 7:
                    for (Reserva reserva : cinema.getReservas()) {
                        System.out.println(reserva);
                    }
                    break;
            }
        }
    }
}
