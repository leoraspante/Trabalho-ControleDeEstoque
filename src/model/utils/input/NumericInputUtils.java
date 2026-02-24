/* Classe responsável pela leitura e validação de valores numéricos.
   Incluindo inteiros e números de ponto flutuante utilizados em operações do sistema. */

package model.utils.input;

import java.util.InputMismatchException;
import java.util.Scanner;

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
		
	// Método genérico responsável pela leitura e validação de valores de ponto flutuante dentro de um intervalo definido.
	public static Double readDouble(String msg, Scanner sc, Double minAllowed) {
		while (true) {
			try {
				System.out.print(msg);
				double value = sc.nextDouble();
				if(value < minAllowed) {
					System.out.printf("Valor inválido, tente novamente.%n");
					System.out.printf("Valor mínimo permitido: %d.%n%n", minAllowed);
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
	
}
