package com.hotel.hotelService.controller;

import com.hotel.hotelService.entities.Hotel;
import com.hotel.hotelService.services.Hotelservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private Hotelservice hotelservice ;

    //create

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.create(hotel));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Hotel> getHotel(@PathVariable String id)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.getHotel(id));
    }


    @GetMapping()
    public ResponseEntity<List<Hotel>> getAllHotel(){
         return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.getHotelList());
    }

}
