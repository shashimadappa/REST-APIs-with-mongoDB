package com.example.patientsWithMongo.MODEL;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "patients")
public class PatientDetails {
        @Transient
        public static final String SEQUENCE_NAME = "users_sequence";

        @Id
        private Integer id;

        private String name;

        private Integer number;
    }

