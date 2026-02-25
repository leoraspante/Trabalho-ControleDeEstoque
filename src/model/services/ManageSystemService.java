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
				ManageEmployeeService.employeeMenuSystem(sc);
				break;
			case 2:
				// Case 2: Responsável pelo gerenciamento de produtos e estoque.
				manageProductSystem(sc);
				break;
			case 3:
				//Case 3: Responsável pelo gerenciamento de relatórios.
				// Implementar gerenciamento de relatórios.
				break;
			case 4:
				// Case 4: Responsável pelo encerramento do sistema.
				SystemMenuMessages.printSystemExitMessage();
				return;					
			}
		}
	}
	
	
	
	
	
}
