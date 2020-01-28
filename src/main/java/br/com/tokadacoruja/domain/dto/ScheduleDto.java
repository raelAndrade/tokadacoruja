package br.com.tokadacoruja.domain.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

public class ScheduleDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private ChildrenDto childrenDto;
	
	private Date date;
	
	private LocalTime hourInitial;
	
	private String hourFinale;
	
	private Double amount;
	
	private LocalTime totalHours;
	
	public ScheduleDto(Long id, ChildrenDto childrenDto, Date date, LocalTime hourInitial, String hourFinale, Double amount,
			LocalTime totalHours) {
		this.id = id;
		this.childrenDto = childrenDto;
		this.date = date;
		this.hourInitial = hourInitial;
		this.hourFinale = hourFinale;
		this.amount = amount;
		this.totalHours = totalHours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChildrenDto getChildrenDto() {
		return childrenDto;
	}

	public void setChildrenDto(ChildrenDto childrenDto) {
		this.childrenDto = childrenDto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getHourInitial() {
		return hourInitial;
	}

	public void setHourInitial(LocalTime hourInitial) {
		this.hourInitial = hourInitial;
	}

	public String getHourFinale() {
		return hourFinale;
	}

	public void setHourFinale(String hourFinale) {
		this.hourFinale = hourFinale;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalTime getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(LocalTime totalHours) {
		this.totalHours = totalHours;
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
		ScheduleDto other = (ScheduleDto) obj;
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
		builder.append("ScheduleDto [id=").append(id).append(", childrenDto=").append(childrenDto).append(", date=")
				.append(date).append(", hourInitial=").append(hourInitial).append(", hourFinale=").append(hourFinale)
				.append(", amount=").append(amount).append(", totalHours=").append(totalHours).append("]");
		return builder.toString();
	}

}
