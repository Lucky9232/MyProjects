package com.hotel.hotelService.services.impl;

import com.hotel.hotelService.entities.Hotel;
import com.hotel.hotelService.exception.ResourceNotFoundException;
import com.hotel.hotelService.repositiries.HotelRepository;
import com.hotel.hotelService.services.Hotelservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements Hotelservice {

    @Autowired
    private HotelRepository hotelRepository ;
    @Override
    public Hotel create(Hotel hotel) {


        String s = UUID.randomUUID().toString();
        hotel.setId(s);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found !! " +id));
    }

    @Override
    public List<Hotel> getHotelList() {
        return hotelRepository.findAll();
    }
}
