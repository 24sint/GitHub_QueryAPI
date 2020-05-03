package com.hackerrank.github.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.hackerrank.github.model.Event;

public interface EventsRepository extends JpaRepository<Event, Long>{

	Event findEventById(Long id);

}
