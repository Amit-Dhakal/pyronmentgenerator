package com.example.PyronmentDocumentGenerator.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.PyronmentDocumentGenerator.model.PyronmentData;

@Repository
public interface PyronmentDocsRepo extends MongoRepository<PyronmentData,String>{
	
	
	
	
	
	

}
