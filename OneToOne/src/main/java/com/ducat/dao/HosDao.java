package com.ducat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.HeadOfState;

@Repository
public interface HosDao extends 
	CrudRepository<HeadOfState, Integer> {

}
