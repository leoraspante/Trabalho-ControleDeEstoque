/* Classe responsável pela leitura e validação de valores enumerados.
   Assegurando que os setores da organização sejam informados corretamente. */

package model.utils.input;

import java.util.Scanner;

import model.enums.Department;

public final class EnumInputUtils {

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
