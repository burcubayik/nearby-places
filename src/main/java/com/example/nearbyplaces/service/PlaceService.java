package com.example.nearbyplaces.service;

import com.example.nearbyplaces.dto.PlaceDto;
import com.example.nearbyplaces.dto.PlaceDtoConverter;
import com.example.nearbyplaces.entity.Place;
import com.example.nearbyplaces.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceDtoConverter placeDtoConverter;

    public PlaceService(PlaceRepository placeRepository, PlaceDtoConverter placeDtoConverter) {
        this.placeRepository = placeRepository;
        this.placeDtoConverter = placeDtoConverter;
    }

    public List<PlaceDto> searchAndSavePlace(PlaceDto placeDto) {
       List<Place> placeList = placeRepository.findByLatitudeAndAndLongitudeAndRadius(placeDto);

        if(!placeList.isEmpty()){
            return placeDtoConverter.convertToDto(placeList);

        }
        return null;
    }
}
