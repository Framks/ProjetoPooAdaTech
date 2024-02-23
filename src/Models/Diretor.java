package Models;

import java.util.Date;

public class Diretor  extends Pessoa {

    public Diretor( String nome, Date dataNascimento){
        super( nome, dataNascimento);
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() == this.getClass()){
            Diretor newator = (Diretor) o;
            if (newator.getNome().equals(this.getNome())){
                if (newator.getDataNascimento() == this.getDataNascimento()){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else {
            return false;
        }
    }
}
