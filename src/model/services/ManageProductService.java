// Classe responsável pela consolidação dos métodos responsáveis pela manipulação de produtos.

package model.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;
import model.utils.InputUtils;
import view.console.ProductMessages;

public class ManageProductService {

	// Lista responsável pelo armazenamento de produtos cadastrados no sistema.
	public static final List<Product> products = new ArrayList<>();
	
	// Método responsável pelo cadastro de produtos.
	public static void registerProduct(Scanner sc) {
		ProductMessages.printProductRegisterMenu(); // Exibição do menu de cadastro de produtos.
		Integer numOfProducts = InputUtils.readNumOfProducts(sc); // Captura do número de cadastros a serem realizados por operação.
		
		// Loop for para controlar a quantidade de registros simultâneos.
		for(int i=0; i<numOfProducts; i++) {
			System.out.printf("Registro do %dº produto:%n%n", i+1); // Exibição do número do registro em execução.
			
			// Coleta dos dados do produto. "Dados básicos apenas para fins didáticos".
			String name = InputUtils.readProductName(sc);
			String description = sc.nextLine().trim();
			Integer quantity = InputUtils.readProductQuantity(sc);
			LocalDateTime entryDate = 
		}
		
	}
}
