// Classe responsável por representar cada movimentação no estoque.

package model.entities;

import java.time.LocalDateTime;

import model.enums.OperationType;

public class StockOperation {
	
	// Atributos.
	private Product product;
	private OperationType operation;
	private Integer quantity;
	private Employee employee;
	private LocalDateTime operationTime;
	
	// Construtor.
	public StockOperation(Product product, OperationType operation, Integer quantity, Employee employee) {
		this.product = product;
		this.operation = operation;
		this.quantity = quantity;
		this.employee = employee;
		this.operationTime = LocalDateTime.now();
				
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	// toString padrão.
	@Override
	public String toString() {
		return "StockOperation [product=" + product + ", operation=" + operation + ", quantity=" + quantity
				+ ", employee=" + employee + ", operationTime=" + operationTime + "]";
	}
	

}
