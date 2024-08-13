package com.example.nearbyplaces.service;

import com.example.nearbyplaces.dto.GooglePlacesResponse;
import com.example.nearbyplaces.dto.PlaceDto;
import com.example.nearbyplaces.dto.converter.PlaceDtoConverter;
import com.example.nearbyplaces.entity.Place;
import com.example.nearbyplaces.repository.PlaceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Locale;
import java.util.Optional;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceDtoConverter placeDtoConverter;
    private final RestTemplate restTemplate;
    private final ResourceService resourceService;



    public PlaceService(PlaceRepository placeRepository,
                        PlaceDtoConverter placeDtoConverter,
                        RestTemplate restTemplate,
                        ResourceService resourceService) {
        this.placeRepository = placeRepository;
        this.placeDtoConverter = placeDtoConverter;

        this.restTemplate = restTemplate;
        this.resourceService = resourceService;
    }


    public PlaceDto searchAndSavePlace(PlaceDto placeDto) {
      Optional<Place> optionalPlace = placeRepository.findByLatitudeAndAndLongitudeAndRadius(placeDto.getLatitude(),placeDto.getLongitude(),placeDto.getRadius());

        if(optionalPlace.isPresent()){
            return placeDtoConverter.convertToDto(optionalPlace.get());
        }
        Place place = new Place();
        place.setLatitude(placeDto.getLatitude());
        place.setLongitude(placeDto.getLongitude());
        place.setRadius(placeDto.getRadius());
       placeRepository.save(place);
    return placeDto;
    }

    public GooglePlacesResponse findResponseByGooglePlacesApi(PlaceDto placeDto){
        PlaceDto placeResponse = searchAndSavePlace(placeDto);
        String googlePlacesApiKey = resourceService.findByName("API_KEY");
        String url = String.format(
                Locale.US,
                "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%f,%f&radius=%f&key=%s",
                placeResponse.getLatitude(), placeResponse.getLongitude(), placeResponse.getRadius(), googlePlacesApiKey
        );
        ResponseEntity<GooglePlacesResponse> response = restTemplate.getForEntity(url, GooglePlacesResponse.class);
        return response.getBody();
    }
}
