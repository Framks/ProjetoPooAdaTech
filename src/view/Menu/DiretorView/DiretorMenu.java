package view.Menu.DiretorView;
import Models.Diretor;
import Models.Filme;
import Services.DiretorService;
import Services.FilmeService;
import view.Menu.Menu;
import view.PrintaMenu;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DiretorMenu {
        private static DiretorMenu instance;
        private final DiretorService service;
        private final Menu menu;
        private final Scanner scanner;

        private DiretorMenu(DiretorService service, Menu menu, Scanner scan) {
            this.service = service;
            this.menu = menu;
            this.scanner = scan;
        }

        public static DiretorMenu getInstance(DiretorService service, Menu menu, Scanner scan) {
            if (instance == null) {
                instance = new DiretorMenu(service, menu, scan);
            }
            return instance;
        }


        public void run(){
            System.out.println(PrintaMenu.DIRETOR_MENU.get());
            Integer option;
            try {
                option = menu.receberInteiro(scanner);
                switch (option){
                    case 1-> System.out.println(listar());
                    case 2-> cadastrar();
                    case 3-> listarFilmesDiretor();
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
            System.out.println("digite o nome do Diretor: ");
            String nome=  scanner.nextLine();

            System.out.println("Vamos criar a data de nascimento: ");
            Date datanascimento = this.menu.receberData(scanner);

            Diretor diretor = new Diretor(nome,datanascimento);
            this.service.create(diretor);
        }

    public static String getlistarDiretores(List diretores) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Diretores\n");
        for (Object generico : diretores) {
            Diretor diretor = (Diretor) generico;
            stringBuilder.append(diretor).append("\n");
        }
        return stringBuilder.toString();
    }

    private String listar(){
            List genericos = this.service.findAll();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Diretores\n");
            for (Object generico : genericos) {
                Diretor diretor = (Diretor) generico;
                stringBuilder.append(diretor).append("\n");
            }
            return stringBuilder.toString();
        }

        private void listarFilmesDiretor(){
            System.out.println(listar());
            System.out.print("Selecione um id de um Diretor: ");
            Long id = this.menu.receberLong(scanner);
            List genericos = service.procurarFilmesDeDiretor(id);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Filmes:\n");
            for (Object generico : genericos) {
                Filme filme = (Filme) generico;
                stringBuilder.append(filme).append("\n");
            }
            System.out.println(stringBuilder);
        }

    private void procurarPorNome(){
        System.out.println("digite o nome para fazer a busca");
        String nome = scanner.nextLine();
        Diretor diretor = this.service.findByNome(nome);
        System.out.println(diretor);
    }
}


