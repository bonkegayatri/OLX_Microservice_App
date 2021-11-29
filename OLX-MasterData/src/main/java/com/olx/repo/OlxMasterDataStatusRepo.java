package com.olx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.entity.StatusEntity;


public interface OlxMasterDataStatusRepo extends JpaRepository<StatusEntity, Integer> {

}
