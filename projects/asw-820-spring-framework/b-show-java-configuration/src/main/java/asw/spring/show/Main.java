package asw.spring.show;

import asw.spring.show.config.ShowConfig; 

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	/* logger */
	private static Logger logger = Logger.getLogger("asw.spring.show");

	public static void main(String[] args) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(ShowConfig.class); 
    	Artist artist = (Artist) context.getBean("hendrix");
		logger.info( artist.perform() );
	}

}
