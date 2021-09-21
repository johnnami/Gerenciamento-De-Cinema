package model;

import enums.TipoSala;

import java.util.ArrayList;
import java.util.List;

public class Sala {

    private Integer numero;
    private TipoSala tipo;
    private int quantidadeAssentos;
    private int quantidadeFileiras;

    public Sala() { }

    public Sala(Integer numero, TipoSala tipo, int quantidadeFileiras, int quantidadeAssentos) {
        this.numero = numero;
        this.tipo = tipo;
        this.quantidadeFileiras = quantidadeFileiras;
        this.quantidadeAssentos = quantidadeAssentos;

    }


    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    public void setQuantidadeAssentos(int quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public void setQuantidadeFileiras(int quantidadeFileiras) {
        this.quantidadeFileiras = quantidadeFileiras;
    }

    public Integer getNumero() {
        return numero;
    }

    public int getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public int getQuantidadeFileiras() {
        return quantidadeFileiras;
    }

}
