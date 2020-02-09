package br.com.tokadacoruja.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "schedulechildren")
public class ScheduleChildren implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Hora Inicial é obrigatório!")
	@Column(name = "sch_hour_initial")
	private LocalTime hourInitial;
	
	@NotNull(message = "Hora Final é obrigatório!")
	@Column(name = "sch_hour_finale")
	private LocalTime hourFinale;
	
	@NotNull(message = "Valor da hora é obrigatório!")
	@Column(name = "sch_amount")
	@NumberFormat(pattern = "#,##0.00")
	private Double amount;
	
	@Column(name = "sch_date_create")
	private LocalDateTime create;
	
	@Column(name = "sch_status")
	private Boolean status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Daily scheduleChildrens;
	
	public ScheduleChildren() { this.create = LocalDateTime.now(); }

	public ScheduleChildren(final Long id, final LocalTime hourInitial,	final LocalTime hourFinale,
			final Double amount, LocalDateTime create, Boolean status) {
		this.id = id;
		this.hourInitial = hourInitial;
		this.hourFinale = hourFinale;
		this.amount = amount;
		this.create = LocalDateTime.now();
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getHourInitial() {
		return hourInitial;
	}

	public void setHourInitial(LocalTime hourInitial) {
		this.hourInitial = hourInitial;
	}

	public LocalTime getHourFinale() {
		return hourFinale;
	}

	public void setHourFinale(LocalTime hourFinale) {
		this.hourFinale = hourFinale;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getCreate() {
		return create;
	}

	public void setCreate(LocalDateTime create) {
		this.create = create;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((scheduleChildrens == null) ? 0 : scheduleChildrens.hashCode());
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
		ScheduleChildren other = (ScheduleChildren) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (scheduleChildrens == null) {
			if (other.scheduleChildrens != null)
				return false;
		} else if (!scheduleChildrens.equals(other.scheduleChildrens))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScheduleChildren [id=").append(id).append(", hourInitial=").append(hourInitial)
				.append(", hourFinale=").append(hourFinale).append(", amount=").append(amount).append(", create=")
				.append(create).append(", status=").append(status).append(", scheduleChildren=")
				.append(scheduleChildrens).append("]");
		return builder.toString();
	}
}
