package com.rest.restaurantlistapp.service;


import com.rest.restaurantlistapp.dto.RestaurantDto;
import com.rest.restaurantlistapp.entity.Restaurant;
import com.rest.restaurantlistapp.exceptions.RestaurantNotFoundException;
import com.rest.restaurantlistapp.mapper.RestaurantMapper;
import com.rest.restaurantlistapp.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<Restaurant> getAllRestaurants()
    {
        List<Restaurant> restaurants=restaurantRepo.findAll();
        return restaurants;
    }


    public ResponseEntity<Restaurant> getRestaurantById(int id)
    {
        Optional<Restaurant> restaurant= restaurantRepo.findById(id);

        if(restaurant.isEmpty())
        {
            throw new RestaurantNotFoundException("Restaurant not found with id:"+id);
        }
        else {
            return new ResponseEntity<>(restaurant.get(),HttpStatus.OK);
        }
    }


    public Restaurant saveRestaurant(Restaurant restaurant)
    {
        Restaurant savedRestaurant=restaurantRepo.save(restaurant);
        return  savedRestaurant;
    }


    public void deleteRestaurant(Restaurant restaurant)
    {
        restaurantRepo.delete(restaurant);
    }
}
