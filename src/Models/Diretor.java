package Models;

import java.util.Date;
import java.util.Objects;

public class Diretor  extends Pessoa {

    public Diretor( String nome, Date dataNascimento){
        super( nome, dataNascimento);
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() == this.getClass()){
            Diretor newator = (Diretor) o;
            if (Objects.equals(this.getId(),newator.getId())){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }
}
