// Classe responsável pela leitura e validação dos valores digitados pelo usuário.

package model.utils.input;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.enums.Department;

public class InputUtils {

	// Método responsável pela leitura e validação de valores inteiros.
	public static Integer readProductQuantity(Scanner sc) {
		// Define os parâmetros de restrição referentes à quantidade mínima e máxima de itens armazenados por produto no estoque.
		Integer minQuantityAllowed = 1;
		Integer maxQuantityAllowed = 500;
		while (true) {
			try {
				System.out.print("Quantidade: ");
				int value = sc.nextInt();
				sc.nextLine();
				if(value < minQuantityAllowed || value > maxQuantityAllowed) {
					System.out.printf("Quantidade inválida de produtos, tente novamente.%n");
					System.out.printf("Mínimo de %d registro e máximo de %d registros por produto.%n%n", minQuantityAllowed, maxQuantityAllowed);
				}
				return value;
			} catch (InputMismatchException e) {
				System.out.printf("Apenas valores numéricos inteiros são aceitos, tente novamente.%n%n");
				sc.nextLine();
			}
		}
	}
	
	// Método responsável pela leitura e validação de valores inteiros.
	public static Integer readNumOfEmployees(Scanner sc) {
		// Define a quantidade mínima e máxima de registros simultâneos. 
		Integer minEmployeeAllowed = 1;
		Integer maxEmployeeAllowed = 5;
		while (true) {
			try {
				System.out.print("Quantos funcionários deseja cadastrar ? ");
				int value = sc.nextInt();
				sc.nextLine();
				if(value < minEmployeeAllowed || value > maxEmployeeAllowed) {
					System.out.printf("Quantidade inválida de registros simultâneos, tente novamente.%n");
					System.out.printf("Mínimo de %d registro e máximo de %d registros por operação.%n%n", minEmployeeAllowed, maxEmployeeAllowed);
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
	
	// Método responsável pela leitura e validação de valores inteiros.
	public static Integer readNumOfProducts(Scanner sc) {
		// Define a quantidade mínima e máxima de registros simultâneos. 
		Integer minEmployeeAllowed = 1;
		Integer maxEmployeeAllowed = 5;
		while (true) {
			try {
				System.out.print("Quantos produtos deseja cadastrar ? ");
				int value = sc.nextInt();
				sc.nextLine();
				if(value < minEmployeeAllowed || value > maxEmployeeAllowed) {
					System.out.printf("Quantidade inválida de registros simultâneos, tente novamente.%n");
					System.out.printf("Mínimo de %d registro e máximo de %d registros por operação.%n%n", minEmployeeAllowed, maxEmployeeAllowed);
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

	// Método responsável pela leitura e validação de valores de ponto flutuante.
	public static Double readDouble(String msg, Scanner sc) {
		while (true) {
			try {
				System.out.print(msg);
				double value = sc.nextDouble();
				return value;
			} catch (InputMismatchException e) {
				System.out.printf("Apenas valores numéricos são aceitos, tente novamente.%n%n");
				sc.nextLine();
			}
		}
	}

	// Método responsável pela leitura e validação de datas.
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Definição do formato de data.
	public static LocalDate readDate(String msg, Scanner sc) {
		while(true) {
			try {
				System.out.print(msg);
				LocalDate value = LocalDate.parse(sc.nextLine().trim(), fmt);
				return value;
			}
			catch(DateTimeException e) {
				System.out.printf("Formato de data inválido, tente novamente usando o seguinte formato: dd/MM/yyyy.%n%n");
			}
		}
	}
	
	// Método responsável pela leitura e validação de data/hora.
	private static DateTimeFormatter fmtHour = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // Definição do formato de data/hora.
	public static LocalDate getCurrentDateTime(String msg, Scanner sc) {
		while(true) {
			try {
				System.out.print(msg);
				LocalDate value = LocalDate.parse(sc.nextLine().trim(), fmtHour);
				return value;
			}
			catch(DateTimeException e) {
				System.out.printf("Formato de data inválido, tente novamente usando o seguinte formato: dd/MM/yyyy .%n%n");
			}
		}
	}
	
	// Método responsável pela leitura e validação de nomes de pessoas.
	public static String readName(Scanner sc) {
		while(true) {
			System.out.print("Nome: ");
			String value = sc.nextLine().trim();
			if(value.trim().isEmpty()) {
				System.out.printf("Espaços em branco não são aceitos, por favor tente novamente.%n%n");
			}
			else if(!value.matches("[A-Za-zÀ-ÿ ]+")) {
				System.out.printf("Nome inválido, por favor tente novamente.%n%n");
			}
			else {
				return value;
			}
		}
	}
	
	// Método responsável pela leitura e validação de endereços de email.
	// Optei por não usar a biblioteca "javax.mail.internet.InternetAddress" por se tratar de um projeto simples, voltado a didática.
	public static String readEmail(Scanner sc) {
		while(true) {
			System.out.print("Email: ");
			String value = sc.nextLine().trim();
			if(value.trim().isEmpty()) {
				System.out.printf("Espaços em branco não são aceitos, por favor tente novamente.%n%n");
			}
			else if(!value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
				System.out.printf("Endereço inválido, por favor tente novamente.%n%n");
			}
			else {
				return value;
			}
		}
	}
	
	// Método responsável pela leitura e validação de nomes de produtos.
	public static String readProductName(Scanner sc) {
		while(true) {
			System.out.print("Nome do Produto: ");
			String value = sc.nextLine().trim();
			if(value.trim().isEmpty()) {
				System.out.printf("Espaços em branco não são aceitos, por favor tente novamente.%n%n");
			}
			else if(!value.matches("[A-Za-zÀ-ÿ0-9\\-_. ]+")) {
				System.out.printf("Nome de produto inválido, por favor tente novamente.%n%n");
			}
			else {
				return value;
			}
		}
	}
	
	// Método responsável pela leitura e validação dos nomes correspondentes aos setores da organização.
	public static Department readDepartment (Scanner sc) {
		while(true) {
			try {
				System.out.print("Departamento: ");
				String input = sc.nextLine().trim().toUpperCase();
				Department value = Department.valueOf(input);
				return value;
			}
			catch(IllegalArgumentException e) {
				System.out.printf("Departamento inexistente, tente novamente.%n");
				System.out.printf("Opções válidas: ADMINISTRACAO, VENDAS, ESTOQUE, CONVIDADO.%n%n");
			}
		}
	}

}
