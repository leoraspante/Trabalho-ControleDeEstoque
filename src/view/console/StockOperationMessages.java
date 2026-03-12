// Classe responsável pela exibição de mensagens pertinentes a operações de estoque.

package view.console;

public final class StockOperationMessages {

    private static final String SEPARATOR = "================================================================================================================================================";

    private static void printCenteredTitle(String title) {
        int totalWidth = SEPARATOR.length();
        int padding = (totalWidth - title.length()) / 2;
        System.out.println(SEPARATOR);
        System.out.printf("%" + padding + "s%s%n", "", title);
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printNoOperationsMessage() {
        printCenteredTitle("Nenhuma Movimentação Registrada");
    }

    public static void printOperationsListHeader() {
        printCenteredTitle("Histórico de Movimentações de Estoque");
        System.out.printf(
        		"%-5s | %-20s | %-10s | %-10s | %-20s | %15s | %15s | %-12s%n",
        		"ID",
        		"Produto",
        		"Operação",
        		"Estoque",
        		"Data/Hora",
        		"Qtd Movimentada",
        		"Preço Alterado",
        		"Total R$"
        );
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

}
