package com.hackerrank.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.EventsRepository;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
	@Autowired
	EventsRepository eventRepository;
	
	
	@DeleteMapping()
	@ResponseStatus(HttpStatus.OK)
	public void deleteEvent(Event id) {
		eventRepository.deleteAll();
	}

}
