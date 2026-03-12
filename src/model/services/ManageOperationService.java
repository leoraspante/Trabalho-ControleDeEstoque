package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.StockOperation;
import view.console.StockOperationMessages;

public final class ManageOperationService {
	
	// Lista armazenando as operações realizadas no estoque.
	public static final List<StockOperation> stockOperations = new ArrayList<>();
	
	// Método responsável pela exibição das movimentações realizadas no estoque.
	public static void printStockOperations() {
		if(stockOperations.isEmpty()) {
			StockOperationMessages.printNoOperationsMessage();
		}
		else {
			StockOperationMessages.printOperationsListHeader();
			for(StockOperation items : stockOperations) {
				System.out.println(items);
			}
		}
	}
	

}
