package controllers;
import Menu.Menu;
import Services.FilmeService;

import java.util.Scanner;

public class FilmeController {
    private Menu menu;
    private FilmeService service;

    public FilmeController(){
        this.service = new FilmeService();
        this.menu = new Menu();
    }

    public void create(Scanner scan){
        System.out.print("Nome do filme:");
        String nome = scan.nextLine();
        System.out.print("Digite uma descrição para ele: ");
        String descricao = scan.nextLine();
        System.out.print("Digite o ano de lançamento: ");
        Integer anoLancamento = this.menu.receberInteiro(scan);
        System.out.print("Digite a duracao do filme");

    }

    public void findByName(Scanner scan){
        System.out.print("digite o nome para busca: ");

    }

    private void listFilms(){

    }

    public void run(Scanner scan){
        Integer opcao = 0;
        do {
            this.menu.printMenuFilme();
            opcao = this.menu.receberInteiro(scan);
            switch (opcao){
                case 1:
                    listFilms();
                    break;
                case 2:
                    findByName(scan);
                    break;
                case 3:
                    create(scan);
                    break;
                default:
                    System.out.println("opção invalida;");
            }
        }while (opcao != 4);
    }
}
