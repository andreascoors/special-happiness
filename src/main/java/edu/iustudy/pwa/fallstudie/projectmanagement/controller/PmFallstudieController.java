/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.iustudy.pwa.fallstudie.projectmanagement.db.Projekte;
import edu.iustudy.pwa.fallstudie.projectmanagement.service.PmFallstudieService;

/**
 * @author AndreasCoors
 *
 */
@RestController
@RequestMapping("/app")
public class PmFallstudieController {
	@Autowired
	PmFallstudieService pmfsService;
	
	@GetMapping("/projekte") 
	Iterable<Projekte> getProjekte() {
		return pmfsService.findeAlleProjekte();
	}
}
