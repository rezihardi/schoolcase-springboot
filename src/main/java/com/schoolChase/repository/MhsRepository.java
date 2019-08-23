package com.schoolChase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolChase.model.Mhs;

@Repository
public interface MhsRepository extends JpaRepository<Mhs, Long>{
	
	
}
