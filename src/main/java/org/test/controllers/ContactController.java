package org.test.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.dtos.ContactDto;
import org.test.services.ContactService;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public ResponseEntity<Set<ContactDto>> getAllContacts() {
		return new ResponseEntity<>(contactService.getAllContacts(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ContactDto> saveContacts(@RequestBody ContactDto contact) {
		return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ContactDto> updateContacts(@PathVariable("id") Long id, @RequestBody ContactDto contact) {
		return new ResponseEntity<>(contactService.updateContact(id, contact), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ContactDto> getContacts(@PathVariable("id") Long id) {
		return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteContact(@PathVariable("id") Long id) {
		contactService.deleteContact(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
