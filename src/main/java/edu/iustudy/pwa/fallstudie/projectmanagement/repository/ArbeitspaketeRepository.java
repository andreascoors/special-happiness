/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.iustudy.pwa.fallstudie.projectmanagement.db.Arbeitspakete;

/**
 * @author AndreasCoors
 *
 */
@Repository
public interface ArbeitspaketeRepository extends CrudRepository<Arbeitspakete, Long> {
	List<Arbeitspakete> findAllByProjektId(long id);
}
