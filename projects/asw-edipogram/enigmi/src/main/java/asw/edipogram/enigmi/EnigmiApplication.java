package asw.edipogram.enigmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient 
public class EnigmiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnigmiApplication.class, args);
	}
}
