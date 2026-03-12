// Classe responsável por representar cada movimentação no estoque.

package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.enums.OperationType;

public class StockOperation {
	
	// Atributos.
	private static Integer nextId = 1; // Contador estático para gerar IDs automaticamente.
	private Integer id;
	private Product product;
	private OperationType operation;
	private Integer quantityChanged;
	private Double priceChanged;
	private Employee employee; // Não utilizado por enquanto. AJUSTAR!!
	private LocalDateTime operationTime;
	
	// Construtor para cadastro
	public StockOperation(Product product, OperationType operation) {
		this.id = nextId++; // Atribui o próximo ID e incrementa o contador.
		this.product = product;
		this.operation = operation;
		this.operationTime = LocalDateTime.now();
	}
	
	// Construtor para ajuste de quantidade
	public StockOperation(Product product, OperationType operation, Integer quantityChanged) {
		this.id = nextId++; // Atribui o próximo ID e incrementa o contador.
		this.product = product;
		this.operation = operation;
		this.operationTime = LocalDateTime.now();
		this.quantityChanged = quantityChanged;			
	}
	
	// Construtor para ajuste de preço
	public StockOperation(Product product, OperationType operation, Double priceChanged) {
		this.id = nextId++; // Atribui o próximo ID e incrementa o contador.
		this.product = product;
		this.operation = operation;
		this.operationTime = LocalDateTime.now();
		this.priceChanged = priceChanged;
	}
	

	// Getters e Setters.
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OperationType getOperation() {
		return operation;
	}

	public void setOperation(OperationType operation) {
		this.operation = operation;
	}
	
	public void setQuantityChanged(Integer quantityChanged) {
		this.quantityChanged = quantityChanged;
	}
	
	public Integer getQuantityChanged() {
		return quantityChanged;
	}

	public void setPriceChanged(Double priceChanged) {
		this.priceChanged = priceChanged;
	}
	
	public Double getPriceChanged() {
		return priceChanged;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDateTime getOperationTime() {
		return operationTime;
	}

	// toString personalizado.
	@Override
	public String toString() {
		
		// Formato para exibição de data.
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
		
		// StringBuider formatando a exibição da lista.
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format(
			"%-5s | %-25s | %-10s | %-10s | %-20s | %-10s | %-10s | %-10.2f",
			id,																			// ID da operação.
			product.getName(),															// Nome do produto.
			operation,																	// Tipo de operação (CADASTRO, BAIXA, AJUSTE).
			product.getQuantity(),														// Estoque atual após operação.
			operationTime.format(fmt),													// Data/Hora da operação.
			(quantityChanged != null ? quantityChanged : "-"),							// Quantidade movimentada.
			(priceChanged != null ? String.format("R$ %.2f", priceChanged) : "-"),		// Preço alterado.
			product.getValue()*product.getQuantity()									// Valor total atual em estoque.
		));
		
		return sb.toString();
	}
	

}
