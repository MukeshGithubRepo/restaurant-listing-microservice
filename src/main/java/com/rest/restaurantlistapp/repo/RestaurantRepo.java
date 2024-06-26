package com.rest.restaurantlistapp.repo;

import com.rest.restaurantlistapp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {
}
