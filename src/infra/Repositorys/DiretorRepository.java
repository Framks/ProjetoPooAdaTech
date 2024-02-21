package infra.Repositorys;


import infra.Db.BancoDados;
import Models.Diretor;

import java.util.List;

public class DiretorRepository extends AbstraticRepository {
    public DiretorRepository(BancoDados bancoDados){
        super(bancoDados);
    }

    @Override
    protected Class classeModelo(){
        return Diretor.class;
    }

    public Diretor procurarPorNome(String nome){
        if (nome == null)
            throw new RuntimeException("Nome nullo");
        List diretores = listar();
        if (diretores.isEmpty())
            throw new RuntimeException("sem Diretores");

        for (Object o: diretores){
            Diretor diretor = (Diretor) o;
            if (diretor.getNome().equalsIgnoreCase(nome)){
                return diretor;
            }
        }
        throw new RuntimeException("Diretor não encontrado");
    }

    public Diretor procurarPorId(Long id){
        if (id == null)
            throw new RuntimeException("Faltanto numero de Codigo:");
        List atores = listar();
        if (atores.isEmpty())
            throw new RuntimeException("sem Diretores");
        for (Object o: atores){
            Diretor diretor = (Diretor) o;
            if (diretor.getId()==id){
                return diretor;
            }
        }
        throw new RuntimeException("sem Diretor com esse id");
    }

    @Override
    public void gravar(Object o){
        Diretor diretor = (Diretor) o;
        if (diretor != null)
            diretor.setId(this.bancoDeDados.getProximoId());
        this.bancoDeDados.inserirObjeto(diretor);
    }
}
