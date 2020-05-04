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
public class Actor implements Serializable{

	private static final long serialVersionUID = 8365699840450167067L;
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="actor_id")
    private Long id;
    private String login;
    private String avatar_url;
    
    @ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "actor_repo", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "repo_id"))
    @JsonIgnore
    private List<Repo> repos = new ArrayList<>();
   
    public Actor() {}


	public Actor(Long id, String login, String avatar_url) {
		
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getavatar_url() {
        return avatar_url;
    }
    
    public void setavatar_url(String avatar_url) {
        this.avatar_url =avatar_url;
    }

    public List<Repo> getRepos() {
		return repos;
	}

	public void setRepos(List<Repo> repos) {
		this.repos = repos;
	}
}
