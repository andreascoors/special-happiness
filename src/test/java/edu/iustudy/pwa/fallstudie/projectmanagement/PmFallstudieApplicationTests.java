package edu.iustudy.pwa.fallstudie.projectmanagement;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.iustudy.pwa.fallstudie.projectmanagement.db.Mitarbeiter;
import edu.iustudy.pwa.fallstudie.projectmanagement.db.Projekte;
import edu.iustudy.pwa.fallstudie.projectmanagement.repository.ArbeitspaketeRepository;
import edu.iustudy.pwa.fallstudie.projectmanagement.repository.MitarbeiterRepository;
import edu.iustudy.pwa.fallstudie.projectmanagement.repository.ProjekteRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PmFallstudieApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ProjekteRepository projektRepo;
	@Autowired
	ArbeitspaketeRepository apRepo;
	@Autowired
	MitarbeiterRepository mitarbeiterRepo;

	// TODO Testfälle überlegen
	// FIXME JUnit-Tests umschreiben
	
	@SuppressWarnings("deprecation")
	@Test
	@Transactional
	public void givenProjects_WhenGetAll_ThenExpectProjects() throws Exception {
		Set<Mitarbeiter> testMitarbeiter = Set.of(
				Mitarbeiter.builder().vorname("Andreas").nachname("Coors").geburtsdatum(new Date(1995, 10, 15))
						.adresse("Musterstr. 12, 123456 Musterstadt").build(),
				Mitarbeiter.builder().vorname("Andreas1").nachname("Coors1").geburtsdatum(new Date(1995, 10, 15))
						.adresse("Musterstr. 12, 123456 Musterstadt").build());

		mitarbeiterRepo.saveAll(testMitarbeiter);
		
		List<Projekte> testProjekte = List.of(
				Projekte.builder().mitarbeiter(testMitarbeiter).name("TestProjekt").startDatum(new Date(2022, 04, 04))
						.build(),
				Projekte.builder().mitarbeiter(testMitarbeiter).name("TestProjekt2").startDatum(new Date(2022, 04, 04))
						.build());

		projektRepo.saveAll(testProjekte);

		// mockMvc.perform(MockMvcRequestBuilders.post("/stats/search").contentType(MediaType.APPLICATION_JSON).content(SearchEntity.builder().time(LocalDateTime.now()).session("12345689001234567890123456789012")
		// .term("gonnafound").results(1).build().toString()));

		ResultActions response = mockMvc
				.perform(MockMvcRequestBuilders.get("/api/projekte").contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray());

	}
}
