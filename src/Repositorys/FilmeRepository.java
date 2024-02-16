package Repositorys;

import Db.FilmeDb;
import Models.Filme;

import java.util.List;

public class FilmeRepository {
    private FilmeDb filmeDb;

    public FilmeRepository(){
        this.filmeDb = new FilmeDb();
    }

    public boolean create(Filme filme){
        return this.filmeDb.addFilme(filme);
    }

    public boolean delete(Long id){
        return this.filmeDb.removeFilme(id);
    }

    public Filme findById(Long id){
        return this.filmeDb.findById(id);
    }

    public List<Filme> findAll(){
        return this.filmeDb.findAll();
    }
}
