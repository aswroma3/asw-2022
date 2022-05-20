package asw.edipogram.connessioni.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.*; 

public interface ConnessioniRepository extends CrudRepository<Connessione, Long> {

	public Collection<Connessione> findAll();

	public Collection<Connessione> findByUtente(String utente);

}

