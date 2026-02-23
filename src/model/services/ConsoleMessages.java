// Classe responsável pela exibição das mensagens de operação do sistema no console.

package model.services;

public class ConsoleMessages {

	// Método responsável por exibir o menu inicial do sistema.
	public static void printStartMenu() {
	    System.out.println("=============================================================================================");
	    System.out.println("                               Sistema de Controle de Estoque                                ");
	    System.out.println("=============================================================================================");
	    System.out.println();
	    System.out.println("Opções disponíveis:");
	    System.out.println("- Gerenciar funcionários");
	    System.out.println("- Gerenciar produtos e estoque");
	    System.out.println("- Consultar relatórios de quantidade e valor em estoque");
	    System.out.println("=============================================================================================");
	    System.out.println("Desenvolvido por: Leonardo Raspante - RU 4324217");
	    System.out.println("=============================================================================================");
	}

	// Método responsável por exibir o submenu de funcionários.
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
	
	// Método responsável por exibir o submenu de estoque.
	public static void printInventoryMenu() {
	    System.out.println("=============================================================================================");
	    System.out.println("                                  Gerenciamento de Estoque                                   ");
	    System.out.println("=============================================================================================");
	    System.out.println();
	    System.out.println("Opções disponíveis:");
	    System.out.println("- Cadastrar produto");
	    System.out.println("- Dar baixa em produto");
	    System.out.println("- Consultar itens cadastrados");
	    System.out.println("- Ver quantidade total e valor total em estoque");
	    System.out.println("- Voltar ao menu principal");
	    System.out.println("=============================================================================================");
	}
	
	// Método responsável por exibir a confirmação de cadastro de funcionário.
	public static void printEmployeeRegisteredMessage() {
		System.out.println("=============================================================================================");
		System.out.println("Funcionário cadastrado com sucesso!");
		System.out.println("=============================================================================================");
	}
	
	// Método responsável por exibir a mensagem confirmando o cadastro de produto.
	public static void printProductRegisteredMessage() {
		System.out.println("=============================================================================================");
		System.out.println("Produto cadastrado com sucesso!");
		System.out.println("=============================================================================================");
	}
	
	// Método responsável por exibir a mensagem confirmando a baixa de produto.
	public static void printProductRemovedMessage() {
		System.out.println("=============================================================================================");
		System.out.println("Baixa de produto realizada com sucesso!");
		System.out.println("=============================================================================================");	
	}
	
	// Método responsável por exibir o menu de consulta de estoque.
	public static void printInventoryConsultedMessage() {
		System.out.println("=============================================================================================");
		System.out.println("Consulta realizada com sucesso!");
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
