package com.iralus.inventory.repository;

import com.iralus.inventory.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {
    Rate findByRateName(String rateName);
}
