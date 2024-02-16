package Services;

import Models.Ator;
import Models.Diretor;
import Models.Filme;
import Repositorys.FilmeRepository;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {
    private FilmeRepository filmeRepository;
    private Long proximoId;

    public FilmeService(){
        filmeRepository = new FilmeRepository();
        proximoId = Long.valueOf(0);
    }

    public boolean create(Filme filme){
        filme.setId(proximoId);
        proximoId++;
        return this.filmeRepository.create(filme);
    }

    public boolean delete(Long id){
        return this.filmeRepository.delete(id);
    }

    public Filme findById(Long id){
        return this.filmeRepository.findById(id);
    }

    public List<Filme> findByName(String nome){
        List<Filme> filmes = this.filmeRepository.findAll();
        List<Filme> filmesSeleionado = new ArrayList<Filme>();
        for (Filme f : filmes){
            if (f.getNome().toLowerCase().contains(nome.toLowerCase()))
                filmesSeleionado.add(f);
        }
        return filmesSeleionado;
    }

    public List<Filme> findAll(){
        return this.filmeRepository.findAll();
    }

    public void addAtorFilme(Long idFilme, Ator ator){
        Filme filme = findById(idFilme);
        filme.addAtor(ator);
    }

    public void addDiretorFilme(Long id, Diretor diretor){
        Filme filme = findById(id);
        filme.addDiretor(diretor);
    }

    public List<Ator> findAtorById_filme(Long id){
        Filme filme = this.filmeRepository.findById(id);
        return filme.getAtores();
    }

    public List<Diretor> findDiretorById_filme(Long id){
        Filme filme = this.filmeRepository.findById(id);
        return filme.getDiretores();
    }
}
