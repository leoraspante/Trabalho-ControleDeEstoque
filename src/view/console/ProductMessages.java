// Classe responsável pela exibição de mensagens pertinentes a operações de produtos.

package view.console;

public final class ProductMessages {

    private static final String SEPARATOR = "================================================================================================================================================";

    private static void printCenteredTitle(String title) {
        int totalWidth = SEPARATOR.length();
        int padding = (totalWidth - title.length()) / 2;
        System.out.println(SEPARATOR);
        System.out.printf("%" + padding + "s%s%n", "", title);
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printInventoryMenu() {
        printCenteredTitle("Gerenciamento de Estoque");
        System.out.println("Opções disponíveis:");
        System.out.println("(1) Cadastrar produto.");
        System.out.println("(2) Dar baixa em produto.");
        System.out.println("(3) Ajustar estoque.");
        System.out.println("(4) Consultar estoque.");
        System.out.println("(5) Registro de movimentações.");
        System.out.println("(6) Voltar ao menu principal");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printProductEditMenu() {
        printCenteredTitle("Alteração de Dados");
        System.out.println("Opções disponíveis:");
        System.out.println("(1) Alterar nome.");
        System.out.println("(2) Alterar descrição.");
        System.out.println("(3) Alterar quantidade.");
        System.out.println("(4) Alterar preço.");
        System.out.println("(5) Sair do menu de alterações.");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printRemoveFromStockMenu() {
        printCenteredTitle("Baixa de Produtos");
        System.out.println("Opções disponíveis:");
        System.out.println("(1) Realizar baixa no estoque.");
        System.out.println("(2) Sair do menu de baixa.");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printNoIdFound() {
        printCenteredTitle("ID Não Encontrado");
    }

    public static void printProductRegisterMenu() {
        printCenteredTitle("Cadastro de Novo Produto");
        System.out.println("Informe os dados necessários:");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printNoProductsMessage() {
        printCenteredTitle("Nenhum Produto Cadastrado");
    }

    public static void printProductListHeader() {
        printCenteredTitle("Lista de Produtos Cadastrados");
        System.out.printf("%-5s | %-25s | %-35s | %-15s | %-20s | %-10s | %-10s%n",
            "ID", "Nome", "Descrição", "Quantidade", "Data de entrada", "Valor R$", "Total R$");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void printProductRegisteredMessage() {
        printCenteredTitle("Produto cadastrado com sucesso!");
    }

    public static void printProductRemovedMessage() {
        printCenteredTitle("Baixa de produto realizada com sucesso!");
    }

    public static void printInventoryConsultedMessage() {
        printCenteredTitle("Consulta realizada com sucesso!");
    }
}
