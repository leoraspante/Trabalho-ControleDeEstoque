/* Classe responsável por exibir mensagens do menu principal do sistema,
   incluindo a tela inicial e mensagens de encerramento. */

package view.console;

public final class SystemMenuMessages {

	// Separador padronizado.
    private static final String SEPARATOR = "==============================================================================================================";

    // Menu inicial do sistema
    public static void printStartMenu() {
        System.out.println(SEPARATOR);
        System.out.println("                                     Sistema de Controle de Estoque                                      ");
        System.out.println(SEPARATOR);
        System.out.println("Desenvolvido por: Leonardo Raspante - RU 4324217");
        System.out.println(SEPARATOR);
        System.out.println("Opções disponíveis:");
        System.out.println("(1) Gerenciar funcionários.");
        System.out.println("(2) Gerenciar produtos e estoque.");
        System.out.println("(3) Consultar relatórios de quantidade e valor em estoque.");
        System.out.println("(4) Sair do sistema.");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    // Mensagem de encerramento
    public static void printSystemExitMessage() {
        System.out.println(SEPARATOR);
        System.out.println("Encerrando o Sistema de Controle de Estoque...");
        System.out.println("Obrigado por utilizar nosso programa!");
        System.out.println(SEPARATOR);
        System.out.println("Desenvolvido por: Leonardo Raspante - RU 4324217, voltado a fins acadêmicos.");
    }
}