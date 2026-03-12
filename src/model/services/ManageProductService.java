// Classe responsável pela consolidação dos métodos responsáveis pela manipulação de produtos.

package model.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;
import model.entities.StockOperation;
import model.enums.OperationType;
import model.utils.input.DateInputUtils;
import model.utils.input.NumericInputUtils;
import model.utils.input.StringInputUtils;
import view.console.ProductMessages;

public class ManageProductService {

	// Lista armazenando as operações realizadas no sistema.
	public static List<StockOperation> stockOperations = ManageOperationService.stockOperations;
	
//=================================================================================================================================================================//	
	
	// Lista armazenando os produtos cadastrados no sistema.
	public static final List<Product> products = new ArrayList<>();

//=================================================================================================================================================================//	
	
	// Método responsável pelo cadastro de produtos.
	public static void registerProduct(Scanner sc) {
		
		// Exibe o menu de cadastro de produtos.
		ProductMessages.printProductRegisterMenu(); 
		
		// Captura do número de cadastros a serem realizados por operação, sendo 0 o mínimo e 5 o máximo de cadastros por operação.
		Integer numOfProducts = NumericInputUtils.readIntegerInRange("Quantos produtos deseja cadastrar ?: ", sc , 0, 5); 
		
		// Loop for controlando a quantidade de registros simultâneos.
		for(int i=0; i<numOfProducts; i++) {
			System.out.printf("Registro do %dº produto:%n%n", i+1); // Exibe o registro em execução.
			
			// Captura dos dados do produto.
			String name = StringInputUtils.readProductName(sc);
			System.out.print("Descrição: ");
			String description = sc.nextLine().trim();
			Integer quantity = NumericInputUtils.readIntegerInRange("Quantidade: ", sc , 1, 5000); // Mínimo de 1 item e máximo de 5000 itens.
			LocalDateTime entryDate = DateInputUtils.getCurrentDateTime(); // Registra automaticamente a data/hora no ato do cadastro do produto.
			Double price = NumericInputUtils.readDouble("Preço R$: ", sc, 0.0); // Valor mínimo permitido para registro de produto de 0.0.
			
			// Registra o produto na lista.
			Product product = new Product(name, description, quantity, entryDate, price);
			products.add(product);
			
			// Registra a operação no log.
			StockOperation productRegistration = new StockOperation(product, OperationType.CADASTRO);
			stockOperations.add(productRegistration);
			
			System.out.println(); // Espaçamento entre cadastros.
		}
		ProductMessages.printProductRegisteredMessage(); // Exibe a confirmação de cadastro dos produtos.
	}
	
//=================================================================================================================================================================//	
	
	// Método responsável pela navegação no menu de produtos.
	public static void productMenuSystem(Scanner sc) {
		while(true) {
			ProductMessages.printInventoryMenu(); // Exibe o menu de produtos.
			
			// Implementação de um switch-case controlando a navegação entre as opções do menu de estoque.
			// Valores aceitos desde 1 até 6, coincidindo com as opções disponíveis no menu de estoque.
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 6)) {
			
			case 1: // Responsável pelo cadastro de produtos.
				ManageProductService.registerProduct(sc);
				break;
				
			case 2: // Responsável pela baixa de produtos.
				removeProductFromStock(sc);
				break;
				
			case 3: // Responsável pelo ajuste dos itens no estoque.
				editRegisteredProducts(sc);
				break;
				
			case 4: // Responsável por realizar consulta genérica ao estoque.
				printRegisteredProducts();
				break;
				
			case 5: // Responsável por consulta detalhada ao estoque.
				ManageOperationService.detailedStockConsultation();
				break;
				
			case 6: // Retona ao menu anterior. 
				return;
			}
		}
	}
	
//=================================================================================================================================================================//	
	
	// Método responsável pela exibição dos produtos cadastrados.
	public static void printRegisteredProducts() {
		
		// Verifica inicialmente se a lista esta vazia.
		if(products.isEmpty()) { 
			ProductMessages.printNoProductsMessage(); // Exibe mensagem informando a inexistência de produtos registrados.
		}
		else { // Se produtos registrados.
			ProductMessages.printProductListHeader(); // Exibe cabeçalho dos produtos cadastrados.
			for(Product items : products) {
				System.out.println(items); // Loop for exibe os produtos cadastrados.
			}
		}
	}
	
