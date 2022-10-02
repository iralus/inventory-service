package com.iralus.inventory.repository;

import com.iralus.inventory.entity.Stakeholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeholderRepository extends JpaRepository<Stakeholder, Integer> {
}
