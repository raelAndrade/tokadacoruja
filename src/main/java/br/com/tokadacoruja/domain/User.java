package br.com.tokadacoruja.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/**
 * Classe responsável por criar o usuário
 * @author Israel
 *
 */

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private Long id;
	
	@Column(name = "usr_email")
	@Email(message = "*Por favor, forneça um e-mail válido")
	@NotEmpty(message = "*E-mail é obrigatório!")
    private String email;
	
	@Column(name = "usr_name")
	@Length(min = 5, message = "*Nome de usuário deve conter no mínimo 5 caracteres!")
	@NotEmpty(message = "*Nome é obrigatório!")
	private String userName;
	
	@Column(name = "usr_password")
	@Length(min = 5, message = "*Senha de conter no mínimno 5 caracteres!")
    @NotEmpty(message = "*Senha é obrigatório!")
	private String password;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "usr_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@Column(name = "usr_active")
	private Boolean active;
	
	@Column(name = "usr_dt_create")
	private LocalDateTime create;
	
	public User() { this.create = LocalDateTime.now(); }
	
	public User(final Long id, final String email, final String userName, final String password, final Set<Role> roles, final Boolean active, final LocalDateTime create) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.active = active;
		this.create = LocalDateTime.now();
	}

	public Long getId() { return id; }
	
	public void setId(Long id) { this.id = id; }
	
	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email.trim().toLowerCase(); }
	
	public String getUserName() { return userName; }

	public void setUserName(String userName) { this.userName = userName; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public Boolean getActive() { return active; }

	public void setActive(Boolean active) { this.active = active; }
	
	public Set<Role> getRoles() { return roles; }
	
	public void setRoles(Set<Role> roles) { this.roles = roles; }
	
	public LocalDateTime getCreate() { return create; }
	
	public void setCreate(LocalDateTime create) { this.create = create; }

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
		User other = (User) obj;
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
		builder.append("User [id=").append(id).append(", email=").append(email).append(", userName=").append(userName)
				.append(", password=").append(password).append(", roles=").append(roles).append(", active=")
				.append(active).append("]");
		return builder.toString();
	}
	
}
