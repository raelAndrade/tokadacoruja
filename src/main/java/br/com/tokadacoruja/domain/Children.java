package br.com.tokadacoruja.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "children")
public class Children implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chi_id")
	private Long id;
	
	@Column(name = "chi_name")
	private String name;
	
	@Column(name = "chi_date_birth")
	private LocalDate dateBirth;
	
	@Column(name = "chi_status")
	private String status;
	
	@Column(name = "chi_allergy")
	private String allergy;
	
	@Column(name = "chi_allergy_description")
	private String allergyDescription;
	
	@Column(name = "chi_food")
	private String food;
	
	@Column(name = "chi_food_restriction")
	private String foodRestriction;
	
	@Column(name = "chi_food_restriction_description")
	private String foodRestrictionDescription;
	
	@Column(name = "chi_observation")
	private String observation;
	
	@Column(name = "chi_publicity")
	private Boolean publicity;
	
	@ManyToOne
	@JoinColumn(name = "par_id")
	private Parent parent;
	
	public Children() { }

	public Children(final Long id, final String name, final String status, final String allergy) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.allergy = allergy;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		Children other = (Children) obj;
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
		builder.append("Children [id=").append(id).append(", name=").append(name).append(", status=").append(status)
				.append(", allergy=").append(allergy).append(", parent=").append(parent).append("]");
		return builder.toString();
	}
}
