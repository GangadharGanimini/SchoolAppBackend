package net.javaguides.springboot.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import net.javaguides.springboot.model.Student;



@RepositoryRestResource
public interface StudentRepository extends MongoRepository<Student, Long>{

}
