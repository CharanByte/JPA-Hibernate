package com.xworkz.product.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
@Entity
@Table(name = "product_table")
public class ProductDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String product_name;
	private double product_price;
	private String product_manfDate;
	private String product_expDate;
	private String Description;
	private int QuantityInStock;
	private int SupplierID;
	private boolean IsActive;
	private double Rating;

	public ProductDto(String product_name, double product_price, String product_manfDate, String product_expDate,
			String description, int quantityInStock, int supplierID, boolean isActive, double rating) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_manfDate = product_manfDate;
		this.product_expDate = product_expDate;
		Description = description;
		QuantityInStock = quantityInStock;
		SupplierID = supplierID;
		IsActive = isActive;
		Rating = rating;
	}

}
