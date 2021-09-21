package model;

public class SalaFilme {

    private Long codigo;
    private Sala sala;
    private String horario;

    public SalaFilme(Long codigo, Sala sala, String horario) {
        this.codigo = codigo;
        this.sala = sala;
        this.horario = horario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Sala getSala() {
        return sala;
    }

    public String getHorario() {
        return horario;
    }

}
