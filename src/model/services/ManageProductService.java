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
			System.out.print("Descrição: ");
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
	
	// Método responsável pela navegação no menu de produtos.
	public static void productMenuSystem(Scanner sc) {
		while(true) {
			ProductMessages.printInventoryMenu();
			
			// Implementação de um switch-case controlando a navegação entre as opções do menu de estoque.
			// Valores aceitos desde 1 até 5, coincidindo com as opções disponíveis no menu de estoque.
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 5)) {
			case 1:
				// Case 1: Responsável pelo cadastro de produtos.
				ManageProductService.registerProduct(sc);
				break;
			case 2:
				// Case 2: Responsável pela baixa de produtos.
				// Implementar.
				break;
			case 3:
				// Case 3: Responsável pela consulta dos itens no estoque.
				ManageProductService.printRegisteredProducts();
				break;
			case 4:
				// Case 4: Responsável por uma consulta mais detalhada ao estoque, informando valores totais armazenados.
				// Implementar.
				break;
			case 5:
				// Case 5: Responsável por retornar ao menu inicial.
				return;	
			}
		}
	}
	
	// Método responsável pela exibição dos produtos cadastrados.
	public static void printRegisteredProducts() {
		if(products.isEmpty()) {
			ProductMessages.printNoProductsMessage();
		}
		else {
			ProductMessages.printProductListHeader();
			for(Product items : products) {
				System.out.println(items);
			}
		}
	}
}
