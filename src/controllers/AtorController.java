package controllers;

import Menu.Menu;
import Models.Ator;
import Models.Filme;
import Services.AtorService;
import Services.FilmeService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AtorController {
    private Menu menu;
    private AtorService atorService;
    private FilmeService filmeService;

    public AtorController(){
        this.menu = new Menu();
        this.atorService = new AtorService();
        this.filmeService = new FilmeService();
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

    public void linkAtorFilme(Scanner scan){
        List<Filme> filmes = this.filmeService.findAll();
        for (Filme f: filmes){
            System.out.println(f.toString());
        }
        System.out.print("digite o id do filme: ");
        Long idfilme = this.menu.receberLong(scan);
        listAtor();
        System.out.print("digite o id do ator: ");
        this.filmeService.addAtorFilme(idfilme, this.getAtorExistente(scan));
    }

    public boolean delete(Scanner scan){
        listAtor();
        System.out.print("digite o id do Ator: ");
        return this.atorService.delete(this.menu.receberLong(scan));
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
                    linkAtorFilme(scan);
                    break;
                case 4:
                    if (delete(scan)){
                        System.out.println("deletado com sucesso");
                    }else{
                        System.out.println("não deletado");
                    }
                    break;
                default:
                    System.out.println("opção inválida");
            }
        }while(opcao != 5);
    }

}
