/* Classe responsável pela exibição das mensagens relacionadas à manipulação de funcionários.
   Incluindo menus de cadastro, consulta e confirmações de operações. */

package view.console;

public final class EmployeeMessages {

	// Método responsável pela exibição do menu de gerenciamento de funcionários.
	public static void printEmployeeMenu() {
	    System.out.println("=============================================================================================");
	    System.out.println("                               Gerenciamento de Funcionários                                 ");
	    System.out.println("=============================================================================================");
	    System.out.println();
	    System.out.println("Opções disponíveis:");
	    System.out.println("- Cadastrar novo funcionário");
	    System.out.println("- Consultar lista de funcionários");
	    System.out.println("- Voltar ao menu principal");
	    System.out.println("=============================================================================================");
	}
	
	// Método responsável pela exibição do menu de cadastro de funcionários.
	public static void printEmployeeRegisterMenu() {
	    System.out.println("=============================================================================================");
	    System.out.println("                           Cadastro de Novo Funcionário                                      ");
	    System.out.println("=============================================================================================");
	    System.out.println();
	    System.out.println("Informe os dados necessários:");
	    System.out.println("=============================================================================================");
	}
	
	// Método responsável por exibir a confirmação de cadastro de funcionário.
	public static void printEmployeeRegisteredMessage() {
		System.out.println("=============================================================================================");
		System.out.println("Cadastro de funcionário(s) realizado com sucesso!");
		System.out.println("=============================================================================================");
	}
	
	// Método responsável por exibir a mensagem confirmando a consulta de funcionários cadastrados no sistema.
	public static void printEmployeeConsultedMessage() {
	    System.out.println("=============================================================================================");
	    System.out.println("Consulta realizada com sucesso!");
	    System.out.println("=============================================================================================");
	}
}
