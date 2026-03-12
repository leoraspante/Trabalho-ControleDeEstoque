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
import view.console.StockOperationMessages;

public class ManageProductService {

	// Lista responsável pelo armazenamento das operações realizadas no sistema.
	public static List<StockOperation> stockOperations = ManageOperationService.stockOperations;
	
//=================================================================================================================================================================//	
	
	// Lista responsável pelo armazenamento de produtos cadastrados no sistema.
	public static final List<Product> products = new ArrayList<>();

//=================================================================================================================================================================//	
	
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
			
			// Registra a operação no log.
			StockOperation productRegistration = new StockOperation(product, OperationType.CADASTRO);
			stockOperations.add(productRegistration);
			
			System.out.println();
		}
		ProductMessages.printProductRegisteredMessage(); // Exibição da confirmação de cadastro dos produtos.
	}
	
//=================================================================================================================================================================//	
	
	// Método responsável pela navegação no menu de produtos.
	public static void productMenuSystem(Scanner sc) {
		while(true) {
			ProductMessages.printInventoryMenu();
			
			// Implementação de um switch-case controlando a navegação entre as opções do menu de estoque.
			// Valores aceitos desde 1 até 6, coincidindo com as opções disponíveis no menu de estoque.
			switch (NumericInputUtils.readIntegerInRange("Informe a opção desejada: ", sc, 1, 6)) {
			case 1:
				// Case 1: Responsável pelo cadastro de produtos.
				ManageProductService.registerProduct(sc);
				break;
			case 2:
				// Case 2: Responsável pela baixa de produtos.
				removeProductFromStock(sc);
				break;
			case 3:
				// Case 3: Responsável pelo ajuste dos itens no estoque.
				editRegisteredProducts(sc);
				break;
			case 4:
				// Case 4: Responsável por realizar consulta genérica ao estoque.
				printRegisteredProducts();
				break;
			case 5:
				// Case 5: Responsável por consulta detalhada ao estoque.
				detailedStockConsultation();
				break;
			case 6:
				
				return;
			}
		}
	}
	
//=================================================================================================================================================================//	
	
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
	
//=================================================================================================================================================================//		

	// Método responsável pela alteração dos dados de produtos cadastrados.
	public static void editRegisteredProducts(Scanner sc) {
		if(products.isEmpty()) {
			ProductMessages.printNoProductsMessage();
			return;
		} 
		
		while(true) {
			// Exibe a lista de produtos antes da edição.
			printRegisteredProducts();
			ProductMessages.printProductEditMenu();
				
			Integer idSelected = NumericInputUtils.readProductId(sc);
			
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
				case 1:
					// Case 1: Responsável pela alteração de nome.
					String newName = StringInputUtils.readProductName(sc);
					productToEdit.setName(newName);
					System.out.printf("Nome do produto atualizado!%nDados atuais:%n%n");
					System.out.println(productToEdit);
					System.out.println();
					break;
				case 2:
					// Case 2: Responsável pela alteração de descrição.
					System.out.print("Descrição: ");
					String newDescription = sc.nextLine().trim();
					productToEdit.setDescription(newDescription);
					System.out.printf("Descrição do produto atualizada!%nDados atuais:%n%n");
					System.out.println(productToEdit);
					System.out.println();
					break;
				case 3:
					// Case 3: Responsável pela alteração da quantidade.
					Integer newQuantity = NumericInputUtils.readIntegerInRange("Quantidade: ", sc , 1, 5000);
					productToEdit.setQuantity(newQuantity);
					
					// Registra a operação no log.
					StockOperation quantityAjustement = new StockOperation(productToEdit, OperationType.AJUSTE, newQuantity);
					stockOperations.add(quantityAjustement);
					
					System.out.printf("Quantidade de produtos atualizada!%nDados atuais:%n%n");
					System.out.println(productToEdit);
					System.out.println();
					break;
				case 4:
					// Case 4: Responsável pela alteração de preços.
					Double newPrice = NumericInputUtils.readDouble("Preço R$: ", sc, 0.0);
					productToEdit.setValue(newPrice);
					
					// Registra a operação no log.
					StockOperation priceAjustement = new StockOperation(productToEdit, OperationType.AJUSTE, newPrice);
					stockOperations.add(priceAjustement);
					
					System.out.printf("Preço do produto atualizado!%nDados atuais:%n%n");
					System.out.println(productToEdit);
					System.out.println();
					break;
				case 5:
					return;
			}
		}
	}
	
//=================================================================================================================================================================//		

	// Método responsável pela baixa de produtos no estoque.
	public static void removeProductFromStock(Scanner sc) {
		if(products.isEmpty()) {
			ProductMessages.printNoProductsMessage();
			return;
		} 
		
		while(true) {
			// Exibe a lista de produtos antes da baixa.
			printRegisteredProducts();
			ProductMessages.printRemoveFromStockMenu();
				
			Integer idSelected = NumericInputUtils.readProductId(sc);
			
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
				case 1:
					Integer quantityToRemove = NumericInputUtils.readIntegerInRange("Quantidade a ser baixada: ", sc , 0, productToEdit.getQuantity());
					
					// Subtrai a quantidade informada do estoque atual.
					productToEdit.setQuantity(productToEdit.getQuantity() - quantityToRemove);
					
					// Registra a operação no log.
					StockOperation productWithdrawal = new StockOperation(productToEdit, OperationType.BAIXA, quantityToRemove);
					stockOperations.add(productWithdrawal);
					
					// Feedback ao usuário.
					System.out.printf("Baixa realizada com sucesso!%nQuantidade atual:%n%n");
					System.out.println(productToEdit);
					System.out.println();
	
					break;
				case 2:
					return;
			}
		}
	}
			
//=================================================================================================================================================================//
		
	// Método responsável pela consulta detalhada ao estoque.
	public static void detailedStockConsultation() {
	    if (stockOperations.isEmpty()) {
	    	StockOperationMessages.printNoOperationsMessage();
	        return;
	    }

	    StockOperationMessages.printOperationsListHeader();
	    for (StockOperation op : stockOperations) {
	        System.out.println(op);
	    }
	}

//=================================================================================================================================================================//	
		
}
