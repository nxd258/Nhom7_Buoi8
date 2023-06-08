package fit.hutech.nguyenxuanduc.entity;

import java.util.Locale.Category;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	@Column
	private String username;
	@Column
	private String password;
	@ManyToMany(cascade  = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "UserRole",
	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
	private Set<Role> roles = new HashSet<>();
	

}
