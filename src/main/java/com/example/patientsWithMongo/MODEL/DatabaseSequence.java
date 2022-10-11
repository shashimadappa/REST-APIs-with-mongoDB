package com.example.patientsWithMongo.MODEL;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
@Document(collection = "database_sequence")
public class DatabaseSequence {
        @Id
        private String id;

        private Integer seq;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getSeq() {
            return seq;
        }

        public void setSeq(Integer seq) {
            this.seq = seq;
        }

        public DatabaseSequence(String id, Integer seq) {
            this.id = id;
            this.seq = seq;
        }

        @Override
        public String toString() {
            return "DatabaseSequence{" +
                    "id='" + id + '\'' +
                    ", seq=" + seq +
                    '}';
        }
}
