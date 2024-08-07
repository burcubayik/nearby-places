package com.example.nearbyplaces.service;

import com.example.nearbyplaces.repository.PlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
}
