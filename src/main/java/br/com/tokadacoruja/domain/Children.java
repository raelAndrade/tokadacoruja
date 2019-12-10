package br.com.tokadacoruja.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "children")
@JsonIgnoreProperties
public class Children implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chi_id")
	private Long id;
	
	@Column(name = "chi_name")
	private String name;
	
	@Column(name = "chi_date_birth")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateBirth;
	
	@Column(name = "chi_status")
	private Boolean status;
	
	@Column(name = "chi_allergy")
	private Boolean allergy;
	
	@Column(name = "chi_allergy_description")
	private String allergyDescription;
	
	@Column(name = "chi_food")
	private String food;
	
	@Column(name = "chi_food_restriction")
	private Boolean foodRestriction;
	
	@Column(name = "chi_food_restriction_description")
	private String foodRestrictionDescription;
	
	@Column(name = "chi_observation")
	private String observation;
	
	@Column(name = "chi_publicity")
	private String publicity;
	
	@Column(name = "chi_date_create")
	private LocalDateTime create;
	
	@ManyToOne
	@JoinColumn(name = "par_id")
	private Parent parent;
	
	@OneToMany(mappedBy = "children", cascade = CascadeType.ALL)
	private List<Schedule> schedule;
	
	public Children() {
		this.create = LocalDateTime.now();
	}

	public Children(final Long id, final String name, final Date dateBirth, final Boolean status, final Boolean allergy, final String allergyDescription,
			final String food, final Boolean foodRestriction, final String foodRestrictionDescription, final String observation,
			final String publicity, final Parent parent) {
		this.id = id;
		this.name = name;
		this.dateBirth = dateBirth;
		this.status = status;
		this.allergy = allergy;
		this.allergyDescription = allergyDescription;
		this.food = food;
		this.foodRestriction = foodRestriction;
		this.foodRestrictionDescription = foodRestrictionDescription;
		this.observation = observation;
		this.publicity = publicity;
		this.parent = parent;
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
	
	public Date getDateBirth() {
		return dateBirth;
	}
	
//	public String getDateBirthString() { 
//		return new SimpleDateFormat("dd/MM/yyyy").format(dateBirth);
//	}
	
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getAllergy() {
		return allergy;
	}
	
	public void setAllergy(Boolean allergy) {
		this.allergy = allergy;
	}

	public String getAllergyDescription() {
		return allergyDescription;
	}

	public void setAllergyDescription(String allergyDescription) {
		this.allergyDescription = allergyDescription;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public Boolean getFoodRestriction() {
		return foodRestriction;
	}
	
	public void setFoodRestriction(Boolean foodRestriction) {
		this.foodRestriction = foodRestriction;
	}

	public String getFoodRestrictionDescription() {
		return foodRestrictionDescription;
	}

	public void setFoodRestrictionDescription(String foodRestrictionDescription) {
		this.foodRestrictionDescription = foodRestrictionDescription;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getPublicity() {
		return publicity;
	}

	public void setPublicity(String publicity) {
		this.publicity = publicity;
	}

	public LocalDateTime getCreate() {
		return create;
	}

	public void setCreate(LocalDateTime create) {
		this.create = create;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
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
		builder.append("Children [id=").append(id).append(", name=").append(name).append(", dateBirth=")
				.append(dateBirth).append(", status=").append(status).append(", allergy=").append(allergy)
				.append(", allergyDescription=").append(allergyDescription).append(", food=").append(food)
				.append(", foodRestriction=").append(foodRestriction).append(", foodRestrictionDescription=")
				.append(foodRestrictionDescription).append(", observation=").append(observation).append(", publicity=")
				.append(publicity).append(", create=").append(create).append("]");
		return builder.toString();
	}

}
