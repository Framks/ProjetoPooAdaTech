package Repositorys;

import Db.BancoDados;

import java.util.Collections;
import java.util.List;

public abstract class AbstraticRepository {
    private BancoDados bancoDeDados;

    public AbstraticRepository(BancoDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }

    public void gravar(Object objeto) {
        this.bancoDeDados.inserirObjeto(objeto);
    }

    public List listar() {
        List objetosPresentesNoBanco = this.bancoDeDados.buscarObjetosPorTipo(classeModelo());
        return Collections.unmodifiableList(objetosPresentesNoBanco);
    }

    public Boolean excluir(Object objeto) {
        this.bancoDeDados.excluirObjeto(objeto);
        return true;
    }

    protected abstract Class classeModelo();
}
