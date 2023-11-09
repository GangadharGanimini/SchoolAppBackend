package net.javaguides.springboot.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Teacher;
import net.javaguides.springboot.model.Fees;
import net.javaguides.springboot.model.Student;



@Repository
public interface FeesRepository extends MongoRepository<Fees, Long>{
}
