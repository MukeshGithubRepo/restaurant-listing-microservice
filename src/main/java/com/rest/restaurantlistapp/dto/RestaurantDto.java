package com.rest.restaurantlistapp.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantDto {

    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;

}
