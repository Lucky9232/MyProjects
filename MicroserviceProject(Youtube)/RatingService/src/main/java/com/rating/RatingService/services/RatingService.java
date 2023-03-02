package com.rating.RatingService.services;

import com.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //get all rating
    List<Rating> getAllRating();

    //get all rating by userId
    List<Rating> getAllUserRating(String userId);

    //Get all by hotel

    List<Rating>  getRatingByHotel(String hotelId);
}
