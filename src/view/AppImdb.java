package view;

import Services.AtorService;
import Services.DiretorService;
import Services.FilmeService;
import infra.Db.BancoDados;
import infra.Repositorys.AtorRepository;
import infra.Repositorys.DiretorRepository;
import infra.Repositorys.FilmeRepository;
import view.Menu.AtorView.AtorMenu;
import view.Menu.DiretorView.DiretorMenu;
import view.Menu.FilmeView.FilmeMenu;
import view.Menu.Menu;

import java.util.Scanner;

public class AppImdb {

    private final Menu menu;
    private final Scanner scan;
    private final AtorMenu atorMenu;
    private final DiretorMenu diretorMenu;
    private final FilmeMenu filmeMenu;



    public AppImdb() {
        BancoDados bancoDados = new BancoDados();
        FilmeService filmeService = new FilmeService(new FilmeRepository(bancoDados));
        AtorService atorService = new AtorService(new AtorRepository(bancoDados), new FilmeRepository(bancoDados));
        DiretorService diretorService = new DiretorService(new DiretorRepository(bancoDados), new FilmeRepository(bancoDados));
        this.menu = new Menu();
        this.scan = new Scanner(System.in);
        this.atorMenu = AtorMenu.getInstance(atorService, menu, scan);
        this.diretorMenu = DiretorMenu.getInstance(diretorService, menu, scan);
        this.filmeMenu = FilmeMenu.getInstance(filmeService, menu, scan, atorService,diretorService);
    }



    public void run(){
        Integer opcao;
        do {
            System.out.println(PrintaMenu.PRINCIPAL_MENU.get());
            System.out.print("Digite a opção: ");
            opcao = this.menu.receberInteiro(this.scan);
            switch (opcao) {
                case 1 -> atorMenu.run();
                case 2 -> diretorMenu.run();
                case 3 -> filmeMenu.run();
                case 0 -> scan.close();
                default -> {
                    System.out.println("opção inválida;");
                }
            }
        } while (opcao != 0);
    }
}