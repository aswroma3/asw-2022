package asw.edipogram.enigmiseguiti.domain;

import lombok.*; 

/* Enigma (in formato breve, senza soluzione). */ 
@Data @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Enigma implements Comparable<Enigma> {

	@EqualsAndHashCode.Include
	private Long id; 
	private String autore; 
	private String tipo; 
	private String tipoSpecifico; 
	private String titolo; 
	private String[] testo; 

	@Override
	public int compareTo(Enigma other) {
		return this.id.compareTo(other.id); 
	}
	
}
