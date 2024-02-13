package Repositorys;

import Db.AtorDb;
import Models.Ator;

import java.util.List;

public class AtorRepository {
    final private AtorDb atorDb;

    public AtorRepository(){
        this.atorDb = new AtorDb();
    }

    public boolean create(Ator ator){
        return this.atorDb.add(ator);
    }

    public boolean delete(Long id){
        return this.atorDb.remove(id);
    }

    public Ator findById(Long id){
        return this.atorDb.findById(id);
    }

    public List<Ator> findAll(){
        return this.atorDb.findAll();
    }
}