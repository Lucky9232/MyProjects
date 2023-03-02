package com.rating.RatingService.services.impl;

import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.repository.RatingRepository;
import com.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository ;
    @Override
    public Rating create(Rating rating) {

        String s = UUID.randomUUID().toString();
        rating.setRatingId(s);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllUserRating(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotel(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
