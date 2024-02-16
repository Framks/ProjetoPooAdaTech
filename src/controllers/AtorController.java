package controllers;

import Menu.Menu;
import Models.Ator;
import Services.AtorService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AtorController {
    public AtorService atorService;

    private final Menu menu;
    //private AtorService atorService;

    public AtorController(){
        this.menu = new Menu();
        this.atorService = new AtorService();
    }
    public Ator createAtor(Scanner scan){
        System.out.println("vamos criar um ator:");
        System.out.print("digite o nome: ");
        String nome = scan.nextLine();
        System.out.println("digite a data de nascimento: ");
        Date data = this.menu.receberData(scan);
        if (atorService.create(nome, data)){
            return atorService.findByNome(nome);
        }else{
            return null;
        }
    }

    public void listAtor(){
        System.out.println("### Lista de Atores ###");
        for (Ator ator: this.atorService.findAll()){
            System.out.println(ator.toString());
        }
    }

    public Ator getAtorExistente(Scanner scan){
        listAtor();
        System.out.print("digite um id valido: ");
        Long id = this.menu.receberLong(scan);
        return this.atorService.findById(id);
    }



    public void run(Scanner scan){
        Integer opcao = 0;
        do {
            this.menu.printMenuAtor();
            opcao = this.menu.receberInteiro(scan);
            switch (opcao){
                case 1:
                    this.listAtor();
                    break;
                case 2:
                    Ator ator = createAtor(scan);
                    if (ator!= null){
                        System.out.println("Criado com sucesso!");
                    }else{
                        System.out.println("Não criado");
                    }
                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println("opção inválida");
            }
        }while(opcao != 4);
    }

}
