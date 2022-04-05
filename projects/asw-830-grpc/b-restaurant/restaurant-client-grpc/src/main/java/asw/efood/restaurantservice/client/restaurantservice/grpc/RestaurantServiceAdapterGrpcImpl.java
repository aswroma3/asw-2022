package asw.efood.restaurantservice.client.restaurantservice.grpc;

import asw.efood.restaurantservice.client.domain.*;

import asw.efood.restaurantservice.api.grpc.*;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.logging.Logger;
import java.util.*; 
import java.util.stream.*; 

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;

@Service
public class RestaurantServiceAdapterGrpcImpl implements RestaurantServiceAdapter {

    private Logger logger = Logger.getLogger(RestaurantServiceAdapterGrpcImpl.class.toString());

    private ManagedChannel channel;
    // private RestaurantServiceGrpc.RestaurantServiceBlockingStub blockingStub;
    private RestaurantServiceGrpc.RestaurantServiceFutureStub futureStub;

	@Value("${asw.efood.restaurantservice.grpc.host}")
    private String host;
	@Value("${asw.efood.restaurantservice.grpc.port}")
    private int port;

	@PostConstruct
    public void init() {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        // this.blockingStub = RestaurantServiceGrpc.newBlockingStub(channel);
        this.futureStub = RestaurantServiceGrpc.newFutureStub(channel);
	}

    @PreDestroy
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

	/* Tutte le operazioni remote vengono invocate usando il future stub. */ 

    public Long createRestaurant(String name, String location) {
        logger.info("Creating restaurant " + name);
		Long restaurantId = null; 
        CreateRestaurantRequest request = CreateRestaurantRequest.newBuilder()
                .setName(name)
                .setLocation(location)
                .build();
        try {
            ListenableFuture<CreateRestaurantReply> futureReply = futureStub.createRestaurant(request);
            CreateRestaurantReply reply = futureReply.get();
            if (reply != null) {
				restaurantId = reply.getRestaurantId();
                logger.info("Restaurant created with: " + restaurantId);
            } else {
                logger.info("Restaurant not created");
            }
        } catch (StatusRuntimeException e) {
            logger.info("RPC failed: " + e.getStatus());
        } catch (InterruptedException e) {
            logger.info("InterruptedException: " + e.toString());
        } catch (ExecutionException e) {
            logger.info("ExecutionException: " + e.toString());
        }
        return restaurantId;
    }

    public Restaurant getRestaurant(Long restaurantId) {
        logger.info("Looking for restaurant with " + restaurantId);
		Restaurant restaurant = null; 
        GetRestaurantRequest request = GetRestaurantRequest.newBuilder().setRestaurantId(restaurantId).build();
        try {
            ListenableFuture<GetRestaurantReply> futureReply = futureStub.getRestaurant(request);
            GetRestaurantReply reply = futureReply.get();
            if (reply != null) {
				restaurant = new Restaurant(reply.getRestaurantId(), reply.getName(), reply.getLocation()); 
                logger.info("Restaurant found: " + restaurant.toString());
            } else {
                logger.info("Restaurant not found");
            }
        } catch (StatusRuntimeException e) {
            logger.info("RPC failed: " + e.getStatus());
        } catch (InterruptedException e) {
            logger.info("InterruptedException: " + e.toString());
        } catch (ExecutionException e) {
            logger.info("ExecutionException: " + e.toString());
        }
        return restaurant;
    }

    public List<Restaurant> getAllRestaurants() {
        logger.info("Looking for all restaurants");
		List<Restaurant> restaurants = null; 
        GetAllRestaurantsRequest request = GetAllRestaurantsRequest.newBuilder().build();
        try {
            ListenableFuture<GetAllRestaurantsReply> futureReply = futureStub.getAllRestaurants(request);
            GetAllRestaurantsReply reply = futureReply.get();
            if (reply != null) {
				restaurants = reply.getRestaurantsList().stream()
					.map( restaurant -> new Restaurant(restaurant.getRestaurantId(), restaurant.getName(), restaurant.getLocation()) )
					.collect(Collectors.toList()); 
                logger.info("Restaurants found: " + restaurants.toString());
            } else {
                logger.info("Restaurants not found");
            }
        } catch (StatusRuntimeException e) {
            logger.info("RPC failed: " + e.getStatus());
        } catch (InterruptedException e) {
            logger.info("InterruptedException: " + e.toString());
        } catch (ExecutionException e) {
            logger.info("ExecutionException: " + e.toString());
        }
		return restaurants;
    }

}
