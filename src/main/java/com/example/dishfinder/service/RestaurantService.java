package com.example.dishfinder.service;

import com.example.dishfinder.dto.RestaurantDTO;
import com.example.dishfinder.model.Restaurant;
import com.example.dishfinder.repo.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> search(String term, int limit) {
        List<Restaurant> matches = restaurantRepository.findByNameContainingIgnoreCase(term);

        return matches.stream()
                .limit(limit)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private RestaurantDTO toDto(Restaurant restaurant) {
        return new RestaurantDTO(restaurant.getId(), restaurant.getName(), restaurant.getAddress());
    }
}

