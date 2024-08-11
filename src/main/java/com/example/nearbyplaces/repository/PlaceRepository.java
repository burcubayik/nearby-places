package com.example.nearbyplaces.repository;

import com.example.nearbyplaces.dto.PlaceDto;
import com.example.nearbyplaces.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place,String> {
   List<Place>  findByLatitudeAndAndLongitudeAndRadius(PlaceDto placeDto);
}
