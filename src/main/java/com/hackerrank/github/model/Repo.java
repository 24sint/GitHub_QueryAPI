package com.hackerrank.github.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Repo implements Serializable{
	
	
	private static final long serialVersionUID = -8489578251865084683L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="repo_id")
    private Long id;
    private String name;
    private String url;
    


	public Repo() {}

    public Repo(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
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
