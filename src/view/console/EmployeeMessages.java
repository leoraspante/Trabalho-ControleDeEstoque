/* Classe responsável por exibir mensagens relacionadas ao gerenciamento de funcionários,
   incluindo menus de cadastro, consulta e confirmações de operações. */

package view.console;

public final class EmployeeMessages {

    // Separador padronizado.
    private static final String SEPARATOR = "==============================================================================================================";

    // Menu de gerenciamento de funcionários
    public static void printEmployeeMenu() {
        System.out.println(SEPARATOR);
        System.out.println("                                     Gerenciamento de Funcionários                                      ");
        System.out.println(SEPARATOR);
        System.out.println();
        System.out.println("Opções disponíveis:");
        System.out.println("(1) Cadastrar novo funcionário");
        System.out.println("(2) Consultar lista de funcionários");
        System.out.println("(3) Voltar ao menu principal");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    // Menu de cadastro de funcionários
    public static void printEmployeeRegisterMenu() {
        System.out.println(SEPARATOR);
        System.out.println("                                     Cadastro de Novo Funcionário                                      ");
        System.out.println(SEPARATOR);
        System.out.println();
        System.out.println("Informe os dados necessários:");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    // Nenhum funcionário cadastrado
    public static void printNoEmployeesMessage() {
        System.out.println(SEPARATOR);
        System.out.println("                                     Nenhum Funcionário Cadastrado                                     ");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    // Cabeçalho da lista de funcionários
    public static void printEmployeeListHeader() {
        System.out.println(SEPARATOR);
        System.out.println("                                     Lista de Funcionários Cadastrados                                 ");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    // Confirmação de cadastro
    public static void printEmployeeRegisteredMessage() {
        System.out.println(SEPARATOR);
        System.out.println("Cadastro de funcionário(s) realizado com sucesso!");
        System.out.println(SEPARATOR);
    }

    // Confirmação de consulta
    public static void printEmployeeConsultedMessage() {
        System.out.println(SEPARATOR);
        System.out.println("Consulta realizada com sucesso!");
        System.out.println(SEPARATOR);
    }
}