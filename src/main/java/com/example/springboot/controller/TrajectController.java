package com.example.springboot.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.springboot.entity.Trajet;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.repository.TrajectRepository;

 

@RestController
@RequestMapping("/api/trajects")
public class TrajectController {
	
	@Autowired
	private TrajectRepository trajectRepository;
	
	
	//Get All Trajects
	
	//@CrossOrigin("/http://localhost:4200")
	@GetMapping
	public List<Trajet> getTrajects () {
	
		return this.trajectRepository.findAll();	
	}
	
	//Get Traject By Id
	
	@GetMapping("/{id}")
	public Trajet getTrajectById(@PathVariable(value = "id") long trajectId) {
		
		return this.trajectRepository.findById(trajectId)
					.orElseThrow(() -> new ResourceNotFoundException("The Traject with Id "+ trajectId + "is not available"));
	}
	
	
	
	//Create a Traject
	@PostMapping
	public Trajet createTraject (@RequestBody Trajet traject) {
		
		return this.trajectRepository.save(traject);
	}
	
	
	//Edit a Traject 
	
	@PutMapping("/{id}")
	public Trajet editTraject ( @RequestBody Trajet newTraject, @PathVariable ("id") long trajectId) {
	
		Trajet existingTraject= this.trajectRepository.findById(trajectId)
															.orElseThrow(()-> new ResourceNotFoundException("The Traject with Id "+ trajectId + "is not available"));
		
		existingTraject.setNom(newTraject.getNom());
		existingTraject.setEmail(newTraject.getEmail());
		existingTraject.setPhone(newTraject.getPhone());
		existingTraject.setDepart(newTraject.getDepart());
		existingTraject.setDestination(newTraject.getDestination());
		existingTraject.setPrix(newTraject.getPrix());
		
		return this.trajectRepository.save(existingTraject);
	}
	
	//Delete A Traject
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Trajet> deleteTraject(@PathVariable("id") long trajectId){
		
		Trajet existingTrajet= this.trajectRepository.findById(trajectId)
													 .orElseThrow(() -> new ResourceNotFoundException("The Traject with Id "+ trajectId + "is not available"));
		this.trajectRepository.delete(existingTrajet);
		
		return ResponseEntity.ok().build();
	}
	

}
