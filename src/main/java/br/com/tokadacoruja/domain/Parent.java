package br.com.tokadacoruja.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parent")
public class Parent implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "par_id")
	private Long id;
	
	@Column(name = "par_name")
	private String name;
	
	@Column(name = "par_cpf")
	private String cpf;
	
	@Column(name = "par_rg")
	private String rg;
	
	@Column(name = "par_address")
	private String address;
	
	@Column(name = "par_city")
	private String city;
	
	@Column(name = "par_email")
	private String email;
	
	@Column(name = "par_status_responsible")
	private String statusResponsible;
	
	@Column(name = "par_responsible")
	private String responsible;
	
	@Column(name = "par_status")
	private Boolean status;
	
	@ElementCollection
	@CollectionTable(name = "par_telephone")
	private Set<String> telephones = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name = "par_telephone_contact")
	private Set<String> telephonesContact = new HashSet<>();
	
	@OneToMany(mappedBy = "parent")
	private List<Children> childrens = new ArrayList<Children>();
	
	@Column(name = "par_date_register")
	private LocalDateTime create;

	public Parent() { }
	

	public Parent(final Long id, final String name, final String cpf, final String rg, final String address, final String city, final String email,
			final String statusResponsible, final String responsible, final Boolean status, final Set<String> telephones,
			final Set<String> telephonesContact, final List<Children> childrens) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.rg = rg;
		this.address = address;
		this.city = city;
		this.email = email;
		this.statusResponsible = statusResponsible;
		this.responsible = responsible;
		this.status = status;
		this.telephones = telephones;
		this.telephonesContact = telephonesContact;
		this.childrens = childrens;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public Set<String> getTelephones() {
		return telephones;
	}

	public void setTelephones(Set<String> telephones) {
		this.telephones = telephones;
	}
	
	public String getStatusResponsible() {
		return statusResponsible;
	}
	
	public void setStatusResponsible(String statusResponsible) {
		this.statusResponsible = statusResponsible;
	}
	
	public LocalDateTime getCreate() {
		return create;
	}
	
	public void setCreate(LocalDateTime create) {
		this.create = create;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Set<String> getTelephonesContact() {
		return telephonesContact;
	}
	
	public void setTelephonesContact(Set<String> telephonesContact) {
		this.telephonesContact = telephonesContact;
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
		Parent other = (Parent) obj;
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
		builder.append("Parent [id=").append(id).append(", name=").append(name).append(", cpf=").append(cpf)
				.append(", rg=").append(rg).append(", address=").append(address).append(", city=").append(city)
				.append(", email=").append(email).append(", statusResponsible=").append(statusResponsible)
				.append(", responsible=").append(responsible).append(", status=").append(status).append(", telephones=")
				.append(telephones).append(", telephonesContact=").append(telephonesContact).append(", childrens=")
				.append(childrens).append(", create=").append(create).append("]");
		return builder.toString();
	}
	
}
