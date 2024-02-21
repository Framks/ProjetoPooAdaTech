package Repositorys;

import Db.BancoDados;
import Db.FilmeDb;
import Models.Filme;

import java.util.List;

public class FilmeRepository extends AbstraticRepository{
    public FilmeRepository(BancoDados bancoDados){
        super(bancoDados);
    }

    @Override
    protected Class classeModelo(){
        return Filme.class;
    }
}
