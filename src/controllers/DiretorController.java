package controllers;

import Menu.Menu;
import Models.Diretor;
import Models.Filme;
import Services.DiretorService;
import Services.FilmeService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DiretorController {
    private Menu menu;
    private DiretorService diretorService;
    private FilmeService filmeService;
    public DiretorController(){
        this.menu = new Menu();
        this.diretorService = new DiretorService();
        this.filmeService = new FilmeService();
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

    public boolean delete(Scanner scan){
        listDiretor();
        System.out.print("digite o id para deletar: ");
        return this.diretorService.delete(this.menu.receberLong(scan));
    }

    public void listDiretor(){
        System.out.println("### Lista de Diretores ###");
        for (Diretor diretor: this.diretorService.findAll()){
            System.out.println(diretor.toString());
        }
    }

    public Diretor getDiretorExistente(Scanner scan){
        listDiretor();
        System.out.print("digite um id valido: ");
        Long id = this.menu.receberLong(scan);
        return this.diretorService.findById(id);
    }

    public void linkDiretorFilme(Scanner scan){
        List<Filme> filmes = this.filmeService.findAll();
        for (Filme f: filmes){
            System.out.println(f.toString());
        }
        System.out.print("digite o id do filme: ");
        Long idfilme = this.menu.receberLong(scan);
        listDiretor();
        System.out.print("digite o id do Diretor: ");
        this.filmeService.addDiretorFilme(idfilme, this.getDiretorExistente(scan));
    }

    public void run(Scanner scan){
        Integer opcao;
        do {
            this.menu.printMenuDiretor();
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
                    if (delete(scan)){
                        System.out.println("Deletado com sucesso");
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
