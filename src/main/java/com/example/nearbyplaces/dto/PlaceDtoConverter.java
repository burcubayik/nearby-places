package com.example.nearbyplaces.dto;

import com.example.nearbyplaces.entity.Place;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class PlaceDtoConverter {
    public List<PlaceDto> convertToDto(List<Place> places) {
        return places.stream().map(place -> {
            PlaceDto dto = new PlaceDto();
            dto.setLatitude(place.getLatitude());
            dto.setLongitude(place.getLongitude());
            dto.setRadius(place.getRadius());
            return dto;
        }).collect(Collectors.toList());
    }



   /* private PlaceDto convertToDto(Place place) {
        PlaceDto dto = new PlaceDto();
        dto.setId(place.getId());
        dto.setName(place.getName());
        dto.setLatitude(place.getLatitude());
        dto.setLongitude(place.getLongitude());
        dto.setAddress(place.getAddress());
        return dto;
    }*/

}
