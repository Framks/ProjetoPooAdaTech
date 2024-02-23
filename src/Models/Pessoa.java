package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
    private String nome;
    private Date dataNascimento;
    private Long id;

    public Pessoa( String nome, Date dataNascimento){
        this.dataNascimento = dataNascimento;
        this.nome = nome;
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

    @Override
    public String toString(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Id: "+this.id+", Nome: "+this.nome+", Data de Nascimento: "+ formato.format(this.dataNascimento);
    }

    public void setId(Long proximoId) {
        this.id = proximoId;
    }
}
