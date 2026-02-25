/* Classe responsável por exibir mensagens relacionadas ao gerenciamento de produtos,
   abrangendo menus de estoque e confirmações de operações sobre itens cadastrados. */

package view.console;

public final class ProductMessages {

	// Separador padronizado.
    private static final String SEPARATOR = "================================================================================================================================================";

    // Menu de estoque
    public static void printInventoryMenu() {
        System.out.println(SEPARATOR);
        System.out.println("                                     Gerenciamento de Estoque                                      ");
        System.out.println(SEPARATOR);
        System.out.println();
        System.out.println("Opções disponíveis:");
        System.out.println("(1) Cadastrar produto");
        System.out.println("(2) Dar baixa em produto");
        System.out.println("(3) Consultar itens cadastrados");
        System.out.println("(4) Ver quantidade total e valor total em estoque");
        System.out.println("(5) Voltar ao menu principal");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    // Menu de cadastro de produtos
    public static void printProductRegisterMenu() {
        System.out.println(SEPARATOR);
        System.out.println("                                     Cadastro de Novo Produto                                      ");
        System.out.println(SEPARATOR);
        System.out.println();
        System.out.println("Informe os dados necessários:");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    // Nenhum produto cadastrado
    public static void printNoProductsMessage() {
        System.out.println(SEPARATOR);
        System.out.println("                                     Nenhum Produto Cadastrado                                     ");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    // Cabeçalho da lista de produtos
    public static void printProductListHeader() {
        System.out.println(SEPARATOR);
        System.out.println("                                     Lista de Produtos Cadastrados                                 ");
        System.out.println(SEPARATOR);
        System.out.printf("%-5s | %-25s | %-35s | %-15s | %-20s | %-10s%n", "ID", "Nome", "Descrição", "Quantidade", "Data de entrada", "Valor R$");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    // Confirmação de cadastro
    public static void printProductRegisteredMessage() {
        System.out.println(SEPARATOR);
        System.out.println("Produto cadastrado com sucesso!");
        System.out.println(SEPARATOR);
    }

    // Confirmação de baixa
    public static void printProductRemovedMessage() {
        System.out.println(SEPARATOR);
        System.out.println("Baixa de produto realizada com sucesso!");
        System.out.println(SEPARATOR);
    }

    // Confirmação de consulta
    public static void printInventoryConsultedMessage() {
        System.out.println(SEPARATOR);
        System.out.println("Consulta realizada com sucesso!");
        System.out.println(SEPARATOR);
    }
}