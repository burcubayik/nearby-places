package com.example.nearbyplaces.repository;

import com.example.nearbyplaces.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource,String> {
    Resource findByName(String name);
}
