package asw.efood.restaurantservice.client.restaurantservice.rest;

import asw.efood.restaurantservice.client.domain.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;

import java.util.logging.Logger;

import java.util.*; 

@Service
public class RestaurantAsyncServiceAdapterRestImpl implements RestaurantAsyncServiceAdapter {

    private Logger logger = Logger.getLogger(RestaurantAsyncServiceAdapterRestImpl.class.toString());

	@Autowired
	private RestaurantServiceAdapter restaurantServiceAdapter;

    @Value("${asw.efood.restaurantservice.client.async.delay:0}")
    private int asyncDelay;

	@Async
	public CompletableFuture<Long> createRestaurantAsync(String name, String location) {
        logger.info("Creating restaurant " + name + " (async)");
		/* introduce un ritardo fittizio */ 
		sleep(asyncDelay); 
		return CompletableFuture.completedFuture(restaurantServiceAdapter.createRestaurant(name, location)); 
	} 
	
	@Async
	public CompletableFuture<Restaurant> getRestaurantAsync(Long restaurantId) {
        logger.info("Looking for restaurant with " + restaurantId + " (async)");
		/* introduce un ritardo fittizio */ 
		sleep(asyncDelay); 
		return CompletableFuture.completedFuture(restaurantServiceAdapter.getRestaurant(restaurantId)); 
	} 
	
	@Async
	public CompletableFuture<List<Restaurant>> getAllRestaurantsAsync() {
        logger.info("Looking for all restaurants (async)");
		/* introduce un ritardo fittizio */ 
		sleep(asyncDelay); 
		return CompletableFuture.completedFuture(restaurantServiceAdapter.getAllRestaurants()); 
	} 

	/* Introduce un ritardo di delay millisecondi. */
	private void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {}
	}

}
