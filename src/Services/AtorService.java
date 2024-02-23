package Services;

import Models.Ator;
import Services.exceptionSevices.ActorException;
import infra.Repositorys.AtorRepository;
import infra.Repositorys.FilmeRepository;

import java.util.List;

public class AtorService {
    final private AtorRepository atorRepository;
    final private FilmeRepository filmeRepository;

    public AtorService(AtorRepository atorRepository, FilmeRepository filmeRepository){
        this.atorRepository = atorRepository;
        this.filmeRepository = filmeRepository;
    }

    public Ator findByID(Long id){
        if (id == null)
            throw new ActorException("Id nullo");
        return (Ator) this.atorRepository.buscarPorId(id);
    }
    public Ator findByNome(String nome){
        if (nome != null)
            return this.atorRepository.procurarPorNome(nome);
        throw new ActorException("nome nullo");
    }

    public void create(Ator newAtor){
        if (newAtor == null)
            throw new ActorException("nome nulo");
        if (newAtor.getNome() == null)
            throw new ActorException("data nula");
        this.atorRepository.gravar(newAtor);
    }

    public boolean delete(Long id){
        if (id == null)
            throw new ActorException("Id nulo");
        Ator ator = (Ator) this.atorRepository.buscarPorId(id);
        return this.atorRepository.excluir(ator);
    }

    public List findAll(){
        return this.atorRepository.listar();
    }

    public List procurarFilmesDeAtor(Long id){
        if (id == null)
            throw new ActorException("Id nulo");
        Ator ator = (Ator) this.atorRepository.buscarPorId(id);
        if (ator == null)
            throw new ActorException("Ator não encontrado");
        List filmes = this.filmeRepository.procurarPorAtor(ator);
        return filmes;
    }

}
