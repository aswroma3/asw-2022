package asw.edipogram.enigmiseguiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EnigmiSeguitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnigmiSeguitiApplication.class, args);
	}
}
