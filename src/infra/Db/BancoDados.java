package infra.Db;

import java.util.*;

public class BancoDados {
    private static final Map OBJETOS = new HashMap();
    private Long id = 1L;

    public void inserirObjeto(Object objeto) {
        Set objetos = colecaoDeObjetos(objeto.getClass());
        objetos.add(objeto);
    }

    public void excluirObjeto(Object objeto) {
        Set objetos = colecaoDeObjetos(objeto.getClass());
        objetos.remove(objeto);
    }

    // esta função ira retornar uma lista de objetos de uma classe
    public List buscarObjetosPorTipo(Class clazz) {
        Set objetos = colecaoDeObjetos(clazz);
        return new ArrayList(objetos);
    }

    // esta função vai retornar uma coleção de objetos do mesmo tipo.
    // passando como parametro uma classe
    private Set colecaoDeObjetos(Class clazz) {
        Set objetos = (Set) BancoDados.OBJETOS.get(clazz);
        if (objetos == null){
            objetos = new HashSet();
            BancoDados.OBJETOS.put(clazz, objetos);
        }
        return objetos;
    }

    public Long getProximoId(){
        return this.id++;
    }

}
