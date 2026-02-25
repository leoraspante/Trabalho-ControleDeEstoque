// Classe responsável pela representação de um funcionário.

package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.enums.Department;

public class Employee {

	// Atributos.
	private static Integer nextId = 1; // Contador estático para gerar IDs automaticamente.
	private Integer id;
	private String name;
	private Department department;
	private String email;
	private LocalDate birthDate;
	private LocalDate hireDate;
	
	// Construtor.
	public Employee(String name, Department department, String email, LocalDate birthDate, LocalDate hireDate) {
		this.id = nextId++; // Atribui o próximo ID e incrementa o contador.
		this.name = name;
		this.department = department;
		this.email = email;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	// toString personalizado.
	@Override
	public String toString() {
		
		// Formato para exibição de data.
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		// StringBuider formatando a exibição da lista.
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-5s | %-35s | %-35s | %-20s | %-20s | %-15s", id, name, email, birthDate.format(fmt), department, hireDate.format(fmt)));
		return sb.toString();
	}
	
}
