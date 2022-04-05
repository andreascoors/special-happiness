/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.db;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * id, name, beschreibung, start-, enddatum, aufwand, projekt, mitarbeiter-Liste
 * @author AndreasCoors
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Arbeitspakete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String beschreibung;
	private java.sql.Date startDatum;
	private java.sql.Date endDatum;
	private int aufwand;
	@OneToOne
	private Projekte projekt;
	@OneToMany
	private List<Mitarbeiter> mitarbeiter;
}
