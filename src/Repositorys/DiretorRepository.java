package Repositorys;

import Db.DiretorDb;
import Models.Diretor;

import java.util.List;

public class DiretorRepository {
    final private DiretorDb diretorDb;

    public DiretorRepository(){
        this.diretorDb = new DiretorDb();
    }

    public boolean create(Diretor diretor){
        return this.diretorDb.add(diretor);
    }

    public boolean delete(Long id){
        return this.diretorDb.remove(id);
    }

    public Diretor findById(Long id){
        return this.diretorDb.findById(id);
    }

    public List<Diretor> findAll(){
        return this.diretorDb.findAll();
    }
}
