/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.iustudy.pwa.fallstudie.projectmanagement.db.Mitarbeiter;
import edu.iustudy.pwa.fallstudie.projectmanagement.repository.MitarbeiterRepository;

/**
 * @author AndreasCoors
 *
 */
@RestController
@RequestMapping("/api/mitarbeiter")
public class MitarbeiterController {
	@Autowired
	MitarbeiterRepository mitarbeiterRepo;
	
	@PostMapping
	public ResponseEntity<Mitarbeiter> create(@RequestBody Mitarbeiter mitarbeiter) {
		return new ResponseEntity<>(mitarbeiterRepo.save(mitarbeiter), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Iterable<Mitarbeiter>> retrieve() {
		if (mitarbeiterRepo.count() > 0)
			return new ResponseEntity<>(mitarbeiterRepo.findAll(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("{id}")
	public ResponseEntity<Optional<Mitarbeiter>> retrieve(@PathVariable long id) {
		if (mitarbeiterRepo.existsById(id))
			return new ResponseEntity<>(mitarbeiterRepo.findById(id), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("{id}")
	public ResponseEntity<Mitarbeiter> update(@PathVariable long id, @RequestBody Mitarbeiter mitarbeiter) {
		Optional<Mitarbeiter> mitarbeitereDaten = mitarbeiterRepo.findById(id);
		if (mitarbeitereDaten.isPresent()) {
			Mitarbeiter _mitarbeiter = mitarbeitereDaten.get();
			if (mitarbeiter.getVorname() != null)
				_mitarbeiter.setVorname(mitarbeiter.getVorname());
			if (mitarbeiter.getNachname() != null)
				_mitarbeiter.setNachname(mitarbeiter.getNachname());
			if (mitarbeiter.getGeburtsdatum() != null)
				_mitarbeiter.setGeburtsdatum(mitarbeiter.getGeburtsdatum());
			if (mitarbeiter.getAdresse() != null)
				_mitarbeiter.setAdresse(mitarbeiter.getAdresse());
			return new ResponseEntity<>(mitarbeiterRepo.save(_mitarbeiter), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
		try {
			mitarbeiterRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<HttpStatus> delete() {
		try {
			mitarbeiterRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
