package com.hotel.hotelService.services;

import com.hotel.hotelService.entities.Hotel;

import java.util.List;

public interface Hotelservice {
    Hotel create(Hotel hotel);

    Hotel getHotel(String id);


    List<Hotel> getHotelList();


}
