package AppFilme;

import Menu.Menu;
import controllers.AtorController;
import controllers.DiretorController;
import controllers.FilmeController;

import java.util.Scanner;

public class AppImdb {

    private final Menu menu;
    private final Scanner scan;
    private final FilmeController filmeController;
    private final DiretorController diretorController;
    private final AtorController atorController;
    public AppImdb(){
        this.menu = new Menu();
        this.scan = new Scanner(System.in);
        this.filmeController = new FilmeController();
        this.atorController = new AtorController();
        this.diretorController = new DiretorController();
    }

    public void run(){
        Integer opcao;
        do{
            this.menu.printMenuPrincipal();
            System.out.print("Digite a opção: ");
            opcao = this.menu.receberInteiro(this.scan);
            switch (opcao){
                case 1:
                    this.atorController.run(scan);
                    break;
                case 2:
                    this.diretorController.run(scan);
                    break;
                case 3:
                    this.filmeController.run(scan);
                    break;
                case 4:
                    scan.close();
                    break;
                default:
                    break;
            }
        }while(opcao != 4);
    }
}