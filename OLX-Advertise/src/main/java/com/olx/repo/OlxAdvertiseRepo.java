package com.olx.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.olx.entity.AdvertiseEntity;


public interface OlxAdvertiseRepo extends JpaRepository<AdvertiseEntity, Integer>{

	@Query("SELECT p FROM AdvertiseEntity p WHERE CONCAT(p.title, p.price, p.description, p.status) LIKE %?1%")
	public List<AdvertiseEntity> search(String keyword);
	
	public List<AdvertiseEntity> findByTitleAndPriceAndStatus(
			String title, Double price, String status);

	public List<AdvertiseEntity> findByTitleAndPriceAndStatusAndCreatedDate(String title, Double price, 
			String status,
			Date createdDate);
	
	public List<AdvertiseEntity> findByTitleAndPrice(String title, Double price);

	public List<AdvertiseEntity> findByTitle(String title);

	
}
