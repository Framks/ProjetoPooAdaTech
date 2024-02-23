package view;

public enum PrintaMenu {
    ATOR_MENU("### Ator ###\n" +
            "1 - ver Atores\n" +
            "2 - cadastrar Ator\n" +
            "3 - procurar filmes por Ator\n" +
            "4 - procurar ator por nome\n"+
            "0 - exit : "),
    PRINCIPAL_MENU("### MENU ###\n" +
            "1 - Atores\n" +
            "2 - Diretores\n" +
            "3 - Filmes\n" +
            "0 - exit : "),

    DIRETOR_MENU("### Diretor ###\n" +
            "1 - ver Diretores\n" +
            "2 - cadastrar Diretor\n" +
            "3 - procurar filmes por diretor\n" +
            "4 - procurar diretor por nome\n"+
            "0 - exit : "),

    FILME_MENU("### Filme ###\n" +
            "1 - ver filmes\n" +
            "2 - buscar por nome\n" +
            "3 - Adicionar Ator à filme\n" +
            "4 - Adicionar Diretor à filme\n" +
            "5 - cadastrar filme\n" +
            "0 - exit : "),
    OPCAO_EDIT_ATOR("vamos Selecionar os atores: \n" +
                            "1 - para cadastrar um novo \n" +
                            "2 - para selecionar um existente\n" +
                            "0 - para sair: "),
    OPCAO_EDIT_DIRETOR("vamos Selecionar os diretores: \n" +
            "1 - para cadastrar um novo \n" +
            "2 - para selecionar um existente\n" +
            "0 - para sair: ");

    private final String menuString;

    PrintaMenu(String menuString) {
        this.menuString = menuString;
    }

    public String get() {
        return menuString;
    }
}


