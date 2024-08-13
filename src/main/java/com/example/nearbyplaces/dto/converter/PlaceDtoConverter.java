package com.example.nearbyplaces.dto.converter;

import com.example.nearbyplaces.dto.PlaceDto;
import com.example.nearbyplaces.entity.Place;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class PlaceDtoConverter {
    public PlaceDto convertToDto(Place place) {

            PlaceDto dto = new PlaceDto();
            dto.setLatitude(place.getLatitude());
            dto.setLongitude(place.getLongitude());
            dto.setRadius(place.getRadius());
            return dto;

    }

}
