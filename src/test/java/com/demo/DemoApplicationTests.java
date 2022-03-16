package com.demo;

import com.entities.Creneau;
import com.entities.Seance;
import com.entities.Type;
import com.entities.Vacataire;
import com.repositories.CreneauRepository;
import com.repositories.SeanceRepository;
import com.repositories.VacataireRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private VacataireRepository vacataireRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private CreneauRepository creneauRepository;

	@Test
	public void testCreateVacataire() {
		Vacataire unVacataire = new Vacataire();
		unVacataire.setLogin("durand");
		unVacataire.setMail("durand@drd.com");
		unVacataire.setMotDePasse("");
		unVacataire.setNomUsuel("Durand");
		unVacataire.setPrenom("Paul");
		vacataireRepository.save(unVacataire);

	}

	@Test
	public void testUpdateVacataire() {
		Vacataire unVacataire = vacataireRepository.findById(1L).get();
		unVacataire.setMail("durand.paul@gmail.com");
		vacataireRepository.save(unVacataire);

	}

	@Test
	public void testCreateSeance() {
		Seance uneSeance = new Seance();
		uneSeance.setDureeEffective(2);
		uneSeance.setEstEffectue(false);
		uneSeance.setValide(false);
		uneSeance.setCommentaire(" ");
		Creneau unCreneau = new Creneau();
		unCreneau.setTypeCreneau(Type.CM);
		unCreneau.setDate_heure(new Date());
		creneauRepository.save(unCreneau);
		uneSeance.setCreneauSeance(unCreneau);
		seanceRepository.save(uneSeance);
	}


}
