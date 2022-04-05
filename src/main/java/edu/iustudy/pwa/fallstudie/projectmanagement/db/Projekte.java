/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.db;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author AndreasCoors
 *
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Projekte {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String beschreibung;
	private java.sql.Date startDatum;
	private java.sql.Date endDatum;
	@OneToMany
	private List<Mitarbeiter> zugehörig;
	
	
}
