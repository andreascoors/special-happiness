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

import edu.iustudy.pwa.fallstudie.projectmanagement.db.Arbeitspakete;
import edu.iustudy.pwa.fallstudie.projectmanagement.repository.ArbeitspaketeRepository;

/**
 * @author AndreasCoors
 *
 */
@RestController
@RequestMapping("/api/arbeitspakete")
public class ArbeitspaketeController {
	@Autowired
	ArbeitspaketeRepository apRepo;
	
	@PostMapping
	public ResponseEntity<Arbeitspakete> create(@RequestBody Arbeitspakete ap) {
		return new ResponseEntity<>(apRepo.save(ap), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Iterable<Arbeitspakete>> retrieve() {
		if (apRepo.count() > 0)
			return new ResponseEntity<>(apRepo.findAll(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("{id}")
	public ResponseEntity<Optional<Arbeitspakete>> retrieve(@PathVariable long id) {
		if (apRepo.existsById(id))
			return new ResponseEntity<>(apRepo.findById(id), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("{id}")
	public ResponseEntity<Arbeitspakete> update(@PathVariable long id, @RequestBody Arbeitspakete ap) {
		Optional<Arbeitspakete> apeDaten = apRepo.findById(id);
		if (apeDaten.isPresent()) {
			Arbeitspakete _ap = apeDaten.get();
			if (ap.getName() != null)
				_ap.setName(ap.getName());
			if (ap.getBeschreibung() != null)
				_ap.setBeschreibung(ap.getBeschreibung());
			if (ap.getAufwand() > 0)
				_ap.setAufwand(ap.getAufwand());
			if (ap.getStartDatum() != null)
				_ap.setStartDatum(ap.getStartDatum());
			if (ap.getEndDatum() != null)
				_ap.setEndDatum(ap.getEndDatum());
			if (ap.getMitarbeiter() != null)
				_ap.setMitarbeiter(ap.getMitarbeiter());
			return new ResponseEntity<>(apRepo.save(_ap), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
		try {
			apRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<HttpStatus> delete() {
		try {
			apRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
