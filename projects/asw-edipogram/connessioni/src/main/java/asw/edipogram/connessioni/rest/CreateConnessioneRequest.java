package asw.edipogram.connessioni.rest;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateConnessioneRequest {

	private String utente; 
	private String tipo; 

}

