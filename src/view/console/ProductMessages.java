/* Classe responsável pela exibição de mensagens relacionadas à manipulação de produtos.
   Incluindo menus de gerenciamento e confirmações de operações sobre itens cadastrados. */

package view.console;

public final class ProductMessages {

	// Método responsável pela exibição do menu de estoque.
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
	
	// Método responsável pela exibição do menu de cadastro de produtos.
	public static void printProductRegisterMenu() {
	    System.out.println("=============================================================================================");
	    System.out.println("                           Cadastro de Novo Produto                                          ");
	    System.out.println("=============================================================================================");
	    System.out.println();
	    System.out.println("Informe os dados necessários:");
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
		
	// Método responsável por exibir a mensagem confirmando a consulta no estoque.
	public static void printInventoryConsultedMessage() {
		System.out.println("=============================================================================================");
		System.out.println("Consulta realizada com sucesso!");
		System.out.println("=============================================================================================");
	}
	
}
