/**
 * 
 */
package edu.iustudy.pwa.fallstudie.projectmanagement.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * id, vor-, nachname, geburtsdatum
 * @author AndreasCoors
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mitarbeiter{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String vorname;
	@NotEmpty
	private String nachname;
	@Temporal(TemporalType.DATE)
	private Date geburtsdatum;
	// TODO ... weitere
}
