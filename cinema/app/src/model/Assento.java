package model;

import java.util.Objects;

public class Assento {

    private Integer fileira;
    private Integer numero;

    public Assento(Integer fileira, Integer numero) {
        this.fileira = fileira;
        this.numero = numero;
    }

    public Integer getFileira() {
        return fileira;
    }

    public void setFileira(Integer fileira) {
        this.fileira = fileira;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assento)) return false;
        Assento assento = (Assento) o;
        return fileira.equals(assento.fileira) && numero.equals(assento.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileira, numero);
    }

}
