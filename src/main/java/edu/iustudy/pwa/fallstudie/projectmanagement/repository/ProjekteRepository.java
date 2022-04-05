/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.iustudy.pwa.fallstudie.projectmanagement.db.Projekte;

/**
 * @author AndreasCoors
 *
 */
@Repository
public interface ProjekteRepository extends CrudRepository<Projekte, Long> {

}