//=================================================================================================================================================================//		

	// Método responsável pela alteração dos dados de produtos cadastrados.
	public static void editRegisteredProducts(Scanner sc) {
		
		// Verifica inicialmente se a lista esta vazia.
		if(products.isEmpty()) {
			ProductMessages.printNoProductsMessage(); // Exibe mensagem informando a inexistência de produtos registrados.
			return;
		} 
		
		while(true) {
			printRegisteredProducts(); // Exibe a lista de produtos antes da edição.
			ProductMessages.printProductEditMenu(); // Exibe o menu de edição de produtos.
				
			Integer idSelected = NumericInputUtils.readProductId(sc); // Captura a escolha de ID do usuário.
			
			if (idSelected == 0) {
			    return; // Sai do método e volta ao menu principal
			}
			
			// Busca produto pelo ID.
			Product productToEdit = null;
			for(Product product : products) {
				if(product.getId().equals(idSelected)) {
					productToEdit = product;
					break;
				}
			}
			
			// Caso produto não seja encontrado, apresenta a mensagem e volta ao início do loop.
			if(productToEdit == null) {
				ProductMessages.printNoIdFound();
				continue;
			}	
			
			// Menu de edição do produto encontrado.
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 5)) {
				
			case 1: // Responsável pela alteração de nome. 					
				String newName = StringInputUtils.readProductName(sc);
				productToEdit.setName(newName);
				
				// Mensagem confirmando alteração realizada.
				System.out.printf("Nome do produto atualizado!%nDados atuais:%n%n");
				System.out.println(productToEdit);
				System.out.println();
				break;
					
			case 2: // Responsável pela alteração de descrição.
				System.out.print("Descrição: ");
				String newDescription = sc.nextLine().trim();
				productToEdit.setDescription(newDescription);
				
				// Mensagem confirmando alteração realizada.
				System.out.printf("Descrição do produto atualizada!%nDados atuais:%n%n");
				System.out.println(productToEdit);
				System.out.println();
				break;
				
			case 3: // Responsável pela alteração da quantidade.
				Integer newQuantity = NumericInputUtils.readIntegerInRange("Quantidade: ", sc , 1, 5000);
				productToEdit.setQuantity(newQuantity);
				
				// Registra a operação no log.
				StockOperation quantityAjustement = new StockOperation(productToEdit, OperationType.AJUSTE, newQuantity);
				stockOperations.add(quantityAjustement);
				
				// Mensagem confirmando alteração realizada.
				System.out.printf("Quantidade de produtos atualizada!%nDados atuais:%n%n");
				System.out.println(productToEdit);
				System.out.println();
				break;
				
			case 4: // Responsável pela alteração de preços.
				Double newPrice = NumericInputUtils.readDouble("Preço R$: ", sc, 0.0);
				productToEdit.setValue(newPrice);
				
				// Registra a operação no log.
				StockOperation priceAjustement = new StockOperation(productToEdit, OperationType.AJUSTE, newPrice);
				stockOperations.add(priceAjustement);
				
				// Mensagem confirmando alteração realizada.
				System.out.printf("Preço do produto atualizado!%nDados atuais:%n%n");
				System.out.println(productToEdit);
				System.out.println();
				break;
				
			case 5: // Retorna ao menu anterior.
				return;
			}
		}
	}
	
//=================================================================================================================================================================//		

	// Método responsável pela baixa de produtos no estoque.
	public static void removeProductFromStock(Scanner sc) {
		
		// Verifica inicialmente se a lista esta vazia.
		if(products.isEmpty()) { 
			ProductMessages.printNoProductsMessage(); // Exibe mensagem informando a inexistência de produtos registrados.
			return;
		} 
		
		while(true) {
			printRegisteredProducts(); // Exibe a lista de produtos antes da baixa.
			ProductMessages.printRemoveFromStockMenu(); // Exibe o menu de baixa no estoque.
				
			Integer idSelected = NumericInputUtils.readProductId(sc); // Captura a escolha de ID do usuário.
			
			if (idSelected == 0) {
			    return; // Sai do método e volta ao menu principal
			}
			
			// Busca produto pelo ID.
			Product productToEdit = null;
			for(Product product : products) {
				if(product.getId().equals(idSelected)) {
					productToEdit = product;
					break;
				}
			}
			
			// Caso produto não seja encontrado, apresenta a mensagem e volta ao início do loop.
			if(productToEdit == null) {
				ProductMessages.printNoIdFound();
				continue;
			}	
			
			
			// Menu de baixa do produto encontrado.
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 2)) {
			
				case 1: // Responsável pela baixa no estoque.
					Integer quantityToRemove = NumericInputUtils.readIntegerInRange("Quantidade a ser baixada: ", sc , 0, productToEdit.getQuantity());
					
					// Subtrai a quantidade informada do estoque atual.
					productToEdit.setQuantity(productToEdit.getQuantity() - quantityToRemove);
					
					// Registra a operação no log.
					StockOperation productWithdrawal = new StockOperation(productToEdit, OperationType.BAIXA, quantityToRemove);
					stockOperations.add(productWithdrawal);
					
					// Mensagem confirmando alteração realizada.
					System.out.printf("Baixa realizada com sucesso!%nQuantidade atual:%n%n");
					System.out.println(productToEdit);
					System.out.println();
					break;
					
				case 2: // Retorna ao menu anterior.
					return;
			}
		}
	}
			
}
