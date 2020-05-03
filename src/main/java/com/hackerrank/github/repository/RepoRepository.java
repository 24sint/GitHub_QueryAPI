package com.hackerrank.github.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.github.model.Repo;


public interface RepoRepository extends JpaRepository<Repo, Long>{

	List<Repo> findAllById(Long id);



}
