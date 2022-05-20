package asw.edipogram.connessioni.domain;

import javax.persistence.*; 

import lombok.*; 

@Entity 
@Data @NoArgsConstructor
public class Connessione {

	@Id 
	@GeneratedValue
	private Long id; 
	private String utente; 
	private String tipo; 
	
	public Connessione(String utente, String tipo) {
		this(); 
		this.utente = utente; 
		this.tipo = tipo; 
	}
	
}
