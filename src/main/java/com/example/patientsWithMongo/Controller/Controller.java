package com.example.patientsWithMongo.Controller;

import com.example.patientsWithMongo.MODEL.PatientDetails;
import com.example.patientsWithMongo.REPO.Repository;
import com.example.patientsWithMongo.SERVICE.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private Services services;
    @Autowired
    private Repository repository;

    @PostMapping("/save")
    public PatientDetails createEmployee(@Validated @RequestBody PatientDetails details) {
        details.setId(services.generateSequence(PatientDetails.SEQUENCE_NAME));
        return repository.save(details);
    }

    @GetMapping("/getall")
    public ResponseEntity get() {
        return services.getall();
    }
//    @GetMapping("/getall/{id}")
//    public ResponseEntity get2 (@PathVariable Integer id){
//        return mongoServiceSeq.getbyId(id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity delete(@PathVariable Integer id){
//        return     mongoServiceSeq.delete(id);
//
//    }
//
//    @PutMapping("/update/{id}")
//    PatientDetails update(@RequestBody PatientDetails details, @PathVariable Integer id) {
//        return mongoRepo.findById(id)
//                .map(detail -> {
//                    detail.setName(details.getName());
//                    detail.setNumber(details.getNumber());
//                    return mongoRepo.save(detail);
//                })
//                .orElseGet(() -> {
//                    return mongoRepo.save(details);
//                });
//    }
}
