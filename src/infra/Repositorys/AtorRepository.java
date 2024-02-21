package infra.Repositorys;

import infra.Db.BancoDados;
import Models.Ator;

import java.util.List;
import java.util.Objects;

public class AtorRepository extends AbstraticRepository {
    public AtorRepository(BancoDados bancoDados){
        super(bancoDados);
    }

    @Override
    protected Boolean filtrarPorId(Object o,Long id) {
        Ator ator = (Ator) o;
        return Objects.equals(ator.getId(), id);
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

    @Override
    public void gravar(Object o){
        Ator ator = (Ator) o;
        if (ator != null)
            ator.setId(this.bancoDeDados.getProximoId());
        this.bancoDeDados.inserirObjeto(ator);
    }
}