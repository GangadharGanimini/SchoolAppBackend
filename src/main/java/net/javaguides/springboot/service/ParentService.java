package net.javaguides.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.exception.ParentCreationException;
import net.javaguides.springboot.model.Parent;
import net.javaguides.springboot.model.Standard;
import net.javaguides.springboot.repository.ParentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

	private static final Logger logger = LoggerFactory.getLogger(ParentService.class);

	@Autowired
	private ParentRepository parentRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	public ResponseEntity<List<Parent>> getAllParents() {
		try {
			logger.info("Attempting to retrieve all parents from the database.");

			List<Parent> parents = mongoTemplate.findAll(Parent.class);
			logger.info("Successfully retrieved all parents.");
			return new ResponseEntity<>(parents, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("An error occurred while retrieving all parents.", e);

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Parent> getParentById(String id, String name) {
        try {
            Query query = new Query();

            if (id != null) {
                query.addCriteria(Criteria.where("_id").is(id));
            } else if (name != null) {
            	 query.addCriteria(Criteria.where("name").regex(name, "i"));
            } else {
                // Both id and name are null, which is not a valid state
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Parent parent = mongoTemplate.findOne(query, Parent.class);

            return new ResponseEntity<>(parent, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("An error occurred while retrieving the parent.", e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


	public Parent addParent(Parent parent) {
		try {
			logger.info("Attempting to save a new parent: {}", parent);
			
			 String firstName = parent.getFirstName();
		        String middleName = parent.getMiddleName();
		        String lastName = parent.getLastName();

		        String fullName = (firstName + " " + (middleName != null ? middleName + " " : "") + lastName).trim();

		        parent.setName(fullName);

			mongoTemplate.save(parent);

			logger.info("Successfully saved a new parent: {}", parent);
			return parent; // Return the saved parent object
		} catch (Exception e) {
			logger.error("Error creating parent: {}", e.getMessage(), e);

			throw new ParentCreationException("Error creating parent: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Parent> updateParent(@PathVariable String id, @RequestBody Parent updatedParent) {

		try {
			logger.info("Attempting to update parent with ID {} with data: {}", id, updatedParent);

			Parent existingParent = mongoTemplate.findById(id, Parent.class);
			if (existingParent != null) {
				existingParent.setFirstName(updatedParent.getFirstName());
				existingParent.setMiddleName(updatedParent.getMiddleName());
				existingParent.setLastName(updatedParent.getLastName());
				existingParent.setDateOfBirth(updatedParent.getDateOfBirth());
				existingParent.setPhoneNumber(updatedParent.getPhoneNumber());
				existingParent.setPhoneNumber2(updatedParent.getPhoneNumber2());
				existingParent.setEmail(updatedParent.getEmail());
				existingParent.setQualification(updatedParent.getQualification());
				existingParent.setGender(updatedParent.getGender());

				mongoTemplate.save(existingParent);
				logger.info("Successfully updated parent with ID: {}", id);

				return new ResponseEntity<>(existingParent, HttpStatus.OK);
			} else {
				logger.warn("Parent with ID {} not found.", id);
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				
			}
		} catch (Exception e) {
			logger.error("An error occurred while updating parent with ID: {}", id, e);

			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		}

	}

	public ResponseEntity<String> deleteParent(String id) {
		try {
			logger.info("Attempting to delete parent with ID: {}", id);

			Query query = new Query(Criteria.where("id").is(id));
			Parent deletedParent = mongoTemplate.findAndRemove(query, Parent.class);
			if (deletedParent != null) {
				logger.info("Successfully deleted parent with ID: {}", id);

				return new ResponseEntity<>("Parent deleted successfully", HttpStatus.OK);
			} else {
				logger.warn("Parent with ID {} not found.", id);

				return new ResponseEntity<>("Parent not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("An error occurred while deleting parent with ID: {}", id, e);

			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}