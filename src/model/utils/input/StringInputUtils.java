/* Classe responsável pela leitura e validação de valores textuais.
   Como nomes de pessoas, nomes de produtos e endereços de email. */

package model.utils.input;

import java.util.Scanner;

public final class StringInputUtils {

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
	
	// Método responsável pela leitura e validação de endereços de email.
	// A validação é realizada por meio de expressões regulares, sem uso de bibliotecas externas.
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
	
}
