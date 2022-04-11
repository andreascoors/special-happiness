/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
 * id, vor-, nachname, geburtsdatum, adresse
 * @author AndreasCoors
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mitarbeiter{
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String vorname;
	@NotEmpty
	private String nachname;
	@Temporal(TemporalType.DATE)
	private Date geburtsdatum;
	@NotEmpty
	private String adresse;
}
