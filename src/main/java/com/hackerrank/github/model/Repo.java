package com.hackerrank.github.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Repo implements Serializable{
	
	
	private static final long serialVersionUID = -8489578251865084683L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="repo_id")
    private Long id;
    private String name;
    private String url;
    
  
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "repo_actor", joinColumns = @JoinColumn(name = "repo_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors = new ArrayList<>();


	public Repo() {
    }

    public Repo(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }


    public List<Actor> getActors() {
 		return actors;
 	}

 	public void setActors(List<Actor> actors) {
 		this.actors = actors;
 	}
    
	public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
