package Services;

import Models.Diretor;
import Services.exceptionSevices.DirectorException;
import infra.Repositorys.DiretorRepository;
import infra.Repositorys.FilmeRepository;

import java.util.List;

public class DiretorService {
    final private DiretorRepository diretorRepository;
    final private FilmeRepository filmeRepository;

    public DiretorService(DiretorRepository diretorRepository, FilmeRepository filmeRepository){
        this.diretorRepository = diretorRepository;
        this.filmeRepository = filmeRepository;
    }

    public Diretor findById(Long id){
        if (id == null)
            throw new DirectorException.DirectorNotFoundException();
        return (Diretor) this.diretorRepository.buscarPorId(id);
    }

    public Diretor findByNome(String nome){
        if (nome == null)
            throw new DirectorException("Error ao buscar diretor sem nome");
        List<Diretor> diretores = findAll();
        for (Diretor diretor: diretores){
            if(diretor.getNome().equalsIgnoreCase(nome)){
                return diretor;
            }
        }
        return null;
    }

    public void create(Diretor newDiretor){
        if (newDiretor.getNome() == null)
            throw new DirectorException("Error ao cadastrar diretor sem nome");
        if (newDiretor.getDataNascimento() == null)
            throw new DirectorException("Error ao cadastrar diretor sem data de nascimento");
        this.diretorRepository.gravar(newDiretor);
    }

    public boolean delete(Long id){
        if (id == null){
            throw new DirectorException("id nulo ");
        }
        Diretor diretor = (Diretor) this.diretorRepository.buscarPorId(id);
        if (diretor == null)
            throw new DirectorException("Diretor de id "+id+" não encontrado");
        return this.diretorRepository.excluir(diretor);
    }

    public List findAll(){
        return this.diretorRepository.listar();
    }

    public List procurarFilmesDeDiretor(Long id){
        if (id == null){
            throw new DirectorException("Id nulo");
        }
        Diretor diretor = (Diretor) this.diretorRepository.buscarPorId(id);
        if (diretor == null)
            throw new DirectorException("diretor inexistente");
        return this.filmeRepository.procurarPorDiretor(diretor);
    }
}
