package infra.Repositorys;


import infra.Db.BancoDados;
import Models.Diretor;

import java.util.List;
import java.util.Objects;

public class DiretorRepository extends AbstraticRepository {
    public DiretorRepository(BancoDados bancoDados){
        super(bancoDados);
    }

    @Override
    protected Boolean filtrarPorId(Object o, Long id){
        Diretor diretor = (Diretor) o;
        return Objects.equals(diretor.getId(), id);
    }

    @Override
    protected Class classeModelo(){
        return Diretor.class;
    }

    @Override
    public void gravar(Object o){
        Diretor diretor = (Diretor) o;
        if (diretor != null)
            diretor.setId(this.bancoDeDados.getProximoId());
        this.bancoDeDados.inserirObjeto(diretor);
    }
}
