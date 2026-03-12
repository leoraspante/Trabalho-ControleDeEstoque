// Classe responsável pela exibição de mensagens pertinentes a operações no menu principal.

package view.console;

public final class SystemMenuMessages {

    private static final String SEPARATOR = "================================================================================================================================================";

    // Método utilitário
    private static void printCenteredTitle(String title) {
        int totalWidth = SEPARATOR.length();
        int padding = (totalWidth - title.length()) / 2;
        System.out.println(SEPARATOR);
        System.out.printf("%" + padding + "s%s%n", "", title);
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printStartMenu() {
        printCenteredTitle("Sistema de Controle de Estoque");
        System.out.println("Desenvolvido por: Leonardo Raspante - RU 4324217");
        System.out.println(SEPARATOR);
        System.out.println("Opções disponíveis:");
        System.out.println("(1) Gerenciar funcionários.");
        System.out.println("(2) Gerenciar produtos e estoque.");
        System.out.println("(3) Consultar relatórios de movimentação.");
        System.out.println("(4) Sair do sistema.");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printSystemExitMessage() {
        printCenteredTitle("Encerrando o Sistema de Controle de Estoque...");
        System.out.println("Obrigado por utilizar nosso programa!");
        System.out.println(SEPARATOR);
        System.out.println("Desenvolvido por: Leonardo Raspante - RU 4324217, voltado a fins acadêmicos.");
    }
}
