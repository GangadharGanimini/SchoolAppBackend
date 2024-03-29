package net.javaguides.springboot.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Teacher;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, Long>{

}
