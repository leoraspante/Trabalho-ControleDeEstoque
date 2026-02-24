/* Classe resonsável pela exibição das mensagens relacionadas ao menu principal do sistema.
   Incluindo tela inicial e mensagens de encerramento. */

package view.console;

public final class SystemMenuMessages {

	// Método responsável por exibir o menu inicial do sistema.
	public static void printStartMenu() {
	    System.out.println("=============================================================================================");
	    System.out.println("                               Sistema de Controle de Estoque                                ");
	    System.out.println("=============================================================================================");
	    System.out.println();
	    System.out.println("Opções disponíveis:");
	    System.out.println("(1) Gerenciar funcionários.");
	    System.out.println("(2) Gerenciar produtos e estoque.");
	    System.out.println("(3) Consultar relatórios de quantidade e valor em estoque.");
	    System.out.println("=============================================================================================");
	    System.out.println("Desenvolvido por: Leonardo Raspante - RU 4324217");
	    System.out.println("=============================================================================================");
	}
	
	// Método responsável por exibir a mensagem de encerramento do sistema.
	public static void printSystemExitMessage() {
		System.out.println("=============================================================================================");
		System.out.println("Encerrando o Sistema de Controle de Estoque...");
		System.out.println("Obrigado por utilizar nosso programa!");
		System.out.println("=============================================================================================");	
	}
	
}
