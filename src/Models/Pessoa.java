package Models;

import java.util.Date;

public class Pessoa {
    private Long id;
    private String nome;
    private Date dataNascimento;

    public Pessoa(Long id, String nome, Date dataNascimento){
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.id = id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
}
