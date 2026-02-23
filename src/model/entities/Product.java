// Classe responsável pela representação de um produto.

package model.entities;

import java.time.LocalDate;

public class Product {
	
	// Atributos.
	private Integer id;
	private String name;
	private String description;
	private Integer quantity;
	private LocalDate entryDate;
	private Double value;
	
	// Construtor.
	public Product(Integer id, String name, String description, Integer quantity, LocalDate entryDate, Double value) {
		this.id = id;
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

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	// toString padrão.
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", entryDate=" + entryDate + ", value=" + value + "]";
	}
	
	
}
