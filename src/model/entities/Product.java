// Classe responsável pela representação de um produto.

package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {
	
	// Atributos.
	private static Integer nextId = 1; // Contador estático para gerar IDs automaticamente.
	private Integer id;
	private String name;
	private String description;
	private Integer quantity;
	private LocalDateTime entryDate;
	private Double value;
	
	// Construtor.
	public Product(String name, String description, Integer quantity, LocalDateTime entryDate, Double value) {
		this.id = nextId++; // Atribui o próximo ID e incrementa o contador.
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.entryDate = entryDate;
		this.value = value;		
	}

	// Getters e Setters.
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	// toString personalizado.
	@Override
	public String toString() {
		
		// Formato para exibição de data.
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
		
		// StringBuider formatando a exibição da lista.
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-5s | %-25s | %-35s | %-15s | %-20s | %-10.2f", id, name, description, quantity, entryDate.format(fmt), value));
		return sb.toString();
	}
	
	
}
