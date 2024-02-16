package controllers;
import Menu.Menu;
import Models.Ator;
import Models.Diretor;
import Models.Filme;
import Services.FilmeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmeController {
    private Menu menu;
    private FilmeService service;
    private AtorController atorController;
    private DiretorController diretorController;

    public FilmeController(){
        this.service = new FilmeService();
        this.menu = new Menu();
        this.atorController = new AtorController();
        this.diretorController = new DiretorController();
    }

    public void create(Scanner scan){
        System.out.print("Nome do filme:");
        String nome = scan.nextLine();
        System.out.print("Digite uma descrição para ele: ");
        String descricao = scan.nextLine();
        System.out.print("Digite o ano de lançamento: ");
        Integer anoLancamento = this.menu.receberInteiro(scan);
        System.out.print("Digite a classificação do filme: ");
        Integer classificacao = this.menu.receberInteiro(scan);
        System.out.print("Se quiser criar um ator novo digite 1 se quiser adcionar um ator existente digite 2(não querendo digita 0):");
        Integer opcao = this.menu.receberInteiro(scan);
        List<Ator> atores = new ArrayList<>();
        while (opcao != 0){
            if (opcao == 1){
                atores.add(this.atorController.createAtor(scan));
            }else if(opcao == 2){
                atores.add(this.atorController.getAtorExistente(scan));
            }
            System.out.print("digite a opção para continuar(1,2 ou 0): ");
            opcao = this.menu.receberInteiro(scan);
        }
        System.out.print("Se quiser criar um Diretor novo digite 1 se quiser adcionar um ator existente digite 2(não querendo digita 0):");
        opcao = this.menu.receberInteiro(scan);
        List<Diretor> diretores = new ArrayList<>();
        while (opcao != 0){
            if (opcao == 1){
                diretores.add(this.diretorController.createDiretor(scan));
            }else if(opcao == 2){
                diretores.add(this.diretorController.getDiretorExistente(scan));
            }
            System.out.print("digite a opção para continuar(1,2 ou 0): ");
            opcao = this.menu.receberInteiro(scan);
        }

        Filme newFilme = new Filme(nome,descricao,anoLancamento,classificacao,atores,diretores);
        this.service.create(newFilme);
    }

    public void findByName(Scanner scan){
        System.out.print("digite o nome para busca: ");
        String nome = scan.nextLine();
        List<Filme> filmes = this.service.findByName(nome);
        if (filmes != null) {
            for (Filme f: filmes){
                System.out.println(f.toString());
            }
        }else{
                System.out.println("filme não encontrado");

        }
    }

    public void delete(Scanner scan){
        listFilms();
        System.out.print("para deletar um filme temos que passar o id do filme: ");
        Long id = this.menu.receberLong(scan);
        if (this.service.delete(id)){
            System.out.println("deletado com sucesso");
        }else{
            System.out.println("não deletado");
        }
    }

    public void linkAtorFilme(Scanner scan){
        listFilms();
        System.out.print("Digite o id do filme para adcioinar um ator: ");
        Long idfilme = this.menu.receberLong(scan);
        Ator ator = this.atorController.getAtorExistente(scan);
        this.service.addAtorFilme(idfilme,ator);
    }

    public void linkDiretorFilme(Scanner scan){
        listFilms();
        System.out.print("Digite o id do filme para adcioinar um Diretor: ");
        Long idfilme = this.menu.receberLong(scan);
        Diretor diretor = this.diretorController.getDiretorExistente(scan);
        this.service.addDiretorFilme(idfilme,diretor);
    }

    private void listFilms(){
        List<Filme> filmes = this.service.findAll();
        for (Filme f: filmes){
            System.out.println(f.toString());
        }
    }

    public void run(Scanner scan){
        Integer opcao;
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
                    linkAtorFilme(scan);
                    break;
                case 4:
                    linkDiretorFilme(scan);
                    break;
                case 5:
                    create(scan);
                    break;
                case 6:
                    delete(scan);
                    break;
                default:
                    System.out.println("opção invalida;");
            }
        }while (opcao != 7);
    }

}
