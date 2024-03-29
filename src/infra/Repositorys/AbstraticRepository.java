package infra.Repositorys;

import infra.Db.BancoDados;

import java.util.Collections;
import java.util.List;

public abstract class AbstraticRepository {
    protected BancoDados bancoDeDados;

    public AbstraticRepository(BancoDados bancoDeDados){
        this.bancoDeDados = bancoDeDados;
    }

    public void gravar(Object objeto) {
        this.bancoDeDados.inserirObjeto(objeto);
    }

    protected abstract Boolean filtrarPorId(Object o, Long id);

    public Object buscarPorId(Long id){
        List objetos = listar();
        Object encontrado = null;
        for (Object o : objetos){
            if (filtrarPorId(o, id)){
                encontrado = o;
            }
        }
        return encontrado;
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
