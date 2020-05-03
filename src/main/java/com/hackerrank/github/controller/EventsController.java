package com.hackerrank.github.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventsRepository;
import com.hackerrank.github.repository.RepoRepository;



@RestController
@RequestMapping(value = "/events")
public class EventsController {

	@Autowired
	EventsRepository eventsRepository;
	@Autowired
	ActorRepository actorRepository;
	@Autowired
	RepoRepository repoRepository;
 
	
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Event saveEvent(@RequestBody Event event, Object repos ) {
		
		Event createdEvent = new Event(event.getId(), event.getType(), event.getActor(), event.getRepo(), event.getCreatedAt());
		
		Repo newRepo = repoRepository.save(createdEvent.getRepo());
		Actor newActor = actorRepository.save(createdEvent.getActor());
		
		
		List<Repo> repo = repoRepository.findAllById(newRepo.getId());
		newActor.setRepos(repo);
		
		List<Actor> actor = actorRepository.findAllById(newActor.getId());
		newRepo.setActors(actor);
		
	    return  eventsRepository.save(createdEvent);
		
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getEventById(@PathVariable Long id) {
	
			Event foundEvent = eventsRepository.findEventById(id);
			if(foundEvent == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
				
			}
			return ResponseEntity.ok(foundEvent);	
		
		}
		
	@GetMapping("/repos/{repoID}/actors/{actorID}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Event>> getEventByRepoAndActorId(@PathVariable("repoID") Long repoID, @PathVariable("actorID") Long actorID) {
		List<Event> allEvents =  eventsRepository.findAll();
		List<Event> feachedEvent = new ArrayList<>();
		for(Event num : allEvents) {
			if(num.getActor().getId()== actorID && num.getRepo().getId()==repoID ) {
				feachedEvent.add(num);
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			
		}
		return ResponseEntity.ok(feachedEvent);	
	}
	
	@GetMapping("/repos/{repoID}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Event>> getEventByRepoId(@PathVariable Long repoID) {
		List<Event> allEvents =  eventsRepository.findAll();
		List<Event> feachedEvent = new ArrayList<>();
		for(Event num : allEvents) {
			if( num.getRepo().getId()==repoID ) {
				feachedEvent.add(num);
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			
		}
		return ResponseEntity.ok(feachedEvent);	
	}
	@GetMapping("/actors/{actorID}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Event>> getEventByActorId(@PathVariable Long actorID) {
		List<Event> allEvents =  eventsRepository.findAll();
		List<Event> feachedEvent = new ArrayList<>();
		for(Event num : allEvents) {
			if( num.getActor().getId()==actorID ) {
				feachedEvent.add(num);
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}	
			
		}
		return ResponseEntity.ok(feachedEvent);	
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Event> getEvent() {
		return eventsRepository.findAll();
	}	

}
