//package com.example.UserService.external.services;
//
//import com.example.UserService.entities.Rating;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//
////optinal class for this project.
//@FeignClient(name="RATING_SERVICE")
//public interface RatingService {
//
//
//    //post
//
//
//    @PostMapping("/ratings")
//    public Rating creatRating(Rating rating);
//
//    // put
//
//    @PutMapping("/ratings/{ratingId}")
//    public Rating updateRating(@PathVariable String ratingId, Rating rating);
//
//    //delete
//
//    @DeleteMapping("/ratings/{ratingId}")
//    public void deleteRating(@PathVariable String ratingId);
//}
