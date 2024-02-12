package AppFilme;

import Menu.Menu;

import java.util.Scanner;

public class AppImdb {

    private Menu menu;
    private Scanner scan;;
    public AppImdb(){
        this.menu = new Menu();
        this.scan = new Scanner(System.in);
    }

    public void run(){
        Boolean rodarMenu = true;
        while (rodarMenu){
            this.menu.printMenuPrincipal();
            System.out.print("Digite a opção: ");
            Integer opcao = this.receberInteiro(this.scan);
            switch (opcao){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    rodarMenu = false;
                    break;
                default:
                    break;
            }
        }
    }

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
}