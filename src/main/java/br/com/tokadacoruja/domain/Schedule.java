package br.com.tokadacoruja.domain;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.tokadacoruja.domain.enums.Payment;

@Entity
@Table(name = "schedule")
@JsonIgnoreProperties
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sch_id")
	private Long id;
	
	@JsonIgnoreProperties
	@ManyToOne
	@JoinColumn(name = "sch_children_id", referencedColumnName = "chi_id")
	private Children children;
	
	@Column(name = "sch_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;
	
	@NotNull(message = "Hora Inicial é obrigatório!")
	@Column(name = "sch_hour_initial")
	private LocalTime hourInitial;
	
	@NotNull(message = "Hora Final é obrigatório!")
	@Column(name = "sch_hour_finale")
	private LocalTime hourFinale;
	
	@NotNull(message = "Tipo de pagamento é obrigatório!")
	@Column(name = "sch_payment")
	@Enumerated(EnumType.STRING)
	private Payment payment;
	
	@NotNull(message = "Valor da hora é obrigatório!")
	@Column(name = "sch_amount")
	@NumberFormat(pattern = "#,##0.00")
	private Double amount;
	
	@Column(name = "sch_date_create")
	private LocalDateTime create;
	
	@Column(name = "sch_status")
	private Boolean status;
	
	@Column(name = "sch_total_hours")
	@DateTimeFormat(pattern = "HH:mm")
	private String totalHours;
	
	public Schedule() { this.create = LocalDateTime.now(); }
	 
	public Schedule(final Long id, final Children children, final Date date, final LocalTime hourInitial, final LocalTime hourFinale, 
			final Payment payment, final Double amount, final Boolean status, final String totalHours) {
		this.id = id;
		this.children = children;
		this.date = date;
		this.hourInitial = hourInitial;
		this.hourFinale = hourFinale;
		this.payment = payment;
		this.amount = amount;
		this.create = LocalDateTime.now();
		this.status = status;
		this.totalHours = totalHours;
	}
	
	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public LocalTime getHourInitial() { return hourInitial; }

	public void setHourInitial(LocalTime hourInitial) { this.hourInitial = hourInitial; }

	public LocalTime getHourFinale() { return hourFinale; }

	public void setHourFinale(LocalTime hourFinale) { this.hourFinale = hourFinale; }
	
	public Date getDate() { return date; }

	public void setDate(Date date) { this.date = date; }

	public Payment getPayment() { return payment; }

	public void setPayment(Payment payment) { this.payment = payment; }

	public Double getAmount() { return amount; }

	public void setAmount(Double amount) { this.amount = amount; }
	
	public Boolean getStatus() { return status; }
	
	public void setStatus(Boolean status) { this.status = status; }
	
	public String getTotalHours() { return totalHours; }
	
	public void setTotalHours(String localTime) { this.totalHours = localTime; }
	
	public Children getChildren() { return children; }
	
	public void setChildren(Children children) { this.children = children; }
	
	public String differenceHours(LocalTime start, LocalTime end) {
		LocalTime hoursInitial = LocalTime.of(start.getHour(), start.getMinute());
		LocalTime hoursFinal = LocalTime.of(end.getHour(), end.getMinute());
		Duration diff = Duration.between(hoursInitial, hoursFinal);
		return (diff.toHours() % 24)+":"+(diff.toMinutes() % 60);
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
		Schedule other = (Schedule) obj;
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
		builder.append("Schedule [id=").append(id).append(", childrens=").append(children).append(", date=")
				.append(date).append(", hourInitial=").append(hourInitial).append(", hourFinale=").append(hourFinale)
				.append(", payment=").append(payment).append(", amount=").append(amount).append(", create=")
				.append(create).append(", status=").append(status).append(", totalHours=").append(totalHours).append("]");
		return builder.toString();
	}

}

