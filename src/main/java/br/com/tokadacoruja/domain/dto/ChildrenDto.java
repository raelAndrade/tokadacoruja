package br.com.tokadacoruja.domain.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.tokadacoruja.domain.Parent;

public class ChildrenDto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private Date dateBirth;
	
	private Boolean allergy;
	
	private String allergyDescription;
	
	private String food;
	
	private Boolean foodRestriction;
	
	private String foodRestrictionDescription;
	
	private String observation;
	
	private String publicity;
	
	private Parent parent;

	public ChildrenDto(Long id, String name, Date dateBirth, Boolean allergy, String allergyDescription, String food,
			Boolean foodRestriction, String foodRestrictionDescription, String observation, String publicity,
			Parent parent) {
		this.id = id;
		this.name = name;
		this.dateBirth = dateBirth;
		this.allergy = allergy;
		this.allergyDescription = allergyDescription;
		this.food = food;
		this.foodRestriction = foodRestriction;
		this.foodRestrictionDescription = foodRestrictionDescription;
		this.observation = observation;
		this.publicity = publicity;
		this.parent = parent;
	}

	public ChildrenDto(Long id, String name) {
		this.id = id;
		this.name = name;
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

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
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
		ChildrenDto other = (ChildrenDto) obj;
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
		builder.append("ChildrenDto [id=").append(id).append(", name=").append(name).append(", dateBirth=")
				.append(dateBirth).append(", allergy=").append(allergy).append(", allergyDescription=")
				.append(allergyDescription).append(", food=").append(food).append(", foodRestriction=")
				.append(foodRestriction).append(", foodRestrictionDescription=").append(foodRestrictionDescription)
				.append(", observation=").append(observation).append(", publicity=").append(publicity)
				.append(", parent=").append(parent).append("]");
		return builder.toString();
	}
	

}
