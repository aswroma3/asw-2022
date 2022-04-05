package asw.efood.restaurantservice.grpc;

import asw.efood.restaurantservice.domain.*;

import asw.efood.restaurantservice.api.grpc.*;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;
import java.util.*; 
import java.util.stream.*; 

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Component
public class RestaurantServiceGrpcServer {

    private static final Logger logger = Logger.getLogger(RestaurantServiceGrpcServer.class.toString());

    @Autowired 
	private RestaurantService restaurantService;

	@Value("${asw.efood.restaurantservice.grpc.port}")
    private int port;

    private Server server;
	
    @PostConstruct
    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new RestaurantServiceImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
    }

    @PreDestroy
    public void stop() {
        if (server != null) {
            logger.info("*** shutting down gRPC server since JVM is shutting down");
            server.shutdown();
            logger.info("*** server shut down");
        }
    }

    private class RestaurantServiceImpl extends RestaurantServiceGrpc.RestaurantServiceImplBase {

        @Override
        public void createRestaurant(CreateRestaurantRequest req, StreamObserver<CreateRestaurantReply> responseObserver) {
            String name = req.getName();
            String location = req.getLocation();
			logger.info("gRPC CALL: createRestaurant " + name + ", " + location); 
            Restaurant restaurant = restaurantService.createRestaurant(name, location);
            CreateRestaurantReply reply = CreateRestaurantReply.newBuilder()
                    .setRestaurantId(restaurant.getId())
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void getRestaurant(GetRestaurantRequest req, StreamObserver<GetRestaurantReply> responseObserver) {
            Long restaurantId = req.getRestaurantId(); 
			logger.info("gRPC CALL: getRestaurant " + restaurantId); 
			Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
            GetRestaurantReply reply = GetRestaurantReply.newBuilder()
                        .setRestaurantId(restaurant.getId())
                        .setName(restaurant.getName())
                        .setLocation(restaurant.getLocation())
                        .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void getAllRestaurants(GetAllRestaurantsRequest req, StreamObserver<GetAllRestaurantsReply> responseObserver) {
			logger.info("gRPC CALL: getAllRestaurants"); 
			Collection<Restaurant> restaurants = restaurantService.getAllRestaurants();
			List<GetRestaurantReply> rr = 
				restaurants.stream() 
					.map(restaurant -> GetRestaurantReply.newBuilder()
                        .setRestaurantId(restaurant.getId())
                        .setName(restaurant.getName())
                        .setLocation(restaurant.getLocation())
                        .build())
					.collect(Collectors.toList()); 
            GetAllRestaurantsReply reply = GetAllRestaurantsReply.newBuilder()
                        .addAllRestaurants(rr)
                        .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
		
	}

}
