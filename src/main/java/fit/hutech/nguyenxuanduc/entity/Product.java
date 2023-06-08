package fit.hutech.nguyenxuanduc.entity;

import java.util.Locale.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column 
	private String image;
	@Column
	private long price;
	@ManyToOne(fetch  = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	private Category category;
	
}
