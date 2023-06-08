package fit.hutech.nguyenxuanduc.entity;

import java.io.Serializable;

import jakarta.persistence.Column;

public class UserRoleId implements Serializable {
	@Column(name = "user_id")
	private Integer user;
	@Column(name = "role_id")
	private Integer role;
	

}
