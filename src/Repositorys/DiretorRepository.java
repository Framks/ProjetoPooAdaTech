package Repositorys;

import Db.BancoDados;
import Models.Diretor;

import java.util.List;

public class DiretorRepository extends AbstraticRepository {
    public DiretorRepository(BancoDados bancoDados){
        super(bancoDados);
    }

    @Override
    protected Class classeModelo(){
        return Diretor.class;
    }
}
