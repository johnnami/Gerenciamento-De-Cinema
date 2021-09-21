package model;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private String nome;

    private List<Sala> salas;


    private List<Filme> filmes;
    private List<Atendente> atendentes;
    private List<Reserva> reservas;

    public Cinema(String nome) {
        this.nome = nome;
        this.reservas = new ArrayList();
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void addFilme(Filme filme) {
        if (this.filmes == null) {
            this.filmes = new ArrayList();
        }
        this.filmes.add(filme);
    }

    public void addAtendente(Atendente atendente) {
        if (this.atendentes == null) {
            this.atendentes = new ArrayList();
        }
        this.atendentes.add(atendente);
    }

    public void addSala(Sala sala) {
        if (this.salas == null) {
            this.salas = new ArrayList();
        }
        this.salas.add(sala);
    }

    public void addReserva(Reserva reserva) throws Exception {
        if(this.reservas == null) {
            this.reservas = new ArrayList();
        }

        if(this.reservas.contains(reserva)) {
            throw new Exception();
        }

        this.reservas.add(reserva);
    }

    public Sala getSalaByNumero(Integer numero) {
        return this.salas.stream()
                .filter(sala -> sala.getNumero().equals(numero))
                .findFirst()
                .orElseThrow();
    }

    public Filme getFilmeById(Long id) {
        return this.filmes.stream()
                .filter(filme -> filme.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public boolean existsById(Long id) {
        return this.filmes.stream()
                .anyMatch(filme -> filme.getId().equals(id));
    }

}
