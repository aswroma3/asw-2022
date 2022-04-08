package asw.efood.restaurantservice.domain;

import asw.efood.common.api.command.Command; 
import asw.efood.restaurantservice.api.command.*; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@Service
public class RestaurantCommandHandler {

    private final Logger logger = Logger.getLogger(RestaurantCommandHandler.class.toString());

	@Autowired
	private RestaurantService restaurantService;

	public void onCommand(Command command) {
		logger.info("PROCESSING COMMAND: " + command);
		if (command.getClass().equals(CreateRestaurantCommand.class)) {
			CreateRestaurantCommand crc = (CreateRestaurantCommand) command;
			createRestaurant(crc); 
//			restaurantService.createRestaurant(crc.getName(), crc.getLocation()); 
		} else {
			logger.info("UNKNOWN COMMAND: " + command);			
		}
	}
	
	private void createRestaurant(CreateRestaurantCommand command) {
		restaurantService.createRestaurant(command.getName(), command.getLocation()); 
	}

}

