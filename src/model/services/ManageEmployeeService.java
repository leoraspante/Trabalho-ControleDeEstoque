// Classe responsável pela consolidação dos métodos responsáveis pela manipulação de funcionários.

package model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Employee;
import model.enums.Department;
import model.utils.input.DateInputUtils;
import model.utils.input.EnumInputUtils;
import model.utils.input.NumericInputUtils;
import model.utils.input.StringInputUtils;
import view.console.EmployeeMessages;

public class ManageEmployeeService {

	// Lista responsável pelo armazenamento dos funcionários cadastrados no sistema.
	public static final List<Employee> employees = new ArrayList<>();
	
	// Método responsável pelo cadastro de funcionários.
	public static void registerEmployee(Scanner sc) {
		
		// Exibição do menu de cadastro de funcionários.
		EmployeeMessages.printEmployeeRegisterMenu();
		
		// Captura do número de cadastros a serem realizados por operação, sendo 0 o mínimo e 5 o máximo de cadastros por operação.
		Integer numOfEmployees = NumericInputUtils.readIntegerInRange("Quantos funcionários deseja cadastrar ?: ", sc, 0, 5);
		
		// Loop for para controlar a quantidade de registros simultâneos.
		for(int i=0; i<numOfEmployees; i++) {
			System.out.printf("Registro do %dº funcionário:%n%n", i+1); // Exibição do número do registro em execução.
			
			// Coleta dos dados do funcionário. "Dados básicos apenas para fins didáticos".
			String name = StringInputUtils.readName(sc);
			Department department = EnumInputUtils.readDepartment(sc);
			String email = StringInputUtils.readEmail(sc);
			LocalDate birthDate = DateInputUtils.readDate("Data de nascimento: ", sc);
			LocalDate hireDate = DateInputUtils.readDate("Data de contratação: ", sc);
			
			Employee employee = new Employee(name, department, email, birthDate, hireDate); // Criação do objeto funcionário.
			
			employees.add(employee); // Adição do objeto funcionário a lista de funcionários.
			
			System.out.println(); // Espaçamento para melhor legibilidade.
		
		}
		EmployeeMessages.printEmployeeRegisteredMessage(); // Exibição da confirmação de cadastro dos funcionários.
	}
	
	// Método responsável pela navegação no menu de funcionários.
	public static void employeeMenuSystem(Scanner sc) {
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
	
	// Método responsável pela exibição dos funcionários cadastrados.
	public static void printRegisteredEmployees() {
		if(employees.isEmpty()) {
			EmployeeMessages.printNoEmployeesMessage();
		}
		else {
			EmployeeMessages.printEmployeeListHeader();
			for(Employee items : employees) {
				System.out.println(items);
			}
		}
	}
	
}
