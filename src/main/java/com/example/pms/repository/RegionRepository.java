package com.example.pms.repository;

import com.example.pms.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {

    Region getById(Integer id);

    List<Region> getAllByCityId(Integer cityId);

}
