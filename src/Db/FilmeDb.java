package Db;

import Models.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeDb {
    private List<Filme> filmes;

    public FilmeDb(){
        this.filmes = new ArrayList<>();
    }

    public List<Filme> getFilmes() {
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

    public void addFilme(Filme filme){
        this.filmes.add(filme);
    }

    public void removeFilme(Long id){
        Filme filme = this.findById(id);
        this.filmes.remove(filme);
    }
}
