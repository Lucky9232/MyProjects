package com.rating.RatingService.controller;

import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService ;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating )
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRating()
    {
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getAllUserRating(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotel(hotelId));
    }
}
