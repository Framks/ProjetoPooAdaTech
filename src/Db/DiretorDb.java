package Db;

import Models.Diretor;

import java.util.ArrayList;
import java.util.List;

public class DiretorDb {
    private List<Diretor> diretores;

    public DiretorDb(){
        diretores = new ArrayList<Diretor>();
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }

    public void addDiretor(Diretor diretor){
        this.diretores.add(diretor);
    }

    public Diretor findDiretorById(Long id){
        for (Diretor diretor : this.diretores){
            if (diretor.getId() == id){
                return diretor;
            }
        }
        return null;
    }

    public void removeDiretor(Long id){
        for (Diretor diretor : this.diretores){
            if (diretor.getId() == id){
                this.diretores.remove(diretor);
                break;
            }
        }
    }
}
