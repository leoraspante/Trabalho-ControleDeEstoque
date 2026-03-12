/* Classe responsável pela leitura e validação de valores numéricos.
   Incluindo inteiros e números de ponto flutuante utilizados em operações do sistema. */

package model.utils.input;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.entities.Employee;
import model.entities.Product;
import model.services.ManageEmployeeService;
import model.services.ManageProductService;

public final class NumericInputUtils {

	// Método genérico responsável pela leitura e validação de valores inteiros dentro de um intervalo definido.
	public static Integer readIntegerInRange(String msg, Scanner sc, Integer minAllowed, Integer maxAllowed) {
		while (true) {
			try {
				System.out.print(msg);
				int value = sc.nextInt();
				sc.nextLine();
				if(value < minAllowed || value > maxAllowed) {
					System.out.printf("Valor inválido, tente novamente.%n");
					System.out.printf("Valor mínimo: %d e máximo: %d permitidos.%n%n", minAllowed, maxAllowed);
				}
				else {
					return value;
				}
				
			} catch (InputMismatchException e) {
				System.out.printf("Apenas valores numéricos inteiros são aceitos, tente novamente.%n%n");
				sc.nextLine();
			}
		}
	}
	
//=================================================================================================================================================================//	
	
	// Método responsável pela leitura e validação de ID's de funcionários para atualização de cadastro.
	
	private static List<Employee> employees = ManageEmployeeService.employees;
	
	public static Integer readEmployeeId(Scanner sc) {
		while (true) {
			try {
				System.out.print("Informe o ID do funcionário que deseja alterar (ou 0 para voltar): ");
				int value = sc.nextInt();
				sc.nextLine();
				if(value < 0 || value > employees.size()) {
					System.out.printf("Funcionário não encontrado, tente novamente.%n%n");
				}
				else {
					return value;
				}
				
			} catch (InputMismatchException e) {
				System.out.printf("Apenas valores numéricos inteiros são aceitos, tente novamente.%n%n");
				sc.nextLine();
			}
		}
	}
	
//=================================================================================================================================================================//	
	
	// Método responsável pela leitura e validação de ID's de produtos para atualização de cadastro.
	
	private static List<Product> products = ManageProductService.products;
	
	public static Integer readProductId(Scanner sc) {
		while (true) {
			try {
				System.out.print("Informe o ID do produto que deseja alterar (ou 0 para voltar): ");
				int value = sc.nextInt();
				sc.nextLine();
				if(value < 0 || value > products.size()) {
					System.out.printf("Produto não encontrado, tente novamente.%n%n");
				}
				else {
					return value;
				}
				
			} catch (InputMismatchException e) {
				System.out.printf("Apenas valores numéricos inteiros são aceitos, tente novamente.%n%n");
				sc.nextLine();
			}
		}
	}
		
//=================================================================================================================================================================//	
	
	// Método genérico responsável pela leitura e validação de valores de ponto flutuante dentro de um intervalo definido.
	public static Double readDouble(String msg, Scanner sc, Double minAllowed) {
		while (true) {
			try {
				System.out.print(msg);
				double value = sc.nextDouble();
				sc.nextLine();
				if(value < minAllowed) {
					System.out.printf("Valor inválido, tente novamente.%n");
					System.out.printf("Valor mínimo permitido: %.2f%n%n", minAllowed);
				}
				else {
					return value;
				}
			} catch (InputMismatchException e) {
				System.out.printf("Apenas valores numéricos são aceitos, tente novamente.%n%n");
				sc.nextLine();
			}
		}
	}
	
//=================================================================================================================================================================//	
	
}
