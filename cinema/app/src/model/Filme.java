package model;

import util.GeneratorUtils;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    private Long id;
    private String titulo;
    private String elenco;
    private Integer anoLancamento;
    private String sinopse;
    private String genero;

    private Atendente atendente;

    private List<SalaFilme> salas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public List<SalaFilme> getSalas() {
        return salas;
    }


    public void addSala(Sala sala, String horario) {
        if (this.salas == null) {
            this.salas = new ArrayList();
        }
        this.salas.add(new SalaFilme(GeneratorUtils.randomLong(), sala, horario));
    }

    public SalaFilme getSalaById(Long id) {
        return this.salas.stream()
                .filter(sala -> sala.getCodigo().equals(id))
                .findFirst()
                .orElseThrow();
    }

}
