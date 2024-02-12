package Db;

import Models.Ator;

import java.util.ArrayList;
import java.util.List;

public class AtorDb {
    private List<Ator> atores;

    public AtorDb(){
        this.atores = new ArrayList<>();
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void addAtor(Ator ator){
        this.atores.add(ator);
    }

    public Ator findById(Long id){
        for(Ator ator: this.atores){
            if (ator.getId()== id){
                return ator;
            }
        }
        return null;
    }

    public void removeAtor(Long id){
        Ator remove = findById(id);
        this.atores.remove(remove);
    }
}
