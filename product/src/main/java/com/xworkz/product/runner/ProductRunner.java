package com.xworkz.product.runner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.product.dto.ProductDto;

public class ProductRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			List<ProductDto> products = new ArrayList<ProductDto>();
			products.add(new ProductDto("juice", 29.99, "2023-01-01", "2025-01-01", "Description1", 100, 1, true, 4.5));
			products.add(
					new ProductDto("biscuit", 49.99, "2023-02-01", "2025-02-01", "Description2", 200, 2, true, 4.7));
			products.add(
					new ProductDto("Cheese", 19.99, "2023-03-01", "2025-03-01", "Description3", 150, 3, false, 3.9));
			products.add(new ProductDto("Bread", 39.99, "2023-04-01", "2025-04-01", "Description4", 50, 4, true, 4.2));
			products.add(
					new ProductDto("Apple", 59.99, "2023-05-01", "2025-05-01", "Description5", 120, 5, false, 4.8));
			products.add(new ProductDto("Banana", 25.99, "2023-06-01", "2025-06-01", "Description6", 80, 6, true, 3.5));
			products.add(
					new ProductDto("Product7", 35.99, "2023-07-01", "2025-07-01", "Description7", 70, 7, true, 4.1));
			products.add(
					new ProductDto("Carrot", 45.99, "2023-08-01", "2025-08-01", "Description8", 90, 8, false, 4.6));
			products.add(new ProductDto("Almond", 55.99, "2023-09-01", "2025-09-01", "Description9", 60, 9, true, 3.8));
			products.add(
					new ProductDto("Honey", 65.99, "2023-10-01", "2025-10-01", "Description10", 110, 10, true, 4.9));

			for (ProductDto dto : products) {
				ProductDto productDto = new ProductDto();
				productDto.setProduct_name(dto.getProduct_name());
				productDto.setProduct_price(dto.getProduct_price());
				productDto.setProduct_manfDate(dto.getProduct_manfDate());
				productDto.setProduct_expDate(dto.getProduct_expDate());
				productDto.setDescription(dto.getDescription());
				productDto.setQuantityInStock(dto.getQuantityInStock());
				productDto.setSupplierID(dto.getQuantityInStock());
				productDto.setIsActive(dto.isIsActive());
				productDto.setRating(dto.getRating());

				em.persist(productDto);

			}

			et.commit();

		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

}
