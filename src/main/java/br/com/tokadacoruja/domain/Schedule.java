package br.com.tokadacoruja.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import br.com.tokadacoruja.domain.enums.Payment;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sch_id")
	private Long id;
	
	@JoinColumn(name = "sch_children_id")
	private Children children;
	
	@Column(name = "sch_date")
	private LocalDate date;
	
	@Column(name = "sch_hour_initial")
	private LocalTime hourInitial;
	
	@Column(name = "sch_hour_finale")
	private LocalTime hourFinale;
	
	@Column(name = "sch_payment")
	@Enumerated(EnumType.STRING)
	private Payment payment;
	
	@Column(name = "sch_amount")
	private BigDecimal amount;
	
	@Column(name = "sch_total_hours")
	private Long totalHours;
	
	@Column(name = "sch_date_create")
	private LocalDateTime create;

	public Schedule() {
		this.create = LocalDateTime.now();
	}
	 
	public Schedule(final Long id, final Children children, final LocalDate date, final LocalTime hourInitial,
			final LocalTime hourFinale, final Payment payment, final BigDecimal amount, final Long totalHours) {
		this.id = id;
		this.children = children;
		this.date = date;
		this.hourInitial = hourInitial;
		this.hourFinale = hourFinale;
		this.payment = payment;
		this.amount = amount;
		this.totalHours = totalHours;
		this.create = LocalDateTime.now();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Children getChildren() {
		return children;
	}
	
	public void setChildren(Children children) {
		this.children = children;
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
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Long getTotalHours() {
		return totalHours;
	}
	
	public void setTotalHours(Long totalHours) {
		this.totalHours = totalHours;
	}
	
	/*private void calcularDiferencaHoras(String hourInitial, String hourFinale){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date horaIni = sdf.parse(hourInitial);
            Date horaFim = sdf.parse(hourFinale);
            Long horaI = horaIni.getTime();
            Long horaF = horaFim.getTime(); 
            Long diferencaHoras = horaF - horaI;
            System.out.println("Diferença de horas" + diferencaHoras);

        } catch(Exception e) {
           e.printStackTrace();
        }
    }*/
	
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
		builder.append("Schedule [id=").append(id).append(", criança=").append(children).append(", data=").append(date)
				.append(", hora inicial=").append(hourInitial).append(", hora final=").append(hourFinale)
				.append(", forma de pagamento=").append(payment).append(", valor=").append(amount).append(", Total de horas=").append(totalHours).append("]");
		return builder.toString();
	}

		
}

