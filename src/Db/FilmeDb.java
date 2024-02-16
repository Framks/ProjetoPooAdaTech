package Db;

import Models.Ator;
import Models.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeDb {
    private List<Filme> filmes;

    public FilmeDb(){
        this.filmes = new ArrayList<>();
    }

    public List<Filme> findAll() {
        return filmes;
    }

    public Filme findById(Long id){
        for (Filme filme : this.filmes){
            if (filme.getId() == id){
                return filme;
            }
        }
        return null;
    }

    public boolean addFilme(Filme filme){
        if (contains(filme))
            return false;
        this.filmes.add(filme);
        return true;
    }

    public boolean removeFilme(Long id){
        Filme filme = this.findById(id);
        if (filme == null)
            return false;
        this.filmes.remove(filme);
        return true;
    }

    private boolean contains(Filme filme){
        for (Filme f: this.filmes){
            if (f.equals(filme)){
                return true;
            }
        }
        return false;
    }

}
