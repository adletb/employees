package org.backend.repo;

import org.backend.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {
    long findByName(String name);
}
