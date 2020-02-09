package br.com.tokadacoruja.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "daily")
public class Daily implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dai_id")
	private Long id;
	
	@NotNull(message = "Nome é obrigatório!")
	@Column(name = "dai_name")
	private String name;
	
	@NotNull(message = "Data e Hora inicial é obrigatório!")
	@Column(name = "day_dt_initial")
	private LocalDateTime open;
	
	private LocalDateTime close;
	
	@JsonIgnoreProperties
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "dai_sch_children", 
			joinColumns = @JoinColumn(name = "dai_id"), 
			inverseJoinColumns = @JoinColumn(name = "chi_id"))
	private Set<ScheduleChildren> scheduleChildrens = new HashSet<>();

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

	public LocalDateTime getOpen() {
		return open;
	}

	public void setOpen(LocalDateTime open) {
		this.open = open;
	}

	public LocalDateTime getClose() {
		return close;
	}

	public void setClose(LocalDateTime close) {
		this.close = close;
	}

	public Set<ScheduleChildren> getScheduleChildrens() {
		return scheduleChildrens;
	}

	public void setScheduleChildrens(Set<ScheduleChildren> scheduleChildrens) {
		this.scheduleChildrens = scheduleChildrens;
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
		Daily other = (Daily) obj;
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
	
}
