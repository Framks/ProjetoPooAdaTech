package view.Menu.AtorView;

import Models.Ator;
import Models.Diretor;
import Models.Filme;
import Services.AtorService;
import view.Menu.Menu;
import view.PrintaMenu;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AtorMenu {
        private static AtorMenu instance;
        private final AtorService service;
        private final Menu menu;
        private final Scanner scanner;

        private AtorMenu(AtorService service, Menu menu, Scanner scan) {
            this.service = service;
            this.menu = menu;
            this.scanner = scan;
        }

        public static AtorMenu getInstance(AtorService service, Menu menu, Scanner scan) {
            if (instance == null) {
                instance = new AtorMenu(service, menu, scan);
            }
            return instance;
        }

    public void run(){
        System.out.println(PrintaMenu.ATOR_MENU.get());
        Integer option;
        try {
            option = menu.receberInteiro(scanner);
            switch (option){
                case 1-> listar();
                case 2-> cadastrar();
                case 3-> listarFilmesAtor();
                case 4-> procurarPorNome();
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
        System.out.println("digite o nome do ator: ");
        String nome=  scanner.nextLine();
        System.out.println("Vamos criar a data de nascimento: ");
        Date datanascimento = this.menu.receberData(scanner);
        Ator ator = new Ator(nome,datanascimento);
        this.service.create(ator);
    }
    public static String getlistar(List atores){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Atores\n");
        for (Object generico : atores) {
            Ator ator = (Ator) generico;
            stringBuilder.append(ator).append("\n");
        }
        return stringBuilder.toString();
    }
    private void listar(){
        List atores = this.service.findAll();
        for(Object o : atores) {
            Ator ator = (Ator) o;
            System.out.println(ator.toString());
        }
    }
    private void listarFilmesAtor(){
            listar();
        //System.out.println(listar());
        System.out.print("Selecione um id de um ator: ");
        Long id = this.menu.receberLong(scanner);
        List filmes = service.procurarFilmesDeAtor(id);
        for (Object o: filmes){
            Filme f = (Filme) o;
            System.out.println(f.toString());
        }
    }
    private void procurarPorNome(){
        System.out.println("digite o nome para fazer a busca");
        String nome = scanner.nextLine();
        Ator ator = this.service.findByNome(nome);
        System.out.println(ator.toString());
    }
}
