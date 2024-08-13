package com.example.nearbyplaces.repository;

import com.example.nearbyplaces.dto.PlaceDto;
import com.example.nearbyplaces.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place,String> {
   Optional<Place> findByLatitudeAndAndLongitudeAndRadius(double latitude, double longitude, double radius);;
}
