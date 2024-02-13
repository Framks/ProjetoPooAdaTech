package controllers;

import Menu.Menu;
import Models.Ator;
import Models.Diretor;
import Services.DiretorService;

import java.util.Date;
import java.util.Scanner;

public class DiretorController {
    private Menu menu;
    private DiretorService diretorService;
    public DiretorController(){
        this.menu = new Menu();
        this.diretorService = new DiretorService();
    }

    public Diretor createDiretor(Scanner scan){
        System.out.println("vamos criar um Diretor:");
        System.out.print("digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("digite a data de nascimento: ");
        Date data = this.menu.receberData(scan);
        if (diretorService.create(nome, data)){
            return diretorService.findByNome(nome);
        }else{
            return null;
        }
    }

    public void listDiretor(){
        System.out.println("### Lista de Diretores ###");
        for (Diretor diretor: this.diretorService.findAll()){
            System.out.println(diretor.toString());
        }
    }

    public void linkDiretorFilme(Scanner scan){

    }

    public void run(Scanner scan){
        Integer opcao = 0;
        do {
            this.menu.printMenuAtor();
            opcao = this.menu.receberInteiro(scan);
            switch (opcao){
                case 1:
                    this.listDiretor();
                    break;
                case 2:
                    Diretor ator = createDiretor(scan);
                    if (ator!= null){
                        System.out.println("Criado com sucesso!");
                    }else{
                        System.out.println("Não criado");
                    }
                    break;
                case 3:
                    linkDiretorFilme(scan);
                    break;
                case 4:

                    break;
                default:
                    System.out.println("opção inválida");
            }
        }while(opcao != 4);
    }
}
