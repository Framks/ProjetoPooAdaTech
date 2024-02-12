package Models;

import java.util.ArrayList;

public class Filme {
    private Integer clasificacao;
    private String nome;
    private ArrayList<Ator> atores;
    private ArrayList<Diretor> diretores;
    private String Descricao;
    private Integer anoLancamento;
    private ArrayList<String> genero;
    private Integer duracao;

    public Filme(){
        this.atores= new ArrayList<Ator>();
        this.diretores = new ArrayList<Diretor>();
        this.genero = new ArrayList<String>();
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Integer getClasificacao() {
        return clasificacao;
    }

    public void setClasificacao(Integer clasificacao) {
        this.clasificacao = clasificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
