package asw.edipogram.enigmiseguiti.rest;

import asw.edipogram.enigmiseguiti.domain.*; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant; 
import java.time.Duration; 

import java.util.logging.Logger; 
import java.util.*; 

@RestController
public class EnigmiSeguitiController {

	private final Logger logger = Logger.getLogger(EnigmiSeguitiController.class.toString()); 

	@Autowired 
	private EnigmiSeguitiService enigmiSeguitiService;

	/* Trova gli enigmi (in formato breve) degli utenti seguiti da utente. */ 
	@GetMapping("/enigmiseguiti/{utente}")
	public Collection<Enigma> getEnigmiSeguiti(@PathVariable String utente) {
		Instant start = Instant.now();
		logger.info("REST CALL: getEnigmiSeguiti " + utente); 
		Collection<Enigma> enigmi = enigmiSeguitiService.getEnigmiSeguiti(utente); 
		Duration duration = Duration.between(start, Instant.now()); 
		logger.info("getEnigmiSeguiti " + utente + " (trovati " + enigmi.size() + " enigmi in " + duration.toMillis() + " ms): " + enigmi);
		return enigmi; 
	}
	
}
