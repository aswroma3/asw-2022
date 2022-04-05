package asw.efood.restaurantservice.client.domain;

import java.util.*; 

import java.util.concurrent.CompletableFuture;

public interface RestaurantAsyncServiceAdapter {
    CompletableFuture<Long> createRestaurantAsync(String name, String location);
    CompletableFuture<List<Restaurant>> getAllRestaurantsAsync();
    CompletableFuture<Restaurant> getRestaurantAsync(Long restaurantId);
}
