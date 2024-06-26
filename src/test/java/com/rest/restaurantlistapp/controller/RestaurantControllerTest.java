package com.rest.restaurantlistapp.controller;

import com.google.common.base.Verify;
import com.rest.restaurantlistapp.entity.Restaurant;
import com.rest.restaurantlistapp.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

//import static reactor.core.publisher.Mono.when;

public class RestaurantControllerTest {


    @InjectMocks
    RestaurantController restaurantController;

    @Mock
    RestaurantService restaurantService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetAllRestaurants()
    {


        List<Restaurant> mockedRestaurants= Arrays.asList(
                new Restaurant(101,"Restaurant1","vzm","vzm city","desc"),
                new Restaurant(102,"Restaurant2","vzm","vzm city","desc")
        );


        Mockito.when(restaurantService.getAllRestaurants()).thenReturn(mockedRestaurants);



        ResponseEntity<List<Restaurant>> response=restaurantController.getAllRestaurants();

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(mockedRestaurants,response.getBody());

        verify(restaurantService,Mockito.times(1)).getAllRestaurants();



    }



    @Test
    public void testsSaveResturant()
    {
        Restaurant mockedRestaurant=new Restaurant(101,"Restaurant 1","vzm","vzm","desc");

        Mockito.when(restaurantService.saveRestaurant(mockedRestaurant)).thenReturn(mockedRestaurant);

        ResponseEntity<Restaurant> response=restaurantController.saveResturant(mockedRestaurant);


        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertEquals(mockedRestaurant,response.getBody());

    }


    @Test
    public void testGetRestaurantById()
    {
        int mockedRestId=101;

        Restaurant mockedRestaurant=new Restaurant(101,"Restaurant 1","vzm","vzm","desc");

        when(restaurantService.getRestaurantById(mockedRestId)).thenReturn(new ResponseEntity<>(mockedRestaurant,HttpStatus.OK));


        ResponseEntity<Restaurant> response=restaurantController.getRestaurantById(mockedRestId);


        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(mockedRestaurant,response.getBody());
        verify(restaurantService,times(1)).getRestaurantById(mockedRestId);
    }







}
