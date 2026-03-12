// Classe responsável pela exibição de mensagens pertinentes a operações de funcionário.

package view.console;

public final class EmployeeMessages {

    private static final String SEPARATOR = "================================================================================================================================================";

    private static void printCenteredTitle(String title) {
        int totalWidth = SEPARATOR.length();
        int padding = (totalWidth - title.length()) / 2;
        System.out.println(SEPARATOR);
        System.out.printf("%" + padding + "s%s%n", "", title);
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printEmployeeMenu() {
        printCenteredTitle("Gerenciamento de Funcionários");
        System.out.println("Opções disponíveis:");
        System.out.println("(1) Cadastrar novo funcionário.");
        System.out.println("(2) Consultar lista de funcionários.");
        System.out.println("(3) Alteraração de dados.");
        System.out.println("(4) Voltar ao menu principal.");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printEmployeeEditMenu() {
        printCenteredTitle("Alteração de Dados");
        System.out.println("Opções disponíveis:");
        System.out.println("(1) Alterar nome.");
        System.out.println("(2) Alterar email.");
        System.out.println("(3) Alterar departamento.");
        System.out.println("(4) Alterar data de nascimento.");
        System.out.println("(5) Alterar data de contratação.");
        System.out.println("(6) Sair do menu de alterações.");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printNoIdFound() {
        printCenteredTitle("ID Não Encontrado");
    }

    public static void printEmployeeRegisterMenu() {
        printCenteredTitle("Cadastro de Novo Funcionário");
        System.out.println("Informe os dados necessários:");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    public static void printNoEmployeesMessage() {
        printCenteredTitle("Nenhum Funcionário Cadastrado");
    }

    public static void printEmployeeListHeader() {
        printCenteredTitle("Funcionários Cadastrados");
        System.out.printf("%-5s | %-35s | %-35s | %-20s | %-20s | %-15s%n",
            "ID", "Nome", "Email", "Data de Nascimento", "Departamento", "Contatação");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void printEmployeeRegisteredMessage() {
        printCenteredTitle("Cadastro de funcionário(s) realizado com sucesso!");
    }

    public static void printEmployeeConsultedMessage() {
        printCenteredTitle("Consulta realizada com sucesso!");
    }
}
