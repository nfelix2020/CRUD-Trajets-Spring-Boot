package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Trajet;

@Repository
public interface TrajectRepository extends JpaRepository<Trajet, Long>{
	
	

}
