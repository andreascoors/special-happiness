/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

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
	@NotEmpty
	@Column(unique=true) 
	private String name;
	@Lob
	private String beschreibung;
	@Temporal(TemporalType.DATE)
	private Date startDatum;
	@Temporal(TemporalType.DATE)
	private Date endDatum;
	@NotEmpty
	private int aufwand;
	@ManyToOne
	@NotEmpty
	private Projekte projekt;
	@OneToOne
	private Mitarbeiter mitarbeiter;
}
