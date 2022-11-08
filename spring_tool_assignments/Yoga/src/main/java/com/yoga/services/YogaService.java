package com.yoga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoga.models.Yoga;
import com.yoga.repositories.YogaRepository;

@Service
public class YogaService {
	
	@Autowired
	private YogaRepository yogaRepo;
	
	public List<Yoga> findAllYogas() {
		return (List<Yoga>)this.yogaRepo.findAll();
	}
	
	public Yoga createNewYoga(Yoga yoga) {
		return this.yogaRepo.save(yoga);
	}
	
	public Yoga getOneYoga(Long id) {
		return this.yogaRepo.findById(id).orElse(null);
	}
	
	public Yoga updateYoga(Yoga yoga) {
		return this.yogaRepo.save(yoga);
	}
	
	public void deleteYoga(Long id) {
		this.yogaRepo.deleteById(id);
	}
}
