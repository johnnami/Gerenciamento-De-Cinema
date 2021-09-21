package model;

import java.util.Objects;

public class Reserva {

    private Integer numeroSala;
    private Long idFilme;
    private float valor;


    private String nomeCliente;
    private String horario;
    private Integer fileira;
    private Integer numero;

    public Reserva(Integer numeroSala, Long idFilme, float valor, String nomeCliente, String horario, Integer fileira, Integer numero) {
        this.numeroSala = numeroSala;
        this.idFilme = idFilme;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.horario = horario;
        this.fileira = fileira;
        this.numero = numero;
    }

    public Reserva(SalaFilme salaFilme, Integer fileira, Integer numero) {
        this.numeroSala = salaFilme.getSala().getNumero();
        this.horario = salaFilme.getHorario();
        this.fileira = fileira;
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return numeroSala.equals(reserva.numeroSala) && horario.equals(reserva.horario) && fileira.equals(reserva.fileira) && numero.equals(reserva.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroSala, horario, fileira, numero);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numeroSala=" + numeroSala +
                ", idFilme=" + idFilme +
                ", valor=" + valor +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", horario='" + horario + '\'' +
                ", fileira=" + fileira +
                ", numero=" + numero +
                '}';
    }

    public float getValor() {
        return valor;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getHorario() {
        return horario;
    }

    public Integer getFileira() {
        return fileira;
    }

    public Integer getNumero() {
        return numero;
    }
}
