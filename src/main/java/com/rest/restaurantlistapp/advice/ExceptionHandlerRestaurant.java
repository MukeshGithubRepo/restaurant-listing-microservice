package com.rest.restaurantlistapp.advice;


import com.rest.restaurantlistapp.dto.Error;
import com.rest.restaurantlistapp.exceptions.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerRestaurant {


    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<Error> handleRestaurantNotFoundException(RestaurantNotFoundException ex) {


        Error e=new Error("resource not found",700);
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
}
