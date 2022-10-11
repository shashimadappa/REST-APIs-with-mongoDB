package com.example.patientsWithMongo.REPO;

import com.example.patientsWithMongo.MODEL.PatientDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<PatientDetails, Integer>{

}
