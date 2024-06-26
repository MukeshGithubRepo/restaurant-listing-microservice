package com.rest.restaurantlistapp.mapper;


import com.rest.restaurantlistapp.dto.RestaurantDto;
import com.rest.restaurantlistapp.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper instance= Mappers.getMapper(RestaurantMapper.class);


    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);

    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);

}
