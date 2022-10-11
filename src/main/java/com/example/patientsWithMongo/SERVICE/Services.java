package com.example.patientsWithMongo.SERVICE;

import com.example.patientsWithMongo.MODEL.DatabaseSequence;
import com.example.patientsWithMongo.MODEL.PatientDetails;
import com.example.patientsWithMongo.REPO.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class Services {
    @Autowired
    private Repository repository;

    @Autowired
    private MongoRepository mongoRepository;

    private MongoOperations mongoOperations;

    @Autowired
    public  Services(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Integer generateSequence(String seqName) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq", 1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
    public ResponseEntity getall() {
        List<PatientDetails> details = mongoRepository.findAll();
        return ResponseEntity.ok().body(details);
    }
//
//    public ResponseEntity getbyId(Integer id) {
//        Optional<PatientDetails> details = mongoRepository.findById(id);
//        if (details.isPresent()) {
//            return ResponseEntity.ok().body(details);
//        }
//        return ResponseEntity.ok().body("no patient found");
//    }
//
//    public ResponseEntity delete(Integer id) {
//        mongoRepo.deleteById(id);
//        return ResponseEntity.ok().body("deleted");
//
//    }
}
