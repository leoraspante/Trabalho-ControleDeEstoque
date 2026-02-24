// Classe responsável pela consolidação dos métodos responsáveis pela manipulação de funcionários.

package model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Employee;
import model.enums.Department;
import model.utils.input.InputUtils;
import view.console.EmployeeMessages;

public class ManageEmployeeService {

	// Lista responsável pelo armazenamento dos funcionários cadastrados no sistema.
	public static final List<Employee> employees = new ArrayList<>();
	
	// Método responsável pelo cadastro de funcionários.
	public static void registerEmployee(Scanner sc) {
		EmployeeMessages.printEmployeeRegisterMenu(); // Exibição do menu de cadastro de funcionários.
		Integer numOfEmployees = InputUtils.readNumOfEmployees(sc); // Captura do número de cadastros a serem realizados por operação.
		
		// Loop for para controlar a quantidade de registros simultâneos.
		for(int i=0; i<numOfEmployees; i++) {
			System.out.printf("Registro do %dº funcionário:%n%n", i+1); // Exibição do número do registro em execução.
			
			// Coleta dos dados do funcionário. "Dados básicos apenas para fins didáticos".
			String name = InputUtils.readName(sc);
			Department department = InputUtils.readDepartment(sc);
			String email = InputUtils.readEmail(sc);
			LocalDate birthDate = InputUtils.readDate("Data de nascimento: ", sc);
			LocalDate hireDate = InputUtils.readDate("Data de contratação: ", sc);
			
			Employee employee = new Employee(name, department, email, birthDate, hireDate); // Criação do objeto funcionário.
			
			employees.add(employee); // Adição do objeto funcionário a lista de funcionários.
			
			System.out.println(); // Espaçamento para melhor legibilidade.
		
		}
		EmployeeMessages.printEmployeeRegisteredMessage(); // Exibição da confirmação de cadastro dos funcionários.
	}
	
	
	
}
