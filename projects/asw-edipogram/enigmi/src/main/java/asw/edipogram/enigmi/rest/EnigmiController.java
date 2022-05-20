package asw.edipogram.enigmi.rest;

import asw.edipogram.enigmi.domain.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger; 
import java.util.*; 
import java.util.stream.*; 

@RestController
public class EnigmiController {

	@Autowired 
	private EnigmiService enigmiService; 

	private final Logger logger = Logger.getLogger(EnigmiController.class.toString()); 

	/* Crea un nuovo enigma. */ 
	@PostMapping("/enigmi")
	public Enigma createEnigma(@RequestBody CreateEnigmaRequest request) {
		String autore = request.getAutore();
		String tipo = request.getTipo();
		String tipoSpecifico = request.getTipoSpecifico();
		String titolo = request.getTitolo();
		String[] testo = request.getTesto();
		String[] soluzione = request.getSoluzione();
		logger.info("REST CALL: createEnigma " + autore + ", " + tipo + ", " + tipoSpecifico + ", " + titolo + ", " + toString(testo) + ", " + toString(soluzione)); 
		Enigma enigma = enigmiService.createEnigma(autore, tipo, tipoSpecifico, titolo, testo, soluzione);
		return enigma; 
	}	

	/* Trova l'enigma con enigmaId. */ 
	@GetMapping("/enigmi/{enigmaId}")
	public Enigma getEnigma(@PathVariable Long enigmaId) {
		logger.info("REST CALL: getEnigma " + enigmaId); 
		Enigma enigma = enigmiService.getEnigma(enigmaId);
		if (enigma!=null) {
			logger.info("REST CALL: getEnigma " + enigmaId + ": " + enigma); 
			return enigma;
		} else {
			logger.info("REST CALL: getEnigma " + enigmaId + ": Enigma not found"); 
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Enigma not found"
			);
		}
	}

	/* Trova la soluzione dell'enigma con enigmaId. */ 
	@GetMapping("/enigmi/{enigmaId}/soluzione")
	public String[] getSoluzioneEnigma(@PathVariable Long enigmaId) {
		logger.info("REST CALL: getSoluzioneEnigma " + enigmaId); 
		Enigma enigma = enigmiService.getEnigma(enigmaId);
		String[] soluzione = null; 
		if (enigma!=null) {
			soluzione = enigma.getSoluzione(); 
			logger.info("REST CALL: getSoluzioneEnigma " + enigmaId + ": " + toString(soluzione)); 
			return soluzione;
		} else {
			logger.info("REST CALL: getSoluzioneEnigma " + enigmaId + ": Enigma not found"); 
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Enigma not found"
			);
		}
	}

	/* Trova tutti gli enigmi (in formato breve). */ 
	@GetMapping("/enigmi")
	public Collection<GetEnigmaResponse> getEnigmi() {
		Collection<Enigma> enigmi = null; 
		Collection<GetEnigmaResponse> enigmiResponse = null; 
		logger.info("REST CALL: getEnigmi"); 
		enigmi = enigmiService.getEnigmi();
		enigmiResponse = toEnigmiResponse(enigmi);
		logger.info("REST CALL: getEnigmi: " + enigmiResponse); 
		return enigmiResponse;
	}
	
	/* Trova tutti gli enigmi (in formato breve) di un autore. */ 
	@GetMapping("/cercaenigmi/autore/{autore}")
	public Collection<GetEnigmaResponse> getEnigmiByAutore(@PathVariable String autore) {
		Collection<Enigma> enigmi = null; 
		Collection<GetEnigmaResponse> enigmiResponse = null; 
		logger.info("REST CALL: getEnigmiByAutore " + autore); 
		enigmi = enigmiService.getEnigmiByAutore(autore);
		enigmiResponse = toEnigmiResponse(enigmi);
		logger.info("REST CALL: getEnigmiByAutore " + autore + ": " + enigmiResponse); 
		return enigmiResponse;
	}

	/* Trova tutti gli enigmi (in formato breve) di un insieme di autori. */ 
	@GetMapping("/cercaenigmi/autori/{autori}")
	public Collection<GetEnigmaResponse> getEnigmiByAutori(@PathVariable Collection<String> autori) {
		Collection<Enigma> enigmi = null; 
		Collection<GetEnigmaResponse> enigmiResponse = null; 
		logger.info("REST CALL: getEnigmiByAutori " + autori); 
		enigmi = enigmiService.getEnigmiByAutori(autori);
		enigmiResponse = toEnigmiResponse(enigmi);
		logger.info("REST CALL: getEnigmiByAutori " + autori + ": " + enigmiResponse); 
		return enigmiResponse;
	}

	/* Trova tutti gli enigmi (in formato breve) di un certo tipo. */ 
	@GetMapping("/cercaenigmi/tipo/{tipo}")
	public Collection<GetEnigmaResponse> getEnigmiByTipo(@PathVariable String tipo) {
		Collection<Enigma> enigmi = null; 
		Collection<GetEnigmaResponse> enigmiResponse = null; 
		logger.info("REST CALL: getEnigmiByTipo " + tipo); 
		enigmi = enigmiService.getEnigmiByTipo(tipo);
		enigmiResponse = toEnigmiResponse(enigmi);
		logger.info("REST CALL: getEnigmiByTipo " + tipo + ": " + enigmiResponse); 
		return enigmiResponse;
	}

	/* Trova tutti gli enigmi (in formato breve) di un insieme di tipi. */ 
	@GetMapping("/cercaenigmi/tipi/{tipi}")
	public Collection<GetEnigmaResponse> getEnigmiByTipi(@PathVariable Collection<String> tipi) {
		Collection<Enigma> enigmi = null; 
		Collection<GetEnigmaResponse> enigmiResponse = null; 
		logger.info("REST CALL: getEnigmiByTipi " + tipi); 
		enigmi = enigmiService.getEnigmiByTipi(tipi);
		enigmiResponse = toEnigmiResponse(enigmi);
		logger.info("REST CALL: getEnigmiByTipi " + tipi + ": " + enigmiResponse); 
		return enigmiResponse;
	}

	/* Converte una collezione di enigmi (in formato completo), in una collezione di enigmi (in formato breve). */ 
	private Collection<GetEnigmaResponse> toEnigmiResponse(Collection<Enigma> enigmi) {
		Collection<GetEnigmaResponse> enigmiResponse = 
			enigmi
				.stream()
				.map(r -> new GetEnigmaResponse(r))
				.collect(Collectors.toList());
		return enigmiResponse; 
	}

	private static String toString(String[] a) {
		return Arrays.toString(a); 
	}

}
