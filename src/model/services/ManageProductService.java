// Classe responsável pela consolidação dos métodos responsáveis pela manipulação de produtos.

package model.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;
import model.utils.input.DateInputUtils;
import model.utils.input.NumericInputUtils;
import model.utils.input.StringInputUtils;
import view.console.ProductMessages;

public class ManageProductService {

	// Lista responsável pelo armazenamento de produtos cadastrados no sistema.
	public static final List<Product> products = new ArrayList<>();
	
	// Método responsável pelo cadastro de produtos.
	public static void registerProduct(Scanner sc) {
		
		// Exibição do menu de cadastro de produtos.
		ProductMessages.printProductRegisterMenu(); 
		
		// Captura do número de cadastros a serem realizados por operação, sendo 0 o mínimo e 5 o máximo de cadastros por operação.
		Integer numOfProducts = NumericInputUtils.readIntegerInRange("Quantos produtos deseja cadastrar ?: ", sc , 0, 5); 
		
		// Loop for para controlar a quantidade de registros simultâneos.
		for(int i=0; i<numOfProducts; i++) {
			System.out.printf("Registro do %dº produto:%n%n", i+1); // Exibição do número do registro em execução.
			
			// Coleta dos dados do produto. "Dados básicos apenas para fins didáticos".
			String name = StringInputUtils.readProductName(sc);
			String description = sc.nextLine().trim();
			Integer quantity = NumericInputUtils.readIntegerInRange("Quantidade: ", sc , 1, 5000); // Mínimo de 1 item e máximo de 5000 itens.
			LocalDateTime entryDate = DateInputUtils.getCurrentDateTime(); // Realiza automaticamente o registro de data/hora no ato do cadastro do produto.
			Double price = NumericInputUtils.readDouble("Preço R$: ", sc, 0.0); // Valor mínimo permitido para registro de produto de 0.0.
			
			Product product = new Product(name, description, quantity, entryDate, price); // Criação do objeto produto.
			
			products.add(product); // Adição do objeto produto a lista de produtos.
			
			System.out.println(); // Espaçamento para melhor legibilidade.
		}
		ProductMessages.printProductRegisteredMessage(); // Exibição da confirmação de cadastro dos produtos.
	}
	
}
