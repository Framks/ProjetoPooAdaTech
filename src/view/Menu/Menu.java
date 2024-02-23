package view.Menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    public Integer receberInteiro(Scanner scan){
        Integer result = 0;
        while (true){
            try {
                result = scan.nextInt();
                scan.nextLine();
                break;
            }catch (Exception e){
                scan.nextLine();
                System.out.println("Digite um numero Inteiro;");
            }
        }
        return result;
    }

    public Date receberData(Scanner scan){
        System.out.print("Digite o dia: ");
        Integer dia = receberInteiro(scan);
        System.out.print("Digite o mes: ");
        Integer mes = receberInteiro(scan);
        System.out.print("Digite o ano: ");
        Integer ano = receberInteiro(scan);
        String data = dia+"/"+mes+"/"+ano;
        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatData.parse(data);
        } catch (ParseException e) {
            System.out.println("error ao formatar data");
            return null;
        }
    }

    public Long receberLong(Scanner scan){
        Long result;
        while (true){
            try {
                result = scan.nextLong();
                scan.nextLine();
                break;
            }catch (Exception e){
                scan.nextLine();
                System.out.println("Digite um numero de Id;");
            }
        }
        return result;
    }
}
