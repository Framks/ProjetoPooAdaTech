package infra.Repositorys;

import infra.Db.BancoDados;
import Models.Ator;

import java.util.List;

public class AtorRepository extends AbstraticRepository {
    public AtorRepository(BancoDados bancoDados){
        super(bancoDados);
    }

    @Override
    protected Class classeModelo(){
        return Ator.class;
    }

    public Ator procurarPorNome(String nome){
        if (nome == null)
            throw new RuntimeException("Nome nullo");
        List atores = listar();
        if (atores.isEmpty())
            throw new RuntimeException("sem atores");

        for (Object o: atores){
            Ator ator = (Ator) o;
            if (ator.getNome().equalsIgnoreCase(nome)){
                return ator;
            }
        }
        throw new RuntimeException("ator não encontrado");
    }

    public Ator procurarPorId(Long id){
        if (id == null)
            throw new RuntimeException("Faltanto numero de Codigo:");
        List atores = listar();
        if (atores.isEmpty())
            throw new RuntimeException("sem atores");
        for (Object o: atores){
            Ator ator = (Ator) o;
            if (ator.getId()==id){
                return ator;
            }
        }
        throw new RuntimeException("sem ator com esse id");
    }
}