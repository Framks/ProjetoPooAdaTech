package Db;

import Models.Ator;

import java.util.ArrayList;
import java.util.List;

public class AtorDb {
    private List<Ator> atores;

    public AtorDb(){
        this.atores = new ArrayList<>();
    }

    public List<Ator> findAll() {
        return atores;
    }

    public boolean add(Ator ator){
        if(this.contains(ator))
            return false;
        this.atores.add(ator);
        return true;
    }

    public Ator findById(Long id){
        for(Ator ator: this.atores){
            if (ator.getId().equals(id)){
                return ator;
            }
        }
        return null;
    }

    public boolean remove(Long id){
        Ator remove = findById(id);
        if(remove != null){
            this.atores.remove(remove);
            return true;
        }
        return false;
    }

    private boolean contains(Ator ator){
        for (Ator a: this.atores){
            if (a.equals(ator))
                return true;
        }
        return false;
    }

}
