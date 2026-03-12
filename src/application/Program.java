// Programa simples de controle de estoque e cadastro de funcionários.

/* A idéia é futuramente implementar um sistema de login para validação de usuários, permitindo alterações no sistema
   tendo como base os privilégios de usuários. (Por isso o cadastro de usuários).
   Algo que no momento não sei fazer. */

/* A nomeação de classes e variáveis estão em ingles por motivos de tornar o código legível a um maior número de pessoas
   e também por se tratar de uma prática minha de programação.
   Os comentários serão realizados no idioma PT-BR. */

// Main class do programa.

package application;

import java.util.Locale;
import java.util.Scanner;

import model.services.ManageSystemService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US); // Define o uso de ponto como separador decimal.
		Scanner sc = new Scanner(System.in);
		
		ManageSystemService.manageMenuSystem(sc);
		
		sc.close();
	}
}
