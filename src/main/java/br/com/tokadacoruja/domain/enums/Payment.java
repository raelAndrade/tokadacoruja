package br.com.tokadacoruja.domain.enums;

public enum Payment {
	
	DAILY(1, "Diária"),
	MONTHLY(2, "Mensal"),
	WEEKLY(3, "Semanal");
	
	private Integer id;
	
	private String description;

	private Payment(Integer id) {
		this.id = id;
	}
	
	private Payment(String description) {
		this.description = description;
	}
	
	private Payment(Integer id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
