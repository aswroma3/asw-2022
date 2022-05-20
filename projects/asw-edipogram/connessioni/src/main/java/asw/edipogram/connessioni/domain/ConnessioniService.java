package asw.edipogram.connessioni.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 
import java.util.*; 

@Service
public class ConnessioniService {

	@Autowired
	private ConnessioniRepository connessioniRepository;

 	public Connessione createConnessione(String utente, String tipo) {
		Connessione connessione = new Connessione(utente, tipo); 
		connessione = connessioniRepository.save(connessione);
		return connessione;
	}

 	public Connessione getConnessione(Long id) {
		Connessione connessione = connessioniRepository.findById(id).orElse(null);
		return connessione;
	}

 	public Collection<Connessione> getConnessioni() {
		Collection<Connessione> connessioni = connessioniRepository.findAll();
		return connessioni;
	}

	public Collection<Connessione> getConnessioniByUtente(String utente) {
		Collection<Connessione> connessioni = connessioniRepository.findByUtente(utente);
		return connessioni;
	}

}
