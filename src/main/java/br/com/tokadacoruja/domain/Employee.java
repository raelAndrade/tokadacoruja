package br.com.tokadacoruja.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	
	@Column(name = "emp_name")
	private String name;
	
	@Column(name = "emp_email")
	private String email;
	
	@Column(name = "emp_telephone")
	private String telephone;

	@Column(name = "emp_celular")
	private String celular;
	
	@Column(name = "emp_status")
	private Boolean status;
	
	@Column(name = "emp_date_create")
	private LocalDateTime create;
	
	public Employee() {
		this.create = LocalDateTime.now();
	}

	public Employee(final Long id, final String name, final String email, final String telephone, 
			final String celular, final Boolean status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.celular = celular;
		this.status = status;
		this.create = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDateTime getCreate() {
		return create;
	}

	public void setCreate(LocalDateTime create) {
		this.create = create;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(id).append(", name=").append(name).append(", email=").append(email)
				.append(", telephone=").append(telephone).append(", celular=").append(celular).append(", status=")
				.append(status).append(", create=").append(create).append("]");
		return builder.toString();
	}

}
