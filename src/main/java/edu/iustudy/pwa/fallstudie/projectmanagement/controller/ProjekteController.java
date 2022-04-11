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

import edu.iustudy.pwa.fallstudie.projectmanagement.db.Projekte;
import edu.iustudy.pwa.fallstudie.projectmanagement.repository.ProjekteRepository;

/**
 * @author AndreasCoors
 *
 */
@RestController
@RequestMapping("/api/projekte")
public class ProjekteController {
	@Autowired
	ProjekteRepository projekteRepo;

	@PostMapping
	public ResponseEntity<Projekte> create(@RequestBody Projekte projekt) {
		return new ResponseEntity<>(projekteRepo.save(projekt), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Iterable<Projekte>> retrieve() {
		if (projekteRepo.count() > 0)
			return new ResponseEntity<>(projekteRepo.findAll(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("{id}")
	public ResponseEntity<Optional<Projekte>> retrieve(@PathVariable long id) {
		if (projekteRepo.existsById(id))
			return new ResponseEntity<>(projekteRepo.findById(id), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("{id}")
	public ResponseEntity<Projekte> update(@PathVariable long id, @RequestBody Projekte projekt) {
		Optional<Projekte> projekteDaten = projekteRepo.findById(id);
		if (projekteDaten.isPresent()) {
			Projekte _projekt = projekteDaten.get();
			if (projekt.getName() != null)
				_projekt.setName(projekt.getName());
			if (projekt.getBeschreibung() != null)
				_projekt.setBeschreibung(projekt.getBeschreibung());
			if (projekt.getStartDatum() != null)
				_projekt.setStartDatum(projekt.getStartDatum());
			if (projekt.getEndDatum() != null)
				_projekt.setEndDatum(projekt.getEndDatum());
			if (projekt.getMitarbeiter() != null)
				_projekt.setMitarbeiter(projekt.getMitarbeiter());
			return new ResponseEntity<>(projekteRepo.save(_projekt), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
		try {
			projekteRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<HttpStatus> delete() {
		try {
			projekteRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
