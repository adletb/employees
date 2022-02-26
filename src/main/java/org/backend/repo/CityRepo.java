package org.backend.repo;

import org.backend.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepo  extends JpaRepository<City, Long> {
    List<City> findByCountry(int country);
}
