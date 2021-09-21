package view;

import enums.TipoSala;
import model.*;

import java.util.Scanner;

public class Menu {

    public int showMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("1 - Vendas de Ingressos");
        System.out.println("2 - Gerenciamento de Filmes");
        System.out.println("3 - Gerenciamento de Salas");
        System.out.println("4 - Gerenciamento de Atendentes");
        System.out.println("5 - Financeiro");
        System.out.println("6 - Sair");
        System.out.println("7 - Reservas");
        System.out.println("------------------------------------------------------------");
        System.out.print("Opção: ");
        return new Scanner(System.in).nextInt();
    }

    public void showVendasIngresso(Cinema cinema) throws Exception {
        System.out.println("Selecione abaixo um dos filmes disponíveis:");
        for(Filme filme: cinema.getFilmes()) {
            System.out.println(filme.getId() + " - " + filme.getTitulo());
        }
        System.out.println("------------------------------------------------------------");
        System.out.print("Código do filme: ");
        long idFilme = new Scanner(System.in).nextLong();

        Filme filme = cinema.getFilmeById(idFilme);

        System.out.println("Selecione abaixo uma das salas e os horários disponíveis:");
        for(SalaFilme salaFilme: filme.getSalas()) {
            System.out.println("Código: " + salaFilme.getCodigo() + ", Sala: " + salaFilme.getSala().getNumero() + " - " + salaFilme.getHorario());
        }
        System.out.println("------------------------------------------------------------");
        System.out.print("Código da Sala: ");
        long codigoSala = new Scanner(System.in).nextLong();

        SalaFilme salaFilme = filme.getSalaById(codigoSala);
        AssentosView.printAssentos(salaFilme, cinema.getReservas());

        System.out.print("Fileira: ");
        int fileira = new Scanner(System.in).nextInt();

        System.out.print("Assento: ");
        int lugar = new Scanner(System.in).nextInt();

        System.out.print("Valor a pagar: ");
        float valor = new Scanner(System.in).nextFloat();

        System.out.print("Nome do cliente: ");
        String cliente = new Scanner(System.in).next();

        cinema.addReserva(new Reserva(salaFilme.getSala().getNumero(), filme.getId(), valor, cliente, salaFilme.getHorario(), fileira, lugar));

        System.out.println("------------------------------------------------------------");
        System.out.println("Compra efetuada com sucesso!!");

    }

    public void showGerenciamentoFilme (Cinema cinema){
        try {
            if (cinema.getFilmes().size() > 3) {
                throw new Exception();
            }

            Filme filme = new Filme();

            System.out.println("Vamos cadastrar o filme");
            System.out.println("Informe o ID: ");
            long id = new Scanner(System.in).nextLong();

            if (cinema.existsById(id)) {
                System.out.println("Esse ID já existe, cadastre outro.");
                System.out.println("Informe o ID: ");
                filme.setId(new Scanner(System.in).nextLong());
            } else {
                filme.setId(id);
            }

            System.out.println("Informe o Titulo: ");
            filme.setTitulo(new Scanner(System.in).nextLine());

            System.out.println("Informe o Ano de Lançamento: ");
            filme.setAnoLancamento(new Scanner(System.in).nextInt());
            System.out.println("Informe a Sinopse: ");
            filme.setSinopse(new Scanner(System.in).nextLine());

            System.out.println("Informe o Genero: ");
            filme.setGenero(new Scanner(System.in).nextLine());

            System.out.println("Informe o Elenco: ");
            filme.setElenco(new Scanner(System.in).nextLine());

            System.out.println("Escolha uma das salas abaixo: ");
            for(Sala s:cinema.getSalas()){
                System.out.println("Sala: " + s.getNumero());
            }

            int salaOption = new Scanner(System.in).nextInt();
            System.out.println("Informe o horario de exibição: ");
            String horario = new Scanner(System.in).nextLine();
            filme.addSala(cinema.getSalaByNumero(salaOption), horario);

            cinema.addFilme(filme);

        } catch (Exception e) {
            System.out.println("Esse cinema já possui 4 filmes cadastrados, não é possivel cadastrar mais filmes.");
            System.out.println("Digite ok para continuar:");
            new Scanner(System.in).nextLine();
        }
    }

    public void showFinanceiro(Cinema cinema){
        System.out.println("Ingressos comprados: ");
        FinanceiroView.printLucro(cinema);
        double total = cinema.getReservas().stream().mapToDouble(r -> new Double(r.getValor())).sum();
        System.out.println("Total: " + total);
    }


    public void showSala(Cinema cinema){
        Sala sala = new Sala();

        System.out.println("Vamos cadastrar as salas");
        System.out.println("Informe o número da sala");
        sala.setNumero(new Scanner(System.in).nextInt());

        System.out.println("Informe o tipo da sala:");
        System.out.println("1 - Sala Individual");
        System.out.println("2 - Sala Dupla");
        int tipoOption = new Scanner(System.in).nextInt();
        sala.setTipo(tipoOption == 1 ? TipoSala.INDIVIDUAIS : TipoSala.DUPLOS);;

        System.out.println("Quantidade de fileiras: ");
        sala.setQuantidadeFileiras(new Scanner(System.in).nextInt());

        System.out.println("Quantidade de assentos: ");
        sala.setQuantidadeAssentos(new Scanner(System.in).nextInt());
        cinema.addSala(sala);
    }

    public void showAtendente(Cinema cinema){
        Atendente atendente = new Atendente();

        System.out.println("Vamos cadastrar os atendentes");
        System.out.println("Informe o id do atendente: ");
        atendente.setId(new Scanner(System.in).nextLong());

        System.out.println("Informe o nome do atendente: ");
        atendente.setName(new Scanner(System.in).nextLine());
        cinema.addAtendente(atendente);

    }
}
