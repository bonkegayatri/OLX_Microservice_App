package com.olx.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.olx.entity.OlxLoginEntity;


public interface OlxLoginRepo extends JpaRepository<OlxLoginEntity, Integer>{

	List<OlxLoginEntity> findByUsername(String username);


	
}
