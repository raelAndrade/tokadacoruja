package br.com.tokadacoruja.dto.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import br.com.tokadacoruja.domain.Children;
import br.com.tokadacoruja.domain.Parent;

public class ChildrenDtoRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Nome é obrigatório!")
	private String name;
	
	@Past(message = "Data de nascimento é obrigatório!")
	private Date dateBirth;	
	
	private Boolean allergy;	
	
	private String allergyDescription;	
	
	private String food;	
	
	private Boolean foodRestriction;	
	
	private String foodRestrictionDescription;	
	
	private String observation;	
	
	@NotBlank(message = "Permitir uso de imagem é obrigatório!")
	private String publicity;
	
	private Parent parent;
	
	private Boolean status;
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Date getDateBirth() { return dateBirth; }

	public void setDateBirth(Date dateBirth) { this.dateBirth = dateBirth; }

	public Boolean getAllergy() { return allergy; }

	public void setAllergy(Boolean allergy) { this.allergy = allergy; }

	public String getAllergyDescription() { return allergyDescription; }

	public void setAllergyDescription(String allergyDescription) { this.allergyDescription = allergyDescription; }

	public String getFood() { return food; }

	public void setFood(String food) { this.food = food; }

	public Boolean getFoodRestriction() { return foodRestriction; }

	public void setFoodRestriction(Boolean foodRestriction) { this.foodRestriction = foodRestriction; }

	public String getFoodRestrictionDescription() { return foodRestrictionDescription; }

	public void setFoodRestrictionDescription(String foodRestrictionDescription) { this.foodRestrictionDescription = foodRestrictionDescription; }

	public String getObservation() { return observation; }

	public void setObservation(String observation) { this.observation = observation; }
	
	public String getPublicity() { return publicity; }
	
	public void setPublicity(String publicity) { this.publicity = publicity; }
	
	public Parent getParent() { return parent; }
	
	public void setParent(Parent parent) { this.parent = parent; }
	
	public Boolean getStatus() { return status; }
	
	public void setStatus(Boolean status) {
		if(status != false) this.status = true;
		else this.status = false;
	}

	public static Children from(final ChildrenDtoRequest request) {
		return Children.of(
				request.getName(),
				request.getDateBirth(), 
				request.getAllergy(), 
				request.getAllergyDescription(), 
				request.getFood(), 
				request.getFoodRestriction(), 
				request.getFoodRestrictionDescription(), 
				request.getObservation(),
				request.getPublicity(),
				request.getParent(),
				request.getStatus());
	}
	
	public Children transformaParaObjeto() {
		return new Children(name, dateBirth, allergy, allergyDescription, food, foodRestriction, foodRestrictionDescription, observation, publicity, parent, status);
	}

}
