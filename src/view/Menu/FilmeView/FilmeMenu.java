package view.Menu.FilmeView;

import Models.Ator;
import Models.Diretor;
import Models.Filme;
import Services.AtorService;
import Services.DiretorService;
import Services.FilmeService;
import view.Menu.AtorView.AtorMenu;
import view.Menu.DiretorView.DiretorMenu;
import view.Menu.Menu;
import view.PrintaMenu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FilmeMenu {
    private static FilmeMenu instance;
    private final FilmeService service;
    private final Menu menu;
    private final Scanner scanner;
    private final AtorService atorService;
    private final DiretorService diretorService;

    private FilmeMenu(FilmeService service, Menu menu, Scanner scanner, AtorService atorService, DiretorService diretorService) {
        this.service = service;
        this.menu = menu;
        this.scanner = scanner;
        this.atorService = atorService;
        this.diretorService = diretorService;

    }

    public static synchronized FilmeMenu getInstance(FilmeService service, Menu menu, Scanner scanner, AtorService atorService, DiretorService diretorService) {
        if (instance == null) {
            instance = new FilmeMenu(service, menu, scanner, atorService, diretorService);
        }
        return instance;
    }

    public void run(){
        System.out.println(PrintaMenu.FILME_MENU.get());
        Integer option;
        try {
            option = this.menu.receberInteiro(scanner);
            switch (option){
                case 1-> listar();
                case 2-> procurarPorNome();
                case 3-> adcionarAtor();
                case 4-> adcionarDiretor();
                case 5-> cadastrar();
                case 0-> {
                    return;
                }
            }
            run();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            run();
        }
    }

    private void cadastrar(){
        System.out.print("Digite o nome no filme: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o ano de lançamento: ");
        Integer ano = this.menu.receberInteiro(scanner);
        System.out.print("Digite a descrição do filme: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a classificação do filme(Ex.: 18,16,14 ou 0 como livre): ");
        Integer clasificacao = this.menu.receberInteiro(scanner);
        List<Ator> listaAtores = inputAtores();
        List<Diretor> listaDiretores = inputDiretores();
        Filme filme = new Filme(nome, descricao, ano, clasificacao, listaAtores, listaDiretores);
        this.service.create(filme);
    }
    private List<Ator> inputAtores(){
        ArrayList<Ator> atores = new ArrayList<>();
        while (true){
            System.out.print("vamos Selecionar os atores: \n"+
                    "1 - para cadastrar um novo \n"+
                    "2 - para selecionar um existente\n"+
                    "0 - para sair: ");
            Integer opt = this.menu.receberInteiro(scanner);
            if (opt == 0){
                break;
            } else if (opt == 1) {
                System.out.println("digite o nome do ator: ");
                String nome=  scanner.nextLine();
                System.out.println("Vamos criar a data de nascimento: ");
                Date datanascimento = this.menu.receberData(scanner);
                Ator ator = new Ator(nome,datanascimento);
                this.atorService.create(ator);
                atores.add(ator);
            } else if (opt == 2) {
                List getAtores = this.atorService.findAll();
                for (Object o : getAtores){
                    Ator ator = (Ator) o;
                    System.out.println(ator);
                }
                System.out.print("selecione o ID do ator: ");
                Long id = this.menu.receberLong(scanner);
                atores.add(this.atorService.findByID(id));
            }else{
                System.out.println("opção inválida");
            }
        }
        return atores;
    }

    private List<Diretor> inputDiretores(){
        ArrayList<Diretor> diretores = new ArrayList<>();
        while (true){
            System.out.print("vamos Selecionar os diretores: \n"+
                    "1 - para cadastrar um novo \n"+
                    "2 - para selecionar um existente\n"+
                    "0 - para sair: ");
            Integer opt = this.menu.receberInteiro(scanner);
            if (opt == 0){
                break;
            } else if (opt == 1) {
                System.out.println("digite o nome do diretor: ");
                String nome=  scanner.nextLine();
                System.out.println("Vamos criar a data de nascimento: ");
                Date datanascimento = this.menu.receberData(scanner);
                Diretor diretor = new Diretor(nome,datanascimento);
                this.diretorService.create(diretor);
                diretores.add(diretor);
            } else if (opt == 2) {
                List getDiretores = this.diretorService.findAll();
                for (Object o : getDiretores){
                    Diretor diretor = (Diretor) o;
                    System.out.println(diretor);
                }
                System.out.print("selecione o ID do ator: ");
                Long id = this.menu.receberLong(scanner);
                diretores.add(this.diretorService.findById(id));
            }else{
                System.out.println("opção inválida");
            }
        }
        return diretores;
    }
     private List<Ator> atores() {
         List<Ator> listAtores = new ArrayList<>(10);

         Integer opt;
         do {
             opt = this.menu.receberInteiro(scanner);
             System.out.print(PrintaMenu.OPCAO_EDIT_ATOR.get());

             if (opt == 1) {
                 System.out.println("digite o nome do ator: ");
                 String nome = scanner.nextLine();
                 System.out.println("Vamos criar a data de nascimento: ");
                 Date datanascimento = this.menu.receberData(scanner);

                 Ator ator = new Ator(nome, datanascimento);
                 this.atorService.create(ator);
                 listAtores.add(ator);

             } else if (opt == 2) {
                 System.out.println(AtorMenu.getlistar(this.atorService.findAll()));
                 System.out.print("selecione o ID do ator: ");
                 Long id = this.menu.receberLong(scanner);
                 listAtores.add(this.atorService.findByID(id));

             } else {
                 System.out.println("opção inválida");
             }
         } while (opt != 0);
         return listAtores;
     }

    private List<Diretor> diretores() {
        List<Diretor> listDiretores = new ArrayList<>();

        Integer opt;
        do {
            opt = this.menu.receberInteiro(scanner);
            System.out.print(PrintaMenu.OPCAO_EDIT_DIRETOR.get());

            if (opt == 1) {
                System.out.println("Digite o nome do diretor: ");
                String nome = scanner.nextLine();
                System.out.println("Vamos criar a data de nascimento: ");
                Date dataNascimento = this.menu.receberData(scanner);

                Diretor diretor = new Diretor(nome, dataNascimento);
                this.diretorService.create(diretor);
                listDiretores.add(diretor);
            } else if (opt == 2) {
                System.out.println(DiretorMenu.getlistarDiretores(this.diretorService.findAll()));
                System.out.print("Selecione o ID do diretor: ");
                Long id = this.menu.receberLong(scanner);
                listDiretores.add(this.diretorService.findById(id));
            } else if (opt != 0) {
                System.out.println("Opção inválida");
            }
        } while (opt != 0);

        return listDiretores;
    }

    private void procurarPorNome(){
        System.out.print("Digite o nome para a busca: ");
        String nome = this.scanner.nextLine();
        List filmes = service.findByName(nome);
        for (Object o : filmes){
            Filme filme = (Filme) o;
            System.out.println(filme);
        }
    }

    private void listar(){
        List filmes = this.service.findAll();
        for (Object o : filmes){
            Filme filme = (Filme) o;
            System.out.println(filme);
        }
    }

    private void adcionarAtor(){
        listar();
        System.out.println("Digite o id do filme para adicionar os Atores: ");
        Long id = this.menu.receberLong(scanner);
        List<Ator> atores = this.inputAtores();
        for (Ator a : atores){
            this.service.addAtorFilme(id,a);
        }
    }

    private void adcionarDiretor(){
        listar();
        System.out.println("Digite o id do filme para adicionar os Diretores: ");
        Long id = this.menu.receberLong(scanner);
        List<Diretor> diretores = this.inputDiretores();
        for (Diretor d : diretores){
            this.service.addDiretorFilme(id,d);
        }
    }

}
