package com.example.nearbyplaces.service;

import com.example.nearbyplaces.repository.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public String findByName(String name){

        return resourceRepository.findByName(name).getValue();
    }
}
