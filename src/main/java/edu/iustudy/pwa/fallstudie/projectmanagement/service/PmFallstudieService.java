/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iustudy.pwa.fallstudie.projectmanagement.db.Projekte;
import edu.iustudy.pwa.fallstudie.projectmanagement.repository.ArbeitspaketeRepository;
import edu.iustudy.pwa.fallstudie.projectmanagement.repository.MitarbeiterRepository;
import edu.iustudy.pwa.fallstudie.projectmanagement.repository.ProjekteRepository;

/**
 * @author AndreasCoors
 *
 */
@Service
public class PmFallstudieService {

	@Autowired
	ProjekteRepository projektRepo;
	@Autowired
	ArbeitspaketeRepository apRepo;
	@Autowired
	MitarbeiterRepository mitarbeiterRepo;

	@Transactional
	public Iterable<Projekte> findeAlleProjekte() {
		return projektRepo.findAll();
	}
}
