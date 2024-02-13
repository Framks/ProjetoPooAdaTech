package Services;

import Models.Ator;
import Repositorys.AtorRepository;

import java.util.Date;
import java.util.List;

public class AtorService {
    final private AtorRepository atorRepository;
    private Long proximoId;

    public AtorService(){
        this.atorRepository = new AtorRepository();
        this.proximoId = 0L;
    }

    public Ator findById(Long id){
        return this.atorRepository.findById(id);
    }

    public Ator findByNome(String nome){
        List<Ator> atores = findAll();
        for (Ator ator: atores){
            if(ator.getNome().equals(nome)){
                return ator;
            }
        }
        return null;
    }

    public boolean create(String nome, Date dataNascimento){
        Ator newAtor = new Ator(proximoId, nome,dataNascimento);
        proximoId++;
        return this.atorRepository.create(newAtor);
    }

    public boolean delete(Long id){
        return this.atorRepository.delete(id);
    }

    public List<Ator> findAll(){
        return this.atorRepository.findAll();
    }

}
