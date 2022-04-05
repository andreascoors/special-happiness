/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.iustudy.pwa.fallstudie.projectmanagement.service.PmFallstudieService;

/**
 * @author AndreasCoors
 *
 */
@RestController
@RequestMapping("app/")
public class PmFallstudieController {
	@Autowired
	PmFallstudieService pmfsService;
}
