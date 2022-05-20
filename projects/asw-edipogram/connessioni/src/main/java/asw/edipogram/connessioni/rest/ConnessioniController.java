package asw.edipogram.connessioni.rest;

import asw.edipogram.connessioni.domain.*;

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

@RestController
public class ConnessioniController {

	@Autowired 
	private ConnessioniService connessioniService; 

	private final Logger logger = Logger.getLogger(ConnessioniController.class.toString()); 

	/* Crea una nuova connessione. 
	* La richiesta contiene nel corpo una stringa della forma utente:tipo */ 
	@PostMapping("/connessioni")
	public Connessione createConnessione(@RequestBody CreateConnessioneRequest request) {
		String utente = request.getUtente();
		String tipo = request.getTipo();
		logger.info("REST CALL: createConnessione " + utente + ", " + tipo); 
		Connessione connessione = connessioniService.createConnessione(utente, tipo);
		return connessione; 
	}	

	/* Trova tutte le connessioni. */ 
	@GetMapping("/connessioni")
	public Collection<Connessione> getConnessioni() {
		Collection<Connessione> connessioni = null; 
		logger.info("REST CALL: getConnessioni"); 
		connessioni = connessioniService.getConnessioni();
		logger.info("REST CALL: getConnessioni: " + connessioni); 
		return connessioni;
	}

	/* Trova tutte le connessioni di un utente. */ 
	@GetMapping("/connessioni/{utente}")
	public Collection<Connessione> getConnessioni(@PathVariable String utente) {
		Collection<Connessione> connessioni = null; 
		logger.info("REST CALL: getConnessioni " + utente); 
		connessioni = connessioniService.getConnessioniByUtente(utente);
		logger.info("REST CALL: getConnessioni " + utente + ": " + connessioni); 
		return connessioni;
	}

}
