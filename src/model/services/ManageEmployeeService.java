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
	
//=================================================================================================================================================================//	
	
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
	
//=================================================================================================================================================================//
	
	// Método responsável pela navegação no menu de funcionários.
	public static void employeeMenuSystem(Scanner sc) {
		while(true) {
			EmployeeMessages.printEmployeeMenu();
			
			// Implementação de um switch-case controlando a navegação entre as opções do menu de funcionário.
			// Valores aceitos desde 1 até 4, coincidindo com as opções disponíveis no menu "Gerencimento de Funcionários".
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 4)) {
			case 1:
				// Case 1: Responsável pelo cadastro de funcionários.
				registerEmployee(sc);
				break;
			case 2:
				// Case 2: Responsável por listar funcionários cadastrados.
				printRegisteredEmployees();
				break;
			case 3:
				// Case 3: Responsável pela alteração de dados.
				editRegisteredEmployees(sc);
				break;
			case 4:
				// Case 4: Responsável por retornar ao menu inicial.
				return;	
			}
		}
	}
	
//=================================================================================================================================================================//
	
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
	
//=================================================================================================================================================================//
	
	// Método responsável pela alteração dos dados de funcionários cadastrados.
	public static void editRegisteredEmployees(Scanner sc) {
		if(employees.isEmpty()) {
			EmployeeMessages.printNoEmployeesMessage();
			return;
		} 
		
		while(true) {
			// Exibe a lista de funcionários antes da edição.
			printRegisteredEmployees();
			EmployeeMessages.printEmployeeEditMenu();
				
			Integer idSelected = NumericInputUtils.readEmployeeId(sc);
			
			if (idSelected == 0) {
			    return; // Sai do método e volta ao menu principal
			}
			
			// Busca funcionário pelo ID.
			Employee employeeToEdit = null;
			for(Employee employee : employees) {
				if(employee.getId().equals(idSelected)) {
					employeeToEdit = employee;
					break;
				}
			}
			
			// Caso funcionário não seja encontrado, apresenta a mensagem e volta ao início do loop.
			if(employeeToEdit == null) {
				EmployeeMessages.printNoIdFound();
				continue;
			}	
			
			
			// Menu de edição do funcionário encontrado.
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 6)) {
				case 1:
					// Case 1: Responsável pela alteração de nome.
					String newName = StringInputUtils.readName(sc);
					employeeToEdit.setName(newName);
					System.out.printf("Nome atualizado!%nDados atuais:%n%n");
					System.out.println(employeeToEdit);
					System.out.println();
					break;
				case 2:
					// Case 2: Responsável pela alteração de email.
					String newEmail = StringInputUtils.readEmail(sc);
					employeeToEdit.setEmail(newEmail);
					System.out.printf("Email atualizado!%nDados atuais:%n%n");
					System.out.println(employeeToEdit);
					System.out.println();
					break;
				case 3:
					// Case 3: Responsável pela alteração de departamento.
					Department newDepartment = EnumInputUtils.readDepartment(sc);
					employeeToEdit.setDepartment(newDepartment);
					System.out.printf("Departamento atualizado!%nDados atuais:%n%n");
					System.out.println(employeeToEdit);
					System.out.println();
					break;
				case 4:
					// Case 4: Responsável pela alteração da data de nascimento.
					LocalDate newBirthDate = DateInputUtils.readDate("Data de nascimento: ", sc);
					employeeToEdit.setBirthDate(newBirthDate);
					System.out.printf("Data de nascimento atualizada!%nDados atuais:%n%n");
					System.out.println(employeeToEdit);
					System.out.println();
					break;
				case 5:
					// Case 5: Responsável pela alteração da data de contratação.
					LocalDate newHireDate = DateInputUtils.readDate("Data de contratação: ", sc);
					employeeToEdit.setHireDate(newHireDate);
					System.out.printf("Data de contratação atualizada!%nDados atuais:%n%n");
					System.out.println(employeeToEdit);
					System.out.println();
					break;
				case 6:
					return;
			}
		}
	}
	
	
}
