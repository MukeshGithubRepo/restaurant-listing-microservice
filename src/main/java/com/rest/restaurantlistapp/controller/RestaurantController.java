package com.rest.restaurantlistapp.controller;


import com.rest.restaurantlistapp.dto.RestaurantDto;
import com.rest.restaurantlistapp.entity.Restaurant;
import com.rest.restaurantlistapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping("/restaurant")
public class RestaurantController {


    @Autowired
    RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants=restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants,HttpStatus.OK);
    }


    @GetMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") int id)
    {
        return restaurantService.getRestaurantById(id);
    }


    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> saveResturant(@RequestBody Restaurant restaurant)
    {
        Restaurant savedRestaurant=restaurantService.saveRestaurant(restaurant);
        return new ResponseEntity<>(savedRestaurant,HttpStatus.CREATED);
    }


    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable("id") int id)
    {
        ResponseEntity<Restaurant> deleteRestaurant=restaurantService.getRestaurantById(id);
        restaurantService.deleteRestaurant(deleteRestaurant.getBody());
        return new ResponseEntity(HttpStatus.OK);
    }


//    @PutMapping("/restaurant")
//    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant)
//    {
//
//
//        if(restaurant.)
//    }


}
