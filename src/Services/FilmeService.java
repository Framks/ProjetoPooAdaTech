package Services;

import Models.Ator;
import Models.Diretor;
import Models.Filme;
import infra.Repositorys.FilmeRepository;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {
    private FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    public void create(Filme filme){
        if (filme == null)
            throw new RuntimeException("filme não pode ser nulo");
        if (filme.getNome() == null)
            throw new RuntimeException("nome do filme não pode ser nulo");
        if (filme.getDescricao() == null)
            throw new RuntimeException("descrição não pode ser nula");
        if (filme.getClasificacao() == null)
            throw new RuntimeException("a classificação não pode ser nula");
        if (filme.getAnoLancamento() == null)
            throw new RuntimeException("o ano de lançamento não pode ser nulo");
        this.filmeRepository.gravar(filme);
    }

    public boolean delete(Long id){
        if (id == null)
            throw  new RuntimeException("id não pode ser nulo");
        Filme filme = (Filme) this.filmeRepository.buscarPorId(id);
        return this.filmeRepository.excluir(filme);
    }

    public Filme findById(Long id){
        if (id == null)
            throw new RuntimeException("Id não pode ser nulo");
        return (Filme)this.filmeRepository.buscarPorId(id);
    }

    public List findByName(String nome){
        if (nome == null)
            throw new RuntimeException("Nome não pode ser nulo");
        return this.filmeRepository.procurarPorNome(nome);
    }

    public List findAll(){
        return this.filmeRepository.listar();
    }

    public void addAtorFilme(Long idFilme, Ator ator){
        if (idFilme == null)
            throw new RuntimeException("Id do fime não pode esta fazio");
        if (ator == null)
            throw new RuntimeException("ator não pode ser nulo");
        Filme filme = findById(idFilme);
        filme.addAtor(ator);
    }

    public void addDiretorFilme(Long id, Diretor diretor){
        if (id == null)
            throw new RuntimeException("Id do fime não pode esta fazio");
        if (diretor == null)
            throw new RuntimeException("ator não pode ser nulo");
        Filme filme = findById(id);
        filme.addDiretor(diretor);
    }

    public List<Ator> findAtorById_filme(Long id){
        if (id == null)
            throw new RuntimeException("Id não pode ser nulo");
        Filme filme = (Filme) this.filmeRepository.buscarPorId(id);
        return filme.getAtores();
    }

    public List<Diretor> findDiretorById_filme(Long id){
        if (id == null)
            throw new RuntimeException("Id não pode ser nulo");
        Filme filme = (Filme) this.filmeRepository.buscarPorId(id);
        return filme.getDiretores();
    }
}
