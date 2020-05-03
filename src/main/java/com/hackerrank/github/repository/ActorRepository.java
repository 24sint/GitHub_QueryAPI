package com.hackerrank.github.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.github.model.Actor;


public interface ActorRepository extends JpaRepository<Actor, Long> {

	List<Actor> findAllById(Long id);


}
