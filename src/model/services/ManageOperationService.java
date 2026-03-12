// Classe responsável pela consolidação dos métodos responsáveis pelas operações no estoque

package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.StockOperation;
import view.console.StockOperationMessages;

public final class ManageOperationService {
	
	// Lista armazenando as operações realizadas no estoque.
	public static final List<StockOperation> stockOperations = new ArrayList<>();
	
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

}
