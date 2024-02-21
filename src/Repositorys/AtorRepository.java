package Repositorys;

import Db.BancoDados;
import Models.Ator;

public class AtorRepository extends AbstraticRepository {


    public AtorRepository(BancoDados bancoDados){
        super(bancoDados);
    }

    @Override
    protected Class classeModelo(){
        return Ator.class;
    }
}