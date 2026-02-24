// Programa simples de controle de estoque, main class.

/* A nomeação de classes e variáveis estão em ingles por motivos de tornar o código legível a um maior número de pessoas
   e também por se tratar de uma prática minha de programação.
   Os comentários serão realizados no idioma PT-BR. */

package application;

import java.util.Locale;
import java.util.Scanner;

import model.services.ManageEmployeeService;
import model.services.ManageSystemService;
import view.console.SystemMenuMessages;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US); // Define o uso de ponto como separador decimal.
		Scanner sc = new Scanner(System.in);
		
		ManageSystemService.manageMenuSystem(sc);
		
		sc.close();
	}
}
