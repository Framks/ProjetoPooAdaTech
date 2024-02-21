package infra.Repositorys;

import Models.Ator;
import Models.Diretor;
import infra.Db.BancoDados;
import Models.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeRepository extends AbstraticRepository{
    public FilmeRepository(BancoDados bancoDados){
        super(bancoDados);
    }

    @Override
    protected Class classeModelo(){
        return Filme.class;
    }

    public Diretor procurarPorNome(String nome){
        if (nome == null)
            throw new RuntimeException("Nome nullo");
        List diretores = listar();
        if (diretores.isEmpty())
            throw new RuntimeException("sem Diretores");

        for (Object o: diretores){
            Diretor diretor = (Diretor) o;
            if (diretor.getNome().equalsIgnoreCase(nome)){
                return diretor;
            }
        }
        throw new RuntimeException("Diretor não encontrado");
    }

    public Diretor procurarPorId(Long id){
        if (id == null)
            throw new RuntimeException("Faltanto numero de Codigo:");
        List atores = listar();
        if (atores.isEmpty())
            throw new RuntimeException("sem Diretores");
        for (Object o: atores){
            Diretor diretor = (Diretor) o;
            if (diretor.getId()==id){
                return diretor;
            }
        }
        throw new RuntimeException("sem Diretor com esse id");
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
            if (ator != null && filme != null && filme.getDiretores().contains(ator)){
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
