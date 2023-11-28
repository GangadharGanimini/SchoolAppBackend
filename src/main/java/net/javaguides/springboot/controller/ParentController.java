package net.javaguides.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.model.Parent;
import net.javaguides.springboot.service.ParentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parents")
public class ParentController {
	private static final Logger logger = LoggerFactory.getLogger(ParentController.class);

	@Autowired
	private ParentService parentService;

	@GetMapping("/getAllParents")
	public ResponseEntity<List<Parent>> getAllParents() {
//        return parentService.getAllParents();
		try {
			logger.info("Attempting to retrieve all parents from the database.");

			ResponseEntity<List<Parent>> parents = parentService.getAllParents();

			logger.info("Successfully retrieved all parents.");

			return parents;
		} catch (Exception e) {
			logger.error("An error occurred while handling the request.", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("getStudentById/{id}")
	public ResponseEntity<Parent> getParentById(@RequestParam(required = false) String id,
			@RequestParam(required = false) String name) {

		try {
			// Delegate the logic to the service
			ResponseEntity<Parent> response = parentService.getParentById(id, name);

			// Log success or other relevant information
			logger.info("Successfully retrieved parent by id or name.");

			return response;
		} catch (Exception e) {
			// Log the exception for debugging purposes
			logger.error("An error occurred while processing the request.", e);

			// Return an internal server error response
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addParent")
	public ResponseEntity<Parent> addParent(@RequestBody Parent parent) {
//        return new ResponseEntity<>(parentService.addParent(parent), HttpStatus.CREATED);
		try {
			logger.info("Attempting to add a new parent: {}", parent);

			Parent addedParent = parentService.addParent(parent);

			logger.info("Successfully added a new parent: {}", addedParent);

			return new ResponseEntity<>(addedParent, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("An error occurred while adding a new parent: {}", parent, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Parent> updateParent(@PathVariable String id, @RequestBody Parent updatedParent) {
//        return parentService.updateParent(id, updatedParent);
		try {
			logger.info("Attempting to update parent with ID {} with data: {}", id, updatedParent);

			ResponseEntity<Parent> response = parentService.updateParent(id, updatedParent);

			if (response.getStatusCode() == HttpStatus.OK) {
				logger.info("Successfully updated parent with ID: {}", id);
			} else {
				logger.warn("Failed to update parent with ID {}. Status code: {}", id, response.getStatusCodeValue());
			}

			return response;
		} catch (Exception e) {
			logger.error("An error occurred while updating parent with ID: {}", id, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteParent(@PathVariable String id) {
//        return parentService.deleteParent(id);
		try {
			logger.info("Attempting to delete parent with ID: {}", id);

			ResponseEntity<String> response = parentService.deleteParent(id);

			if (response.getStatusCode() == HttpStatus.OK) {
				logger.info("Successfully deleted parent with ID: {}", id);
			} else {
				logger.warn("Failed to delete parent with ID {}. Status code: {}", id, response.getStatusCodeValue());
			}

			return response;
		} catch (Exception e) {
			logger.error("An error occurred while deleting parent with ID: {}", id, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}