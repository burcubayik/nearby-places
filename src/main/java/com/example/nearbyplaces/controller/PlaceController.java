package com.example.nearbyplaces.controller;

import com.example.nearbyplaces.dto.GooglePlacesResponse;
import com.example.nearbyplaces.dto.PlaceDto;
import com.example.nearbyplaces.service.PlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/places")
@CrossOrigin("https://nearby-places-fe.vercel.app/")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping()
    public ResponseEntity<GooglePlacesResponse> searchPlaces(@RequestBody PlaceDto placeDto){

           return ResponseEntity.ok(placeService.findResponseByGooglePlacesApi(placeDto)) ;

    }

}
