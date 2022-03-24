package asw.springboot.hello;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.util.logging.Logger; 

@Component
public class HelloRunner implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(HelloRunner.class.toString()); 

	public void run(String[] args) {
		logger.info("Hello, world!"); 
	}
}
