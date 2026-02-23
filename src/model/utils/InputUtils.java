// Classe responsável pela leitura e validação dos valores digitados pelo usuário.

package model.utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

	// Método responsável pela leitura e validação de valores inteiros.
	public static Integer readInt(String msg, Scanner sc) {
		while (true) {
			try {
				System.out.print(msg);
				int value = sc.nextInt();
				sc.nextLine();
				return value;
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
	public static LocalDate readDate(String msg, Scanner sc, DateTimeFormatter fmt) {
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
	
	// Método responsável pela leitura e validação de nomes de pessoas.
	public static String readName(String msg, Scanner sc) {
		while(true) {
			System.out.print(msg);
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
	
	// Método responsável pela leitura e validação de nomes de produtos.
	public static String readProductName(String msg, Scanner sc) {
		while(true) {
			System.out.print(msg);
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
	

}
