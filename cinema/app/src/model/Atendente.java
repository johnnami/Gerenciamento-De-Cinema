package model;

public class Atendente {

    private Long id;
    private String name;

    public Atendente(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Atendente() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
