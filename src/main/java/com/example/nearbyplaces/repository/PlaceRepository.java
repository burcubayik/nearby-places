package com.example.nearbyplaces.repository;

import com.example.nearbyplaces.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,String> {
}
