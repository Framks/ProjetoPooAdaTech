package infra.Repositorys;

import Models.Ator;
import Models.Diretor;
import infra.Db.BancoDados;
import Models.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilmeRepository extends AbstraticRepository{
    public FilmeRepository(BancoDados bancoDados){
        super(bancoDados);
    }

    @Override
    protected Boolean filtrarPorId(Object o, Long id) {
        Filme filme = (Filme) o;
        return Objects.equals(filme.getId(),id);
    }

    @Override
    protected Class classeModelo(){
        return Filme.class;
    }

    public List procurarPorNome(String nome){
        if (nome == null)
            throw new RuntimeException("Nome nullo");
        List filmes = listar();
        if (filmes.isEmpty())
            throw new RuntimeException("sem Diretores");
        List filmesacados = new ArrayList();
        for (Object o: filmes){
            Filme filme = (Filme) o;
            if (filme.getNome().contains(nome)){
                filmesacados.add(filme);
            }
        }
        return filmesacados;
    }

    public List procurarPorDiretor(Diretor diretor){
        List filmes = listar();
        List filmesEcontrados = new ArrayList();
        for (Object o : filmes){
            Filme filme = (Filme) o;
            if (diretor != null && filme != null && filme.getDiretores().contains(diretor)){
                filmesEcontrados.add(filme);
            }
        }
        return filmesEcontrados;
    }

    public List procurarPorAtor(Ator ator){
        List filmes = listar();
        List filmesEcontrados = new ArrayList();
        for (Object o : filmes){
            Filme filme = (Filme) o;
            if (ator != null && filme != null && filme.getAtores().contains(ator)){
                filmesEcontrados.add(filme);
            }
        }
        return filmesEcontrados;
    }

    @Override
    public void gravar(Object o){
        Filme filme = (Filme) o;
        if (filme != null)
            filme.setId(this.bancoDeDados.getProximoId());
        this.bancoDeDados.inserirObjeto(filme);
    }

}
