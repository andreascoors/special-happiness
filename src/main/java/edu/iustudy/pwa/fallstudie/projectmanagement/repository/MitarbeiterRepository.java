/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.iustudy.pwa.fallstudie.projectmanagement.db.Mitarbeiter;

/**
 * @author AndreasCoors
 *
 */
@Repository
public interface MitarbeiterRepository extends CrudRepository<Mitarbeiter, Long> {

}
