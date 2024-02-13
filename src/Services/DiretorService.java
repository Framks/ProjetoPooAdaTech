package Services;

import Models.Diretor;
import Repositorys.DiretorRepository;

import java.util.Date;
import java.util.List;

public class DiretorService {
    final private DiretorRepository diretorRepository;
    private Long proximoId;

    public DiretorService(){
        this.diretorRepository = new DiretorRepository();
        this.proximoId = 0L;
    }

    public Diretor findById(Long id){
        return this.diretorRepository.findById(id);
    }

    public Diretor findByNome(String nome){
        List<Diretor> diretores = findAll();
        for (Diretor diretor: diretores){
            if(diretor.getNome().equalsIgnoreCase(nome)){
                return diretor;
            }
        }
        return null;
    }

    public boolean create(String nome, Date dataNascimento){
        Diretor newDiretor = new Diretor(proximoId, nome,dataNascimento);
        proximoId++;
        return this.diretorRepository.create(newDiretor);
    }

    public boolean delete(Long id){
        return this.diretorRepository.delete(id);
    }

    public List<Diretor> findAll(){
        return this.diretorRepository.findAll();
    }
}
