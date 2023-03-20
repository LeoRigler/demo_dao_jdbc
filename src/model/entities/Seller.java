package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable{
	
	/*
	 * A serialização é quando um objeto é transformado, 
	 * em umacadeia de bytes e desta forma pode ser manipulado 
	 * de maneira mais fácil, seja através de transporte pela rede ou 
	 * salvo no disco.
	 * 
	 * Fonte: https://www.oracle.com/br/technical-resources/articles/java/serialversionuid.html#:~:text=Serialização%20em%20Java&text=A%20serialização%20é%20quando%20um,rede%20ou%20salvo%20no%20disco.
	 */
	
	private static final long serialVersionUID = 1L;
	
	private Integer Id; 
	private String name; 
	private String email; 
	private Date birthDate; 
	private Double baseSalary;
	
	//O vendedor tem uma assosiação com a classe de Departamento.
	private Department department; 
	
	public Seller() {
		
	}

	public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department) {
		Id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(Id, other.Id);
	}

	@Override
	public String toString() {
		return "Seller [Id=" + Id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", baseSalary="
				+ baseSalary + ", department=" + department + "]";
	}
	
}