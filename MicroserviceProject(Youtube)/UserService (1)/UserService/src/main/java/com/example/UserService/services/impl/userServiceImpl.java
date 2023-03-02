package com.example.UserService.services.impl;

import com.example.UserService.entities.Hotel;
import com.example.UserService.entities.Rating;
import com.example.UserService.entities.User;
import com.example.UserService.exceptions.ResourceNotFoundException;
import com.example.UserService.external.services.HotelService;
import com.example.UserService.repositories.UserRepository;
import com.example.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository  userRepository ;

    @Autowired
    //its used to call api
    private RestTemplate restTemplate ;


    //instead of restTemplate use feign client
    @Autowired
    private HotelService hotelService ;

    private Logger logger= LoggerFactory.getLogger(userServiceImpl.class);
    // in the service we generate auto generated id;
    @Override
    public User saveUser(User user) {

        //generate unique userid

        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);


        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {

        //get user from db
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not fouond on server !! " + userId));
        // fetch rating of above user
        // http://localhost:8083/ratings/users/298d7a4d-c54c-4dc8-b5df-21696aba50d7

        Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{} ",ratingOfUser);

        List<Rating> ratings = Arrays.stream(ratingOfUser).collect(Collectors.toList());


        // microservice code to get hotel rating

        List<Rating> ratingList = (List<Rating>) ratings.stream().map(rating -> {
            //api call to hotel service to get hotel
            //http://localhost:8082/hotels/eea71d53-3eda-402f-8f8c-3ad575730a45

           // Hotel hotel = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class).getBody();
            //set the hotel to rating

            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;

    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
