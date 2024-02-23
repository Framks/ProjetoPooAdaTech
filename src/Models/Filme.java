package Models;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private Long id;
    private String nome;
    private String descricao;
    private Integer anoLancamento;
    private Integer clasificacao;
    private List<Ator> atores;
    private List<Diretor> diretores;

    public Filme(){
        this.atores= new ArrayList<Ator>();
        this.diretores = new ArrayList<Diretor>();
    }

    public Filme(String nome,
                 String descricao,
                 Integer anoLancamento,
                 Integer clasificacao,
                 List<Ator> atores,
                 List<Diretor> diretores){
        this.nome = nome;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
        this.clasificacao = clasificacao;
        this.atores = atores;
        this.diretores = diretores;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public void addAtor(Ator ator){
        this.atores.add(ator);
    }

    public void addDiretor(Diretor diretor){
        this.diretores.add(diretor);
    }

    @Override
    public boolean equals(Object object){
        if (object == null)
            return false;
        if (object.getClass() == this.getClass()){
            Filme n = (Filme) object;
            if (this.nome == n.getNome())
                if (this.anoLancamento == n.getAnoLancamento())
                    return true;

            return false;
        }else {
            return false;
        }
    }

    @Override
    public String toString(){
        String tostring = "Id: "+id+", Nome: "+nome+", classificação: "+clasificacao+", Descrição: "+descricao+", Ano Lançamento: "+anoLancamento+",\nDiretores: \n";
        if (diretores == null)
            tostring += "sem diretores\n";
        for (Diretor d: diretores){
            tostring += d.toString()+"\n";
        }
        tostring += "Atores: \n";
        if (atores == null)
            tostring += "Sem atores";
        for (Ator a: atores){
            tostring += a.toString()+"\n";
        }
        return tostring;
    }
}
