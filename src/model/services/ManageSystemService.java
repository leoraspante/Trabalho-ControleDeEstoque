// Classe responsável pela navegação no sistema.

package model.services;

import java.util.Scanner;

import model.utils.input.NumericInputUtils;
import view.console.EmployeeMessages;
import view.console.ProductMessages;
import view.console.SystemMenuMessages;

public final class ManageSystemService {

	// Método responsável pela navegação no menu principal do sistema.
	public static void manageMenuSystem(Scanner sc) {
		while(true) {
			SystemMenuMessages.printStartMenu();
			
			// Implementação de um switch-case controlando a navegação entre as opções do sistema.
			// Valores aceitos desde 1 até 4, coincidindo com as opções disponíveis no menu inicial.
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 4)) {
			case 1:
				// Case 1: Responsável pelo gerenciamento de funcionários.
				manageEmployeeSystem(sc);
				break;
			case 2:
				// Implementar gerenciamento de produtos e estoque.
				break;
			case 3:
				// Implementar gerenciamento de relatórios.
				break;
			case 4:
				// Case 4: Responsável pelo encerramento do sistema.
				SystemMenuMessages.printSystemExitMessage();
				return;					
			}
		}
	}
	
	// Método responsável pela navegação no menu de funcionários.
	public static void manageEmployeeSystem(Scanner sc) {
		while(true) {
			EmployeeMessages.printEmployeeMenu();
			
			// Implementação de um switch-case controlando a navegação entre as opções do menu de funcionário.
			// Valores aceitos desde 1 até 3, coincidindo com as opções disponíveis no menu de cadastro de funcionários.
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 3)) {
			case 1:
				// Case 1: Responsável pelo cadastro de funcionários.
				ManageEmployeeService.registerEmployee(sc);
				break;
			case 2:
				// Case 2: Responsável por listar funcionários cadastrados.
				ManageEmployeeService.printRegisteredEmployees();
				break;
			case 3:
				// Case 3: Responsável por retornar ao menu inicial.
				return;	
			}
		}
	}
	
	// Método responsável pela navegação no menu de produtos.
	public static void manageProductSystem(Scanner sc) {
		while(true) {
			ProductMessages.printInventoryMenu();
			
			// Implementação de um switch-case controlando a navegação entre as opções do menu de estoque.
			// Valores aceitos desde 1 até 5, coincidindo com as opções disponíveis no menu de estoque.
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 5)) {
			case 1:
				// Case 1: Responsável pelo cadastro de produtos.
				ManageProductService.registerProduct(sc);
				break;
			case 2:
				// Case 2: Responsável pela baixa de produtos.
				// Implementar.
				break;
			case 3:
				// Case 3: Responsável pela consulta dos itens no estoque.
				// Implementar.
				break;
			case 4:
				// Case 4: Responsável por uma consulta mais detalhada ao estoque, informando valores totais armazenados.
				// Implementar.
				break;
			case 5:
				// Case 5: Responsável por retornar ao menu inicial.
				return;	
			}
		}
	}
	
}
