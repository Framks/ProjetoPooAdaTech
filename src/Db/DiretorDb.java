package Db;

import Models.Ator;
import Models.Diretor;

import java.util.ArrayList;
import java.util.List;

public class DiretorDb {
    private List<Diretor> diretores;

    public DiretorDb(){
        this.diretores = new ArrayList<>();
    }

    public List<Diretor> findAll() {
        return this.diretores;
    }

    public boolean add(Diretor diretor){
        if(this.contains(diretor))
            return false;
        this.diretores.add(diretor);
        return true;
    }

    public Diretor findById(Long id){
        for(Diretor diretor: this.diretores){
            if (diretor.getId().equals(id)){
                return diretor;
            }
        }
        return null;
    }

    public boolean remove(Long id){
        Diretor remove = findById(id);
        if(remove != null){
            this.diretores.remove(remove);
            return true;
        }
        return false;
    }

    private boolean contains(Diretor diretor){
        for (Diretor d: this.diretores){
            if (d.equals(diretor))
                return true;
        }
        return false;
    }
}
