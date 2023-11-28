package net.javaguides.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.javaguides.springboot.model.Parent;

public interface ParentRepository extends MongoRepository<Parent, String> {
    // You can add custom query methods if needed
}