package com.yoga.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yoga.models.Yoga;

public interface YogaRepository extends CrudRepository<Yoga, Long> {

}
