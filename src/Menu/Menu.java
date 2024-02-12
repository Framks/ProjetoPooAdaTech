package Menu;

public class Menu {

    public void printMenuPrincipal(){
        System.out.println("#### Projeto Filmes #####");
        System.out.println("1 - Ator");
        System.out.println("2 - Diretor");
        System.out.println("3 - Filme");
    }

    public void printMenuAtor(){
        System.out.println("### Ator ###");
        System.out.println("1 - ver Atores");
        System.out.println("2 - cadastrar Ator");
        System.out.println("3 - vincular Ator à filme");
        System.out.println("4 - exit");
    }

    public void printMenuDiretor(){
        System.out.println("### Diretor ###");
        System.out.println("1 - ver Diretores");
        System.out.println("2 - cadastrar Diretor");
        System.out.println("3 - vincular Diretor à filme");
    }

    public void printMenuFilme(){
        System.out.println("### Filme ###");
        System.out.println("1 - ver filmes");
        System.out.println("2 - buscar por nome");
        System.out.println("3 - cadastrar filme");
    }
    // na hora de vincular um ator ou diretor a um filme nós podemos passar por parametro o filme e la fazer finculação
}
