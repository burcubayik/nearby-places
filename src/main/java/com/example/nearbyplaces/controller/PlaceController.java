package com.example.nearbyplaces.controller;

import com.example.nearbyplaces.dto.PlaceDto;
import com.example.nearbyplaces.service.PlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/places")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping()
    public List<PlaceDto> searchPlaces(PlaceDto placeDto){
        return placeService.searchAndSavePlace(placeDto);
    }

}
